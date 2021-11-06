package com.lzq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizuoqun
 * @version 1.0
 * @date 2021-11-06 14:09
 */
@RestController
@RefreshScope
public class DemoController {

    @Value("${username}")
    private String username;

    @GetMapping("/demo")
    public String demo(){
        return "demo - >" + username;
    }
}
