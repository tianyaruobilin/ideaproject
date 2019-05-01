package com.nonglianwang.buchong.controller;

import com.nonglianwang.buchong.BuchongApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BuchongApplication.class)
@RunWith(SpringRunner.class)
public class UserManagementControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  //初始化MockMvc对象
    }

    @Test
    public void delete() throws Exception {

        String retunString=mockMvc.perform(
                get("/user/delete")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .param("toDeleteUno","")
        ).andExpect(status().isOk())  //返回状态是200
                .andDo(print())       //打印请求和相应内容
                .andReturn().getResponse().getContentAsString();    //将数据转化为字符串
        System.out.println("----------------返回的数据为"+retunString+"---------------------");
    }
}