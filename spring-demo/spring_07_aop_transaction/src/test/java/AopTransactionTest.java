import com.zyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/25 18:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean_aop_xml.xml")
public class AopTransactionTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transfer("aaa", "bbb", 100F);
    }
}
