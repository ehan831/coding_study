package aop2_xml.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        System.out.println( "[사전작업] : " + methodName );
        Object obj = point.proceed( );
        System.out.println( "<사후작업> : " + methodName );

        return obj;
    }
}
