package com.nonglianwang.buchong.message;

import com.nonglianwang.buchong.BuchongApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

@SpringBootTest(classes = BuchongApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class LocalMessageTest {

    @Autowired
    private MessageSource messageSource;

    /**
     * code：信息的键，properties中的key
     * args：系统运行时参数，可为空
     * defaultMessage：默认信息，可为空
     * locale：区域信息，我们可以通过java.util.Locale类下面的静态常量找到对应的值。如：简体中文就是zh_CN；英文就是en_US，详见java.util.Locale中的常量值。
     */
    @Test
    public void test(){
        log.warn(messageSource.getMessage("mess.user.password",null,"用户密码", Locale.SIMPLIFIED_CHINESE));
    }
}
