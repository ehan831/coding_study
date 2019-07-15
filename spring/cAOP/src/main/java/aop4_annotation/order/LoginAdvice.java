package aop4_annotation.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoginAdvice {

    @Around( "execution(public * *(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        System.out.println( "[사전작업] : " + methodName );
        Object obj = point.proceed( );
        System.out.println( "<사후작업> : " + methodName );

        return obj;
    }
}
