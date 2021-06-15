package com.example.eureka.consumer.feign.fallback;

import com.example.eureka.consumer.feign.DemoFeignClient;
import org.springframework.stereotype.Component;

/**
 * feign 客户端降级
 */
@Component
public class DemoFeignFallback implements DemoFeignClient {

    @Override
    public String consumer() {
        return "";
    }

    @Override
    public String fallback() {
        return "fallback";
    }
}
