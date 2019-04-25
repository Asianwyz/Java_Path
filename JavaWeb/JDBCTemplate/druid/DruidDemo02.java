package JDBCTemplate.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 使用Druid工具类
 */

public class DruidDemo02 {
    public static void main(String[] args) {
        /**
         * 完成添加操作：给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. 获取连接
            conn = DruidJDBCUtils.getConnection();
            // 2. 定义sql
            String sql = "insert into account values(null,?,?)";
            // 3. 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 4. 给？赋值
            pstmt.setString(1,"asia");
            pstmt.setDouble(2,2000000);
            // 5. 执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6. 释放资源
            try {
                DruidJDBCUtils.close(pstmt,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
