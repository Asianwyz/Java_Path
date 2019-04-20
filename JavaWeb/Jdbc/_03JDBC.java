package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _03JDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/asia","root","root");
            // 3. 定义SQL
            String sql = "update account set balance = 2000 where id = 2";
            // 4. 获取执行sql对象
            statement = connection.createStatement();
            // 5. 执行sql
            int count = statement.executeUpdate(sql);
            // 6. 处理结果
            if (count > 0){
                System.out.println("修改成功");
            }
            else{
                System.out.println("修改失败");
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
