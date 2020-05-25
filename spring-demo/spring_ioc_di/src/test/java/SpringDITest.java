import com.zyx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhengyongxian
 * @Date 2020/5/22
 */
public class SpringDITest {
    
    @Test
    public void testDI(){
        // 1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-di.xml");
        // 2.根据id获取Bean对象
        AccountService accountService1  = (AccountService)ac.getBean("accountService");
        accountService1.saveAccount();

        AccountService accountService2  = (AccountService)ac.getBean("accountService2");
        accountService2.saveAccount();

        AccountService accountService22  = (AccountService)ac.getBean("accountService22");
        accountService22.saveAccount();

        AccountService accountService3  = (AccountService)ac.getBean("accountService3");
        accountService3.saveAccount();

    }


}
