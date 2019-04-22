package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class _07JDBC {

    public static void main(String[] args) {
        List<Emp> list = new _07JDBC().findALL2();
        System.out.println(list);
        System.out.println(list.size() );
    }

    /**
     * 查询所有emp对象
     * @return
     */
    public List<Emp> findALL(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            // 1. 注册驱动c
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/heima","root","root");
            // 3. 定义sql
            String sql = "Select * from emp";
            // 4. 获取执行sql对象
            statement = connection.createStatement();
            // 5. 执行sql
            rs = statement.executeQuery(sql);
            // 6. 处理结果
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()){
                // 获取数据
                int id = rs.getInt("id");
                String enmae = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象，并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setEname(enmae);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoin_date(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                // 装载集合
                list.add(emp);

            }
      } catch (ClassNotFoundException e) {
            e.printStackTrace();
      } catch (SQLException e) {
            e.printStackTrace();
      }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return list;
    }


    /**
     * 演示JDBC工具类
     * @return
     */
    public List<Emp> findALL2(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            connection = JDBCUtils.getConnection();
            // 3. 定义sql
            String sql = "Select * from emp";
            // 4. 获取执行sql对象
            statement = connection.createStatement();
            // 5. 执行sql
            rs = statement.executeQuery(sql);
            // 6. 处理结果
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()){
                // 获取数据
                int id = rs.getInt("id");
                String enmae = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象，并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setEname(enmae);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoin_date(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                // 装载集合
                list.add(emp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
//            JDBCUtils.close(rs,statement,connection);
        }
        return list;
    }
}
