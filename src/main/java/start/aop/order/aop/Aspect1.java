package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//스프링 AOP 구현
@Slf4j
@Aspect
public class Aspect1 {
    //포인트컷
    @Around("execution(* start.aop.order..*(..))") //start.aop.order 패키지와 하위패키지를 지정
    //logging은 어드바이스
    // OrderService와 OrderRepository의 모든 메서드는 AOP 적용 대산이 됨.
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
