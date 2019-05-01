package com.bootmq.bootmq;

import com.bootmq.bootmq.BootmqApplication;
import com.bootmq.bootmq.utils.Reciver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Reciver reciver;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, Reciver reciver, ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.reciver = reciver;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message……");
        rabbitTemplate.convertAndSend(BootmqApplication.queueName/*"spring-boot"*/, "Hello from RabbitMQ");
        reciver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }

}
