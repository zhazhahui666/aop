package com.example.aop.controller;

import com.example.aop.annotation.WebControllerLog;
import com.example.aop.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzh
 * @date 2019/4/21
 */
@RestController
public class AopController {


    @GetMapping("msg")
    @WebControllerLog
    public String msg(Student student){
        return "aaaa";
    }
}
