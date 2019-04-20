package JDBC;

import java.sql.*;

public class _06JDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/asia","root","root");
            // 3. 定义SQL
            String sql = "select * from account";
            // 4. 获取执行sql对象
            statement = connection.createStatement();
            // 5. 执行sql
            rs = statement.executeQuery(sql);
            // 6. 处理结果
            // 6.1 让游标移动一行
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double balance = rs.getDouble(3);
                System.out.println(id + "------" + name + "------" + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            if (statement != null){
                try {
                    statement.close();
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
