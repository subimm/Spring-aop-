package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//포인트컷 분리하여 AOP 구현
@Slf4j
@Aspect
public class Aspect2 {

    @Pointcut("execution(* start.aop.order..*(..))")//메서드 이름과 파라티머틑 합쳐서 포인트 시그니쳐
    //메서드 반환 타입은 void
    //내부에서 사용하면 private 다른 애스첵트에서 참고하면 public으로 사용
    private void allOrder(){}

    @Around("allOrder()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
                log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
