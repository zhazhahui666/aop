//package com.example.aop.aop;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.CollectionUtils;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zzh
// * @date 2019/4/21
// */
//@Aspect
//@Configuration
//@Slf4j
//public class WebLogAspect {
//
//    /**
//     * 定义切点
//     * 匹配com.example.aop包及其子包中所有类中的所有方法，返回类型任意，方法参数任意
//     */
//    @Pointcut("execution(public * com.example.aop.controller..*.*(..))")
//    public void controllerAspect() {
//        System.out.println("进入了切点");
//    }
//
//
//    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
//
//    /**
//     * 前置通知
//     */
//    @Around("controllerAspect()")
//    public void controllerAspectBefore(JoinPoint joinPoint) {
//        System.out.println("前置通知--------");
//
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        Class<?> targetClass = method.getDeclaringClass();
//        String target = targetClass.getName() + "#" + method.getName();
//
//        //参数的value集合
//        Object[] values = joinPoint.getArgs();
//
//        //获取到方法的所有参数名称的字符串数组
//        String[] parameterNames = signature.getParameterNames();
//
//        Map<String, Object> params = new HashMap<>();
//        for (int i = 0; i < parameterNames.length; i++) {
//            params.put(parameterNames[i], values[i]);
//        }
//        log.info(" 开始调用--> {} 参数:{}", target, JSONObject.toJSONString(params, SerializerFeature.WriteMapNullValue));
//    }
//
//    @After("controllerAspect()")
//    public void controllerAspectAfter(JoinPoint joinPoint) {
//        System.out.println("后置通知--------");
//        System.out.println(joinPoint);
//    }
//
//
//}
