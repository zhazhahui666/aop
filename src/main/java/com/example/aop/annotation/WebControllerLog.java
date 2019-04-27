package com.example.aop.annotation;

import java.lang.annotation.*;

/**
 * @author zzh
 * @date 2019/4/21
 */
//作用于参数或方法上
@Target({ElementType.PARAMETER, ElementType.METHOD})
// 1.SOURCE:在源文件中有效（即源文件保留）
// 2.CLASS:在class文件中有效（即class保留）
// 3.RUNTIME:在运行时有效（即运行时保留）
@Retention(RetentionPolicy.RUNTIME)
//@Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。
@Documented
public @interface WebControllerLog {
}
