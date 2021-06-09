package com.example.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        log.info("services:{}", services);
        return services;
    }
}
