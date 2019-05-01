package com.study.rwseparation.rwseparation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.study.rwseparation.rwseparation.mapper")
public class RwseparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RwseparationApplication.class, args);
    }

}
