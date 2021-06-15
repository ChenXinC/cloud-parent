package com.example.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/demo")
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

    @GetMapping("/fallback")
    public String fallback() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
