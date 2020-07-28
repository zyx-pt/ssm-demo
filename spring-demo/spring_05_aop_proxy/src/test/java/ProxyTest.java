import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class ProxyTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountService proxyAccountService;

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100f);
    }

    @Test
    public void testTransferWithBindThread(){
        proxyAccountService.transferWithBindThead("aaa","bbb",100f);
    }

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }


}
