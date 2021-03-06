package spwrap

import spock.lang.Specification
import uk.org.lidalia.slf4jtest.TestLogger
import uk.org.lidalia.slf4jtest.TestLoggerFactory

import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

import static uk.org.lidalia.slf4jext.Level.*

class UtilTest extends Specification {

    TestLogger logger = TestLoggerFactory.getTestLogger(Util)

    def cleanup() {
        TestLoggerFactory.clear()
    }

    def "test listToString"() {
        given:
            def list = Arrays.asList("HELLO", "WORLD")
        when:
            def listToString = Util.listToString(list)
        then:
            listToString == "HELLO\nWORLD\n"
    }

    def "test listToString when list is null"() {
        given:
            def list = null
        when:
            def listToString = Util.listToString(list)
        then:
            listToString == ""
    }

    def "closeDBObjects when result set throws SQLException"() {
        given:
            def resultSetMock = Mock(ResultSet)
            resultSetMock.close() >> { throw new SQLException("xxxx") }
        when:
            Util.closeDBObjects(null, null, resultSetMock)
        then:
            with(logger.loggingEvents.get(0)){
                level == TRACE
                throwable.get().class == SQLException
            }
    }

    def "closeDBObjects when result set throws RuntimeException"() {
        given:
            def resultSetMock = Mock(ResultSet)
            resultSetMock.close() >> { throw new RuntimeException("xxxx") }
        when:
            Util.closeDBObjects(null, null, resultSetMock)
        then:
            with(logger.loggingEvents.get(0)){
                level == TRACE
                throwable.get().class == RuntimeException
            }
    }

    def "closeDBObjects when statement throws SQLException"() {
        given:
            def statementMock = Mock(Statement)
            statementMock.close() >> { throw new SQLException("xxxx") }
        when:
            Util.closeDBObjects(null, statementMock, null)
        then:
            with(logger.loggingEvents.get(0)){
                level == TRACE
                throwable.get().class == SQLException
            }
    }

    def "closeDBObjects when statement throws RuntimeException"() {
        given:
            def statementMock = Mock(Statement)
            statementMock.close() >> { throw new RuntimeException("xxxx") }
        when:
            Util.closeDBObjects(null, statementMock, null)
        then:
            with(logger.loggingEvents.get(0)){
                level == TRACE
                throwable.get().class == RuntimeException
            }
    }

    def "closeDBObjects when connection throws SQLException"() {
        given:
            def connectionMock = Mock(Connection)
            connectionMock.close() >> { throw new SQLException("xxxx") }
        when:
            Util.closeDBObjects(connectionMock, null, null)
        then:
            with(logger.loggingEvents.get(0)){
                level == ERROR
                throwable.get().class == SQLException
            }
    }

    def "closeDBObjects when connection throws RuntimeException"() {
        given:
            def connectionMock = Mock(Connection)
            connectionMock.close() >> { throw new RuntimeException("xxxx") }
        when:
            Util.closeDBObjects(connectionMock, null, null)
        then:
            with(logger.loggingEvents.get(0)){
                level == ERROR
                throwable.get().class == RuntimeException
            }
    }

    def "getAsString returns the correct value"(){
        when:
            def string = Util.getAsString(-7)
        then:
            string == "BIT"
    }
}
