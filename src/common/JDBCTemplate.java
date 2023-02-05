package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
    private static Connection conn;
    private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "MINIPROJECT";
    private static final String PASSWORD = "12345";

    private JDBCTemplate(){}

    public static Connection getConnection(){
        try {
            if(conn == null || conn.isClosed()){
                Class.forName(DRIVER_NAME);
                conn = DriverManager.getConnection(URL,USER,PASSWORD);
                conn.setAutoCommit(false);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void commit(Connection conn){
        try {
            if(conn != null && !conn.isClosed()){
                conn.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()){
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
