package ex3_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext( "ex3_autowired.xml" );

        MessageBean bean = cxt.getBean( "message", MessageBean.class );
        bean.sayHello();
    }
}
