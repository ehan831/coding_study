package aop1_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 스프링 파일 연동
        // targetBean 객체 얻어와서 함수 호출
        ApplicationContext cxt = new ClassPathXmlApplicationContext( "aop1.xml" );
        MessageBean bean = cxt.getBean("targetBean", MessageBean.class  );

        bean.sayHello();
        System.out.println( "-------------------------------" );
        bean.enSayHello();
        System.out.println( "===============================" );
        bean.test();
    }
}
