import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-anno.xml")
public class AnnoCURDTest {

    @Autowired
    private AccountService accountService2;

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = accountService2.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = accountService2.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //3.执行方法
        accountService2.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = accountService2.findAccountById(4);
        account.setMoney(23456f);
        accountService2.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        accountService2.deleteAccount(4);
    }
}
