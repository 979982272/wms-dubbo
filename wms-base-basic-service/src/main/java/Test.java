import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
public class Test {
    private static final Log log = LogFactory.getLog(Test.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:Application-Spring.xml");
            context.start();
        } catch (Exception e) {
            log.error("== DubboProvider context start error:", e);
        }
        synchronized (Test.class) {
            while (true) {
                try {
                    Test.class.wait();
                } catch (InterruptedException e) {
                    log.error("== synchronized error:", e);
                }
            }
        }
    }
}
