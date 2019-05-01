package com.springbootruleenginee.springbootruleenginee;

import org.kie.api.builder.KieFileSystem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsAutoConfiguration {

    /**
     * 特别要注意 rule 的存放位置
     */
    public static final String RULES_PATH = "rules/";

    @Bean
    @ConditionalOnMissingBean(KieFileSystem.class)
    public KieFileSystem kieFileSystem(){
//        KieFileSystem kieFileSystem=getKi
    }
}
