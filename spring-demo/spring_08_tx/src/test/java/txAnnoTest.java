import com.zyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/27 22:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean_anno.xml")
public class txAnnoTest {

    @Autowired
    private AccountService accountService2;

    @Test
    public  void testTransfer(){
        accountService2.transfer("aaa","bbb",100f);

    }
}
