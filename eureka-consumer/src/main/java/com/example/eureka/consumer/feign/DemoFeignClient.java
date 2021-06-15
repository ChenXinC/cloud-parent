package com.example.eureka.consumer.feign;

import com.example.eureka.consumer.feign.fallback.DemoFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign 客户端
 */
@FeignClient(value = "eureka-client", fallback = DemoFeignFallback.class, path = "/demo")
public interface DemoFeignClient {

    @GetMapping("/service")
    String consumer();

    @GetMapping("/fallback")
    String fallback();
}
