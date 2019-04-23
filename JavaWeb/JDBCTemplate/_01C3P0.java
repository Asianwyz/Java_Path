package JDBCTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0的演示
 */

public class _01C3P0 {
    public static void main(String[] args) throws SQLException {
        // 1. 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接对象
        Connection conn = ds.getConnection();
        // 3. 打印
        System.out.println(conn);
    }
}
