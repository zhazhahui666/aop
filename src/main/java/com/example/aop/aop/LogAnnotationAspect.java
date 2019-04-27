package com.example.aop.aop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzh
 * @date 2019/4/21
 */
@Configuration
@Aspect
@Slf4j
public class LogAnnotationAspect {


    @Autowired(required=false)
    private HttpServletRequest request;

    /**
     * Controller层切点,注解方式
     */
    //@Pointcut("execution(* *..controller..*Controller*.*(..))")
    @Pointcut("@annotation(com.example.aop.annotation.WebControllerLog)")
    public void controllerAspect() {
        log.info("========controllerAspect===========");
    }

    /**
     * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException{
        System.out.println("前置通知--------");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        String target = targetClass.getName() + "#" + method.getName();

        //参数的value集合
        Object[] values = joinPoint.getArgs();

        //获取到方法的所有参数名称的字符串数组
        String[] parameterNames = signature.getParameterNames();

        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            params.put(parameterNames[i], values[i]);
        }
//        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info(" 开始调用--> {} 参数:{}", target, JSONObject.toJSONString(params, SerializerFeature.WriteMapNullValue));
    }

    /**
     * 后置通知(在方法执行之后返回) 用于拦截Controller层操作
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint){
        log.info("切面后置------------------");
    }

}
