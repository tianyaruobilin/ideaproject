package com.nonglianwang.buchong.event.awarestudy;

import com.nonglianwang.buchong.entity.User;
import org.springframework.context.ApplicationEvent;

public class UserRegisterEvent extends ApplicationEvent {

    private User user;

    /**
     * 谁发布这个事件，谁就是source
     * @param source
     * @param user
     */
    public UserRegisterEvent(Object source,User user) {
        super(source);
        this.user=user;
    }

    public User getUser() {
        return user;
    }
}
