package com.springbootmq.springbootmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")//bang
public class HelloReciver {

    @RabbitHandler//专门处理字符串的接收处理器
    public void process1(String message){
        System.out.println("Reciver:"+message);
    }

}
