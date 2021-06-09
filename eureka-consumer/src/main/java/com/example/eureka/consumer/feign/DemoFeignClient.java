package com.example.eureka.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client", path = "/demo")
public interface DemoFeignClient {

    @GetMapping("/service")
    String consumer();
}
