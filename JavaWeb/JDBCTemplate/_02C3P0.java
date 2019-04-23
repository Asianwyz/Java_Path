package JDBCTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 验证配置信息
 */

public class _02C3P0 {
    public static void main(String[] args) throws Exception {
//        // 1. 获取DataSource，使用默认配置
//        DataSource ds = new ComboPooledDataSource();
//        // 2. 获取连接
//        for (int i = 0; i < 11; i++) {
//            Connection conn = ds.getConnection();
//            System.out.println(i + "   "+ conn);
//
//            if (i == 5){
//                conn.close();
//            }
//        }
        test();
    }

    public static void test() throws Exception{
        // 1.1 获取制定名称的Datasource
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 9; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + "  " + conn);
        }
    }
}
