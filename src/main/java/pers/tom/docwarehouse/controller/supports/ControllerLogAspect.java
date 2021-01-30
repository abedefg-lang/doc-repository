package pers.tom.docwarehouse.controller.supports;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author tom
 * @description controller 日志切面对象
 * @date 2021/1/29 23:05
 */
@Aspect
@Slf4j
@Component
public class ControllerLogAspect {

    /**
     * 日志记录切点
     */
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    public void logPointCut(){

    }


    @Around("logPointCut())")
    public Object printLog(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();

        // 获取当前request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(requestAttributes).getRequest();

        //打印日志
        printRequestLog(request, args);
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        printResponseLog(request, result, endTime-startTime);

        return result;
    }

    /**
     * 打印请求信息 可以过滤某些参数
     * @param request request
     * @param args 执行参数
     */
    private void printRequestLog(HttpServletRequest request, Object[] args){
        String path = request.getServletPath();
        log.info("执行请求 path: [{}], parameters: [{}]", path, args);
    }

    /**
     * 打印响应信息  可以过滤某些返回信息
     * @param request 对应的请求
     * @param result 返回结果
     * @param executionTime 执行时长
     */
    private void printResponseLog(HttpServletRequest request, Object result, long executionTime){
        String path = request.getServletPath();
        log.info("执行结束 path: [{}], result: [{}], executionTime: [{}ms]", path, result, executionTime);
    }
}
