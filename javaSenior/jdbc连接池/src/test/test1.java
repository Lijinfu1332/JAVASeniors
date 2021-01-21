package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


public class test1 {
    //使用代码读取配置
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        //加载驱动
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        //获取链接
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false");
        cpds.setUser("root");
        cpds.setPassword("532233");
        cpds.setInitialPoolSize(10);
        Connection conn=cpds.getConnection();
        System.out.println(conn);
        //关闭连接池
        DataSources.destroy(cpds);
    }
    //使用xml配置文件连接数据库
    @Test
    public void test2() throws SQLException {
        ComboPooledDataSource cpds=new ComboPooledDataSource("c3p0");
        Connection conn=cpds.getConnection();
        System.out.println(conn);
    }
}
