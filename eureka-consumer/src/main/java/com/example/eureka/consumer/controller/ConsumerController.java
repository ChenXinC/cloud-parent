package com.example.eureka.consumer.controller;

import com.example.eureka.consumer.feign.DemoFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DemoFeignClient demoFeignClient;

    @GetMapping("/client")
    public String getClient() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/demo/service";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/feign")
    public String getClientWithFeign() {
        return demoFeignClient.consumer();
    }

    @GetMapping("/fallback")
    public String fallback() {
        return demoFeignClient.fallback();
    }
}
