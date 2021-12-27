package com.cr.helloworld.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//在类上直接使用 @RestController ，这样子，里面所有的方法都只会返回 json 字符串了，
// 不用再每一个都添加@ResponseBody ！我们在前后端分离开发中，一般都使用 @RestController ，十分便捷！
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello,World!--rafa拉法!";
    }
}
