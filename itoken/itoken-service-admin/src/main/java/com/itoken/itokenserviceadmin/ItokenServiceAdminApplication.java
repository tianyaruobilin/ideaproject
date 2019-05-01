package com.itoken.itokenserviceadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.itoken.itokenserviceadmin.mapper")
public class ItokenServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServiceAdminApplication.class, args);
    }

}

