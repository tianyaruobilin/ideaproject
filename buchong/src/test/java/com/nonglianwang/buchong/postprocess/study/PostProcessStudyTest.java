package com.nonglianwang.buchong.postprocess.study;

import com.nonglianwang.buchong.BuchongApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = BuchongApplication.class)
@RunWith(SpringRunner.class)
public class PostProcessStudyTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Test
    public void test(){

    }

}