import com.zyx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 描述：测试Spring独立运行
 * </pre>
 *
 * @Author zhengyx
 * @Date 2020/9/30 11:16
 * @Description: TODO
 */

public class SpringTest {

    @Test
    public void testSpring(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("config/applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.findAllAccount();

    }
}
