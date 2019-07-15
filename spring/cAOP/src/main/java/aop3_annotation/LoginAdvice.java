package aop3_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAdvice {

    @Around( "execution(public * aop3_annotation.*.*Hello(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        System.out.println( "[사전작업] : " + methodName );
        Object obj = point.proceed( );
        System.out.println( "<사후작업> : " + methodName );

        return obj;
    }

    public void before(JoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        System.out.println( "[***** 사전작업 *****] : " + methodName );
    }
}
