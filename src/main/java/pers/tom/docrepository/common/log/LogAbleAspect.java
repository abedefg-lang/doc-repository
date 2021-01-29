package pers.tom.docrepository.common.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author lijia
 * @description
 * @date 2021-01-25 10:51
 */
@Aspect
public class LogAbleAspect {


    /**
     * logAble注解切点
     * 所有放置了LogAble方法，类
     */
    @Pointcut("@annotation(pers.tom.docrepository.common.log.LogAble) || @within(pers.tom.docrepository.common.log.LogAble)")
    public void logAblePointCut(){

    }

    @Around("logAblePointCut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {

        //获取logger 打印日志
        Logger logger = LoggerFactory.getLogger(pjp.getSignature().getDeclaringTypeName());
        String methodName = pjp.toLongString();

        //打印接收参数
        logger.info("开始执行 : {} , 参数列表 : {}", methodName, Arrays.toString(pjp.getArgs()));

        //记录执行时间
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();

        //打印返回结果
        logger.info("执行结束 : {} , 返回结果 : {}, 耗时 : {}毫秒", methodName, result, endTime-startTime);

        return result;
    }






}
