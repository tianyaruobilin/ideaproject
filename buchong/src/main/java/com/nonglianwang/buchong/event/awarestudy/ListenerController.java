package com.nonglianwang.buchong.event.awarestudy;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 监听者控制器
 */
@Api(tags = "健康检查控制器,用于自我测试")
@RestController
public class ListenerController {


    /**
     * 当访问根目录时，如果无异常，返回 ok json字符串
     * @return
     */
    @GetMapping(value = "/")
    public String healthyCheck(){
        return "ok";
    }
}
