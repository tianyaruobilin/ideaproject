package com.springcloudoauth2.itokenservicesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ItokenServiceSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServiceSsoApplication.class, args);
    }

}

