package mspring4.S_4_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
public class Audience {

    @Pointcut("execution(* Performance.perform(int)) && args(count))")
    public void perfomance(int count){

    }

    @Before("perfomance(count)")
    public void silenceCellPhones(int count){
        count=count+5;
    System.out.println("1--silencing cell phones!---"+count);

    }

//    @Before("execution(* Performance.perform(..))")
////    @Before("perfomance()")定义@Pointcut后,该注解同上面的注解等效
//    public void silenceCellPhones(){
//    System.out.println("1--silencing cell phones!");
//
//    }
//
//    @Before("execution(* Performance.perform(..))")
//    public void takeSeats(){
//        System.out.println("2--taking seats!");
//
//    }
//
//    @AfterReturning("execution(* Performance.perform(..))")
//    public void applause(){
//        System.out.println("3--CLAP CLAP CLAP! ");
//
//    }
//
//    @AfterThrowing("execution(* Performance.perform(..))")
//    public void demandRefund(){
//        System.out.println("4--demanding a refund!");
//
//    }

//    /**添加环绕通知*/
//    @Around("perfomance()")
//    public void watchPerformancr(ProceedingJoinPoint pj){
//        try {
//            System.out.println("1--silencing cell phones!");
//            System.out.println("2--taking seats!");
//            pj.proceed();
//            System.out.println("3--CLAP CLAP CLAP! ");
//
//        }catch (Throwable throwable) {
//            throwable.printStackTrace();
//            System.out.println("4--demanding a refund!");
//        }
//    }
}
