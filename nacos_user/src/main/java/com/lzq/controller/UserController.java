package com.lzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lizuoqun
 * @version 1.0
 * @date 2021-11-06 13:42
 */
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/initUser")
    public String init(Integer id){

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("NACOSPRODUCT");
        serviceInstances.forEach(serviceInstance -> {
            System.out.println("host = "+ serviceInstance.getHost() +", port ="+ serviceInstance.getPort() +", url ="+ serviceInstance.getUri());
        });

        ServiceInstance serviceInstances1 = loadBalancerClient.choose("NACOSPRODUCT");
        System.out.println("url = " + serviceInstances1.getUri()+", port = "+serviceInstances1.getPort() + " ,host = "+serviceInstances1.getHost());

        return "user = > "+id;
    }
}
