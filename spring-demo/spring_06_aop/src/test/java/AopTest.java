import com.zyx.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/22 15:25
 */
public class AopTest {
    public static void main(String[] args) {
        //1.获取容器
//        ApplicationContext ac = getAOPXmlApplicationContext();
        ApplicationContext ac = getAOPAnnoApplicationContext();
        //2.获取对象
        AccountService as = (AccountService)ac.getBean("accountServiceImpl");
        //3.执行方法
        as.saveAccount();
        System.out.println();
        as.updateAccount(1);
        System.out.println();
        as.deleteAccount();
    }

    public  static ApplicationContext getAOPXmlApplicationContext(){
        return new ClassPathXmlApplicationContext("bean_aop_xml.xml");
    }

    public  static ApplicationContext getAOPAnnoApplicationContext(){
        return new ClassPathXmlApplicationContext("bean_aop_annotation.xml");
    }

}
