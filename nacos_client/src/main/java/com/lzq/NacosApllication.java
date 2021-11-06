package com.lzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lizuoqun
 * @version 1.0
 * @date 2021-09-25 21:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApllication {
    public static void main(String[] args) {
        SpringApplication.run(NacosApllication.class,args);
    }
}
