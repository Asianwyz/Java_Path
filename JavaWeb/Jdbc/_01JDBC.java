package JDBC;

/**
 * JDBC快速入门
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class _01JDBC {
    public static void main(String[] args) throws Exception{
        // 1. 导入驱动jar包
        // 2. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        // 3. 获取数据库连接对象
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/asia", "root", "root");
        Connection connection = DriverManager.getConnection("jdbc:mysql://:3306/asia", "root", "root");
        // 4. 定义sql语句
        String sql = "update account set balance = 500 where id = 1";
        // 5. 获取执行sql的对象 Statement
        Statement stmt = connection.createStatement();
        // 6. 执行sql
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        connection.close();
    }
}


