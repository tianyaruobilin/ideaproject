package com.springbootmq.springbootmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class BFanoutReciver {
    @RabbitHandler
    public void StringHandler(String a){
        System.out.println("fanout.B:"+a);
    }
}
