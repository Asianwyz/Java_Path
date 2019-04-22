package JDBC;

/**
 * JDBC工具类
 */


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static {
        // 读取资源文件，获取值

        try {
            // 1. Properties集合类
            Properties pro = new Properties();
            // 获取src路径下的文件，通过ClassLoader实现
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//            System.out.println(classLoader);
            URL resource = classLoader.getResource("jdbc.properties");
//            System.out.println(resource);
            String path = resource.getPath();

//            System.out.println(path);
            // 2. 加载文件
//            pro.load(new FileReader(path));
            pro.load(new FileReader("src/jdbc.properties"));
            // 3. 获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            // 4. 注册驱动
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return  连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection){
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

            }
        }
    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }
}
