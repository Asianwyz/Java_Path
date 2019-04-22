package JDBC;


import java.sql.*;
import java.util.Scanner;

public class _08JDBCLogin {

    public static void main(String[] args) {
        // 键盘输入用户名和密码
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = in.nextLine();
        System.out.println("请输入密码");
        String password = in.nextLine();
        // 调用方法
        boolean flag = new _08JDBCLogin().login2(username,password);
        // 判断结果
        if (flag){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }
    }

    /**
     * 登录方法
     */
    public boolean login(String username, String password){
        if (username == null || password == null){
            return false;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        // 连接数据库判断是否登录成功
        try {
            // 1. 获取连接
            connection = JDBCUtils.getConnection();
            // 2. 定义SQL
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            // 3. 获取执行SQL的对象
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login2(String username, String password){
        if (username == null || password == null){
            return false;
        }

        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1. 获取连接
            connection = JDBCUtils.getConnection();
            // 2. 定义SQL
            String sql = "select * from user where username = ? and password = ?";
            // 3. 获取执行sql的对象
            pst = connection.prepareStatement(sql);
            // 给？赋值
            pst.setString(1,username);
            pst.setString(2,password);
            // 4. 执行查询，不需要传递sql
            rs = pst.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
