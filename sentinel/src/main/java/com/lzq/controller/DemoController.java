package com.lzq.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizuoqun
 * @version 1.0
 * @date 2021-11-10 20:12
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    @SentinelResource(value = "sentinelDemo", blockHandler = "blockHandler" , fallback = "fall")
    public String demo(Integer id){
        if (id<0) throw new RuntimeException("id 无效");
        return "demo ok";
    }

    public String blockHandler(Integer id, BlockException e){
        if(e instanceof FlowException){
            return "已被流控";
        }
        if(e instanceof DegradeException){
            return "已被降级";
        }
        return "=====";
    }

    public String fall(){
        return "服务器异常";
    }
}
