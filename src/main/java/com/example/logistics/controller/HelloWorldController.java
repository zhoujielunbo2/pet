package com.example.logistics.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author: hexiaobo
 * @Date: 2018/12/13 14:51
 * @Description: hello
 */
@RestController
public class HelloWorldController {
    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }
}
