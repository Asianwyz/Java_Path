package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */

public class _10JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        try {
            // 1. 建立连接
            conn = JDBCUtils.getConnection();

            /**
             * 开启事务
             */
            conn.setAutoCommit(false);

            // 2. 定义sql
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            // 3. 获取执行sql的对象
            pst1 = conn.prepareStatement(sql1);
            pst2 = conn.prepareStatement(sql2);
            // 4. 设置参数
            pst1.setDouble(1,500);
            pst1.setInt(2,1);
            pst2.setDouble(1,500);
            pst2.setInt(2,2);
            // 5. 执行sql
            pst1.executeUpdate();
//            int i = 3/0;
            pst2.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }

    }
}
