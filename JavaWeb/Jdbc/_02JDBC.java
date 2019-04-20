package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _02JDBC {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection connection = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 定义SQL
            String sql = "insert into account values(null,'asia',200000)";
            // 3. 获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/asia", "root", "root");
            // 4. 执行获取SQL的对象 Statement
            stmt = connection.createStatement();
            // 5. 执行sql
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
