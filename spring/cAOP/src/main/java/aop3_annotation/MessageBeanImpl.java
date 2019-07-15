package aop3_annotation;

import org.springframework.stereotype.Component;

@Component("targetBean")
public class MessageBeanImpl implements MessageBean {

    public void sayHello() {
        System.out.println( "sayHello() 호출" );
    }

    public void enSayHello() {
        System.out.println( "engSayHello() 호출" );
    }

    public void test() {
        System.out.println( "test() 호출" );
    }


}
