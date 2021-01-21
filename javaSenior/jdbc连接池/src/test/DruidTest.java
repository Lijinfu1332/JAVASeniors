package test;

import Util.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DruidTest {
    @Test
    public void getConnection() throws Exception{
        Properties pro=new Properties();
        //读取配置文件
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pro.load(resourceAsStream);
        DataSource dataSource=DruidDataSourceFactory.createDataSource(pro);
        Connection conn=dataSource.getConnection();
        System.out.println(conn);
        QueryRunner runner=new QueryRunner();
        String sql=("insert into provence(id,name) values(?,?)");
        runner.update(conn,sql,16,"张三");
        conn.close();
    }
    @Test
    public void druidTest2(){
        Connection conn=null;
        try {
        conn= JDBCUtils.getConnection();
        QueryRunner runner=new QueryRunner();
        String sql="delete from mydb where id = 12";
        runner.update(conn,sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
            System.out.println("执行成功");
        }
    }
    @Test
    public void test3(){
        Connection conn=null;
        try{
            QueryRunner runner=new QueryRunner();
            conn=JDBCUtils.getConnection();
            String sql="select id,name from provence where id<?";
            BeanHandler<province> handler=new BeanHandler<province>(province.class);
            province query = runner.query(conn, sql, handler, "100");
            System.out.println(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
    }
    @Test
    public void test4(){
        Connection conn=null;
        try{
            QueryRunner runner=new QueryRunner();
            conn=JDBCUtils.getConnection();
            String sql="select ids,name,password,email from user where ids<?";
            BeanListHandler<user> handler=new BeanListHandler<user>(user.class);
            List<user> query = runner.query(conn, sql, handler, 6);
           query.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
    }
    @Test
    public void test5(){
        Connection conn=null;
        try{
            QueryRunner runner=new QueryRunner();
            conn=JDBCUtils.getConnection();
            String sql="select ids,name,password,email from user where ids=?";
            MapHandler handler=new MapHandler();
            Map<String, Object> query = runner.query(conn, sql, handler, 3);
            System.out.println(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
    }
    @Test
    public void test6(){
        Connection conn=null;
        try{
            QueryRunner runner=new QueryRunner();
            conn=JDBCUtils.getConnection();
            String sql="select ids,name,password,email from user where ids<?";
            MapListHandler handler=new MapListHandler();
            List<Map<String, Object>> query = runner.query(conn, sql, handler, 6);
            query.forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
    }
    /*
    ScalarHandler:用于查询特殊值
     */
    @Test
    public void test7(){
        Connection conn=null;
        try{
            QueryRunner runner=new QueryRunner();
            conn=JDBCUtils.getConnection();
            String sql="select count(*) from user ";
            String sql1="select max(ids) from user ";
            ScalarHandler handler=new ScalarHandler();
            long query = (long) runner.query(conn, sql, handler);
            int query1= (int) runner.query(conn,sql1,handler);
            System.out.println(query);
            System.out.println(query1);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
    }
}
