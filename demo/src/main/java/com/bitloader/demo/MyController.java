package com.bitloader.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("m")
    public static String myMethod(){
        return "<b>Hello world</b>";
    }

    @RequestMapping("process-form")
    public static String getData(){


        return "<b>Hello world</b>";
    }
}
