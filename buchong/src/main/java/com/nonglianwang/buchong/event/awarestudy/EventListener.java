package com.nonglianwang.buchong.event.awarestudy;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听：监听到事件发布后，自动执行onApplicationEvent方法，所以该类需要有IOC来管理，类上要加@Component注解
 */
@Component
public class EventListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        //发邮件
        System.out.println("正在发送邮件至： " + userRegisterEvent.getUser().getEMail());

        //发短信
        System.out.println("正在发短信到： " + userRegisterEvent.getUser().getActivationCode());

    }
}
