package com.nonglianwang.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("zhuc");
        registry.addViewController("/login").setViewName("dengl");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/ruzhu").setViewName("shenq_ruz");
        registry.addViewController("/cart").setViewName("gouw_che");
    }
}
