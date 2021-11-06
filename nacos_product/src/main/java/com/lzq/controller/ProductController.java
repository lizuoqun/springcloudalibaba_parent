package com.lzq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizuoqun
 * @version 1.0
 * @date 2021-11-06 13:40
 */
@RestController
public class ProductController {

    @GetMapping("/initProduct")
    public String init(Integer id){
        return "product = >"+id;
    }
}
