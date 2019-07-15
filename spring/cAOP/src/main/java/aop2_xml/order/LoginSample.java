package aop2_xml.order;

import org.aspectj.lang.JoinPoint;

public class LoginSample {

    public void before(JoinPoint p) {
        System.out.println( "---===--- before ---===---" + p );
    }

    public void afterReturn(JoinPoint p) {
        System.out.println( "---===--- afterReturn ---===---" + p );
    }
}
