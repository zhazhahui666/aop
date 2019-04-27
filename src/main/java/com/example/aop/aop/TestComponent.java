package com.example.aop.aop;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author zzh
 * @date 2019/4/21
 */
@Component
@ConditionalOnProperty(value = "globallog.enable")
public class TestComponent {

    public TestComponent() {
        System.out.println("testComponent创建了--------------");
    }
}
