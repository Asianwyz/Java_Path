package JDBCTemplate.SpringJDBC;

import JDBCTemplate.druid.DruidJDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate 入门
 */
public class SpringJDBCDemo01 {
    public static void main(String[] args) {
        // 1. 导入Jar包
        // 2. 创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        // 3. 调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql,2);
        System.out.println(count);
    }
}
