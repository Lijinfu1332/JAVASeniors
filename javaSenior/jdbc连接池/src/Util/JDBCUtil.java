package Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    private static ComboPooledDataSource cpds=new ComboPooledDataSource("c3p0");
    public static Connection getConnection() throws SQLException {
        Connection connection=cpds.getConnection();
        return connection;
    }
}
