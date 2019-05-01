package com.bootmq.bootmq;

import com.bootmq.bootmq.utils.Reciver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BootmqApplication {

    final static String queueName="spring-boot";//队列名字//也叫route-king

    @Bean//返回一个新的队列
    Queue queue(){
        return new Queue(queueName,false);
    }

    @Bean//主题交换//交换机名字
    TopicExchange exchange(){
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean//创建一个绑定
    /**
     * 需要参数：绑定一个（队列）到（交换机）用这个（队列名）
     */
    Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);
        container.setQueueNames(queueName);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Reciver reciver){
        return new MessageListenerAdapter(reciver, "reciverMessage");
    }

    public static void main(String[] args) {
        SpringApplication.run(BootmqApplication.class, args);
    }

}
