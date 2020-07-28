import com.zyx.entity.model.Account;
import com.zyx.jdbctemplate.AccountRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @Description: JdbcTemplate的CRUD操作
 * @Author zhengyongxian
 * @Date 2020/7/23 19:15
 */
public class JdbcTemplateDemo {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        // 获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_xml.xml");
        // 获取对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行操作
        // 增加
        jdbcTemplate.execute("insert into account(name, money)values('hehe', 10000)");
        // 删除
        jdbcTemplate.update("delete from account where id=?",6);
        // 修改
        jdbcTemplate.update("update account set name=?, money=? where id=?", "zyx+hh", 20000f, 4);
        //查询所有
        List<Account> accounts = jdbcTemplate.query("select * from account where money > ?",new AccountRowMapper(),1000f);
        List<Account> accounts2 = jdbcTemplate.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
        for(Account account : accounts){
            System.out.println(account);
        }
        // 查询一个
        List<Account> accounts3 = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts3.isEmpty()? "没有内容" : accounts3.get(0));

        // 查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Long.class,1000f);
        System.out.println(count);

    }

    private static void test1() {
        // 准备数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring_test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源
        jdbcTemplate.setDataSource(dataSource);
        // 执行操作
        jdbcTemplate.execute("insert into account(name, money)values('zyx',10000)");
    }
}
