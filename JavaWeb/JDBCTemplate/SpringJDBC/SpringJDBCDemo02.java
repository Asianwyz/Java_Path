package JDBCTemplate.SpringJDBC;

import JDBCTemplate.Emp;
import JDBCTemplate.druid.DruidJDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SpringJDBCDemo02 {
    // Junit 单元测试，可以让方法独立执行

    // 1. 获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());

    /**
     * 1. 修改1号数据的salary为10000
     */
    @Test
    public void test1(){
        // 2. 定义sql
        String sql = "update emp set salary = 10000 where id = 1001";
        // 3. 执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql,1015,"郭嘉",10);
        System.out.println(count);
    }

    /**
     * 3. 删除刚才添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 4. 查询id为1001的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String,Object> map = template.queryForMap(sql,1001);
//        String sql = "select * from emp where id = ? or id = ?";
//        Map<String,Object> map = template.queryForMap(sql,1001,1002);
//          Incorrect result size: expected 1, actual 2
        System.out.println(map);
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String,Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list){
            System.out.println(stringObjectMap);
        }
    }

    @Test
    public void test6(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String enmae = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象，并赋值
                emp.setId(id);
                emp.setEname(enmae);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoin_date(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });

        for (Emp emp:list){
            System.out.println(emp);
        }
    }

    /**
     * 6.2 查询所有记录
     */
    @Test
    public void test6_2(){
        String sql = "Select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数
     */
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
