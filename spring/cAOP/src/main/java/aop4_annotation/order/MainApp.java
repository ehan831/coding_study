package aop4_annotation.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext( "aop4.xml" );
        MemberBean bean = cxt.getBean( "targetBean", MemberBean.class );
        bean.register();
        System.out.println( "-------------===-------------" );
        bean.update( "홍길동범" );
    }
}
