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
@ContextConfiguration(locations = "classpath:bean_xml.xml")
public class txXmlTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100f);
    }

    /**
     * @Description: 测试事务模板
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/28 16:29
     * @param
     * @return: void
     */
    @Test
    public void testTransfer2(){
        accountService.transfer2("aaa","bbb",100f);
    }
}
