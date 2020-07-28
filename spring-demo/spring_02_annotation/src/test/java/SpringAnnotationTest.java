import com.zyx.dao.AccountDao;
import com.zyx.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
public class SpringAnnotationTest {
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountService as  = (AccountService)ac.getBean("accountService");
        AccountService as2  = (AccountService)ac.getBean("accountService");
        System.out.println(as);
        AccountDao adao = ac.getBean("accountDao1", AccountDao.class);
        System.out.println(adao);
        System.out.println(as == as2);
        as.saveAccount();
        // 使用close方法，必须是ApplicationContext的子类，所以使用的是ClassPathXmlApplicationContext数据类型
        // 关闭容器测试singleton的销毁方法的执行
        ac.close();
    }
}
