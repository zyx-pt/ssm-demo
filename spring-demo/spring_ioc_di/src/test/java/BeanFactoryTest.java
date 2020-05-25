import com.zyx.factory.BeanFactory;
import com.zyx.service.AccountService;

/**
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
