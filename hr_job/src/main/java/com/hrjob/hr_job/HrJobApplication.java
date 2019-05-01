package com.hrjob.hr_job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
@MapperScan(basePackages = "com.hrjob.hr_job.dao")
public class HrJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrJobApplication.class, args);
    }

}
