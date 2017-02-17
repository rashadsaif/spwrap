package spwrap.result;

import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;

import spwrap.CallException;

final class ResultSetWrapper extends Result<ResultSet> {

	ResultSetWrapper(ResultSet wrappedObject) {
		super(wrappedObject);
	}

	@Override
	public String getString(int columnIndex) {
		try {
			return wrappedObject.getString(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public boolean getBoolean(int columnIndex) {
		try {
			return wrappedObject.getBoolean(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public byte getByte(int columnIndex) {
		try {
			return wrappedObject.getByte(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public short getShort(int columnIndex) {
		try {
			return wrappedObject.getShort(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public int getInt(int columnIndex) {
		try {
			return wrappedObject.getInt(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public long getLong(int columnIndex) {
		try {
			return wrappedObject.getLong(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public float getFloat(int columnIndex) {
		try {
			return wrappedObject.getFloat(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public double getDouble(int columnIndex) {
		try {
			return wrappedObject.getDouble(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public byte[] getBytes(int columnIndex) {
		try {
			return wrappedObject.getBytes(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Date getDate(int columnIndex) {
		try {
			return wrappedObject.getDate(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Time getTime(int columnIndex) {
		try {
			return wrappedObject.getTime(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) {
		try {
			return wrappedObject.getTimestamp(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public <U> U getObject(int columnIndex, Class<U> clazz) {
		try {
			return wrappedObject.getObject(columnIndex, clazz);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Reader getCharacterStream(int columnIndex) {
		try {
			return wrappedObject.getCharacterStream(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) {
		try {
			return wrappedObject.getBigDecimal(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Ref getRef(int columnIndex) {
		try {
			return wrappedObject.getRef(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Blob getBlob(int columnIndex) {
		try {
			return wrappedObject.getBlob(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Clob getClob(int columnIndex) {
		try {
			return wrappedObject.getClob(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Array getArray(int columnIndex) {
		try {
			return wrappedObject.getArray(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public URL getURL(int columnIndex) {
		try {
			return wrappedObject.getURL(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public RowId getRowId(int columnIndex) {
		try {
			return wrappedObject.getRowId(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public NClob getNClob(int columnIndex) {
		try {
			return wrappedObject.getNClob(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) {
		try {
			return wrappedObject.getSQLXML(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public String getNString(int columnIndex) {
		try {
			return wrappedObject.getNString(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) {
		try {
			return wrappedObject.getNCharacterStream(columnIndex);
		} catch (SQLException e) {
			throw new CallException(e);
		}
	}

}