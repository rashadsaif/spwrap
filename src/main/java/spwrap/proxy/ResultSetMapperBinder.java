package spwrap.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spwrap.CallException;
import spwrap.mappers.ResultSetMapper;
import spwrap.Tuple;
import spwrap.annotations.Mapper;

class ResultSetMapperBinder extends MapperBinder<ResultSetMapper<?>> {

	private static final int FIRST_GENERIC_TYPE_INDEX = 0;
	private static Logger log = LoggerFactory.getLogger(ResultSetMapperBinder.class);

	@SuppressWarnings("unchecked")
	public ResultSetMapper<?> fromAnnotation(Method method) {

		Mapper mapperAnnotation = method.getAnnotation(Mapper.class);
		if (mapperAnnotation != null) {

			Class<ResultSetMapper<?>> clazz = null;

			for (Class<?> c : mapperAnnotation.value()) {
				if (ResultSetMapper.class.isAssignableFrom(c)) {
					if (clazz != null) {
						throw new CallException("ResultSetMapper is already registered");
					}
					clazz = (Class<ResultSetMapper<?>>) c;
				}
			}

			if (clazz != null) {
				ResultSetMapper<?> instance = newInstance(clazz);
				log.debug("found annotation result set: {} for method: {}", instance.getClass(), method.getName());
				return instance;
			}
		}
		return null;
	}

	public ResultSetMapper<?> fromReturnType(Method method) {
		ResultSetMapper<?> resultSetMapper = null;

		if (List.class.isAssignableFrom(method.getReturnType())
				|| Tuple.class.isAssignableFrom(method.getReturnType())) {

			ParameterizedType listType = (ParameterizedType) method.getGenericReturnType();
			Class<?> clazz = (Class<?>) listType.getActualTypeArguments()[FIRST_GENERIC_TYPE_INDEX];

			if (ResultSetMapper.class.isAssignableFrom(clazz)) {
				resultSetMapper = newInstance(clazz);
				log.debug("found return type result set: {} for method: {}", resultSetMapper.getClass(),
						method.getName());
			}
		}
		return resultSetMapper;
	}

	private ResultSetMapper<?> newInstance(Class<?> clazz) {
		try {
			return (ResultSetMapper<?>) clazz.newInstance();
		} catch (Exception e) {
			throw new CallException("cannot create resultSet Mapper", e);
		}
	}
}
