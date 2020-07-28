import com.zyx.config.SpringConfig;
import com.zyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/28 16:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class txWithJavaTest {

    @Autowired
    private AccountService accountService;

    @Test
    public  void testTransfer(){
        accountService.transfer("aaa","bbb",100f);

    }

}
