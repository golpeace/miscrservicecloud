import com.miscloud.DeptConsumerApplication;
import com.ribbonrule.MyRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DeptConsumerApplication.class)
@RunWith(SpringRunner.class)
public class ConSumerTest {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
    public void test(){

    }

}
