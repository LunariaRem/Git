package com.example.zuul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/set")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello world!";
    }
}

