package com.nonglianwang.buchong.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware , MessageSourceAware, ApplicationEventPublisherAware {

    private String beanName;
    private ResourceLoader resourceLoader;
    private ApplicationEventPublisher applicationEventPublisher;
    private MessageSource messageSource;

    @Override
    public void setBeanName(String s) {
        this.beanName=s;

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }

    public void outPutResult() throws IOException {

        System.out.println("Bean的名称是"+beanName);
        Resource resource=resourceLoader.getResource("classpath:test.txt");
        String line=null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource=messageSource;
    }

    public void messageSource(){
        messageSource.getMessage(new DefaultMessageSourceResolvable("mess.user.name"), Locale.SIMPLIFIED_CHINESE);
    }
}
