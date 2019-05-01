package com.springbootmq.springbootmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopRabbitConfig {

    final static String message="topic.message";
    final static String messages = "topic.messages";


    @Bean
    public Queue queueMessage(){
        return new Queue(TopRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopRabbitConfig.messages);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");

    }//创建了一个绑定，他的主键是topic.message

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }//创建了一个绑定，他的主键是topic.#

}
