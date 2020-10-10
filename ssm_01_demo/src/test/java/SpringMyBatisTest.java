import com.zyx.domain.Account;
import com.zyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * <pre>
 * 描述：测试 spring 整合 mybatis
 * </pre>
 *
 * @Author zhengyongxian
 * @Date 2020/10/9 22:59
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/applicationContext.xml"})
public class SpringMyBatisTest {

    @Autowired
    private AccountService accountService;
    @Test
    public void testFindAll() {
        List list = accountService.findAllAccount();
        System.out.println(list);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("测试账号");
        account.setMoney(1234d);
        accountService.saveAccount(account);
    }
}
