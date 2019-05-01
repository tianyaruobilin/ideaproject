package com.springbootruleenginee.springbootruleenginee.controller;
import com.springbootruleenginee.springbootruleenginee.entity.Adress;
import com.springbootruleenginee.springbootruleenginee.entity.AdressCheckResult;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private KieSession kieSession;

    @ResponseBody
    @RequestMapping("/adress")
    public void test(){
        Adress adress=new Adress();
        adress.setPostCode("99425");

        AdressCheckResult result=new AdressCheckResult();
        kieSession.insert(adress);
        kieSession.insert(result);
        int ruleFiredCount=kieSession.fireAllRules();
        System.out.println("触发了"+ruleFiredCount+"条规则");

        if (result.isPostCodeResult()) {
            System.out.println("规则校验通过");
        }
    }
}
