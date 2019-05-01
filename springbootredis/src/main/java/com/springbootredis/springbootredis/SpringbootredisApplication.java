package com.springbootredis.springbootredis;

import com.springbootredis.springbootredis.utils.Reciver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringbootredisApplication {

    private static final Logger LOGGER= LoggerFactory.getLogger(SpringbootredisApplication.class);


    //返回一个新的发送者
    @Bean
    Reciver reciver(CountDownLatch latch){
        return new Reciver(latch);
    }
    //返回一个倒数锁
    @Bean
    CountDownLatch latch(){
        return new CountDownLatch(1);
    }
    //返回一个字符串缓存模板
    @Bean
    StringRedisTemplate template(RedisConnectionFactory rcf){
        return new StringRedisTemplate(rcf);
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        container.addMessageListener(listenerAdapter,new PatternTopic("chat"));
        container.setConnectionFactory(connectionFactory);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Reciver reciver){
        return new MessageListenerAdapter(reciver,"reciverMessage");

    }
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx=SpringApplication.run(SpringbootredisApplication.class, args);

        StringRedisTemplate template=ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch=ctx.getBean(CountDownLatch.class);

        LOGGER.info("Sending message……");
        template.convertAndSend("chat", "hello from redis!");

        latch.await();

        System.exit(0);

    }
}
