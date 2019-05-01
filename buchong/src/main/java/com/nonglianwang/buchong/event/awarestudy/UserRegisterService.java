package com.nonglianwang.buchong.event.awarestudy;

import com.nonglianwang.buchong.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 执行用户注册，并发布事件
 */
@Service
@Slf4j
public class UserRegisterService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

    public Boolean register(User user){
        // 1、注册用户
        // 2、发布事件

        System.out.println("user = [" + user.getUsername() + "] 注册成功");

        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, user));

        return true;
    }

}
