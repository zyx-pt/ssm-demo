import com.zyx.dao.AccountDao;
import com.zyx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * <pre>
 * 描述：测试MyBatis独立运行
 * </pre>
 *
 * @Author zhengyongxian
 * @Date 2020/9/30 13:29
 * @Description: TODO
 */

public class MyBatisTest {

    /**
     * 测试保存
     */
    @Test
    public void testSave() throws Exception {
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(400d);
        InputStream in = Resources.getResourceAsStream("config/mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session= factory.openSession();
        AccountDao aDao = session.getMapper(AccountDao.class);
        aDao.save(account);
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询
     */
    @Test
    public void testFindAll() throws Exception {
        InputStream in = Resources.getResourceAsStream("config/mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao aDao = session.getMapper(AccountDao.class);
        List<Account> list = aDao.findAll();
        System.out.println(list);
        session.close();
        in.close();
    }
}
