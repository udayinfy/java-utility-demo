package demo.spring3.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

//@ContextConfiguration(locations={"classpath:demo/spring3/rmi/spring-rmi-server.xml",
//    "classpath:demo/spring3/rmi/spring-rmi-client.xml"})
public class TestUserRmiService {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context=
            new ClassPathXmlApplicationContext(new String[]{"classpath:demo/spring3/rmi/spring-rmi-server.xml",
                "classpath:demo/spring3/rmi/spring-rmi-client.xml"});
        Thread.sleep(3);
        RmiProxyFactoryBean RmiProxyFactoryBean=(RmiProxyFactoryBean)context.getBean("userRmiServiceClient");
    }

//    @Autowired
//    @Qualifier("userRmiServiceClient")
//    private RmiProxyFactoryBean RmiProxyFactoryBean;
//
//    @Test
//    public void testgetUserNameById() {
//        String uid="auid";
//        UserService userService=(UserService)rmiProxyFactoryBean.getObject();
//        userService.getUserNameById(uid);
//    }

}
