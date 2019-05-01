package com.nonglianwang.buchong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.nonglianwang.buchong.dao")
@SpringBootApplication
@EnableTransactionManagement
public class BuchongApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuchongApplication.class, args);
    }

}
