package com.springbatch.springbatch.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyConfig {

    @Bean(name = "contactBean")
    @StepScope
    public ItemReader getMyBatisCursorItemReader(@Value("#{jobParamters[param1]}") String param1){
        //开始读取数据的demo1
        log.info("开始读取数据的demo01......");
        //如果需要查询需要条件，可以从这里设置查询条件
        MyBatisCursorItemReader myBatisCursorItemReader=new MyBatisCursorItemReader();
        myBatisCursorItemReader.setQueryId("selectAllUsers");
        return myBatisCursorItemReader;
    }
}
