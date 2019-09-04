package com.imooc.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 *@ClassName     ：UserControllerTest
 *@Description  : TODO
 *@author      : ljw
 *@date       : 2019/8/22 20:18
 *@version   : V1.0
 */
@RunWith(SpringRunner.class) //声明使用SpringRunner来启动这个测试类
@SpringBootTest //声明这是个测试类
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    //每个测试用例执行前会执行（创建MockMvc环境）
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("userName","xiaowei")
                .param("age","12")
                .param("ageTo","20")
                .param("xxx","yyy")
//                .param("size","2")
//                .param("page","5")
//                .param("sort","age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())//andExcept表明我希望这个返回的结果是什么
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))//表明我希望这个返回的结果集合且数量为3.注：(jsonPath表达式)
                .andReturn().getResponse().getContentAsString();  //andReturn().getResponse().getContentAsString() 返参以Json 的格式转成String
        System.out.println(result);
    }


    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk()) //isOk() 状态码为200
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("xiaowei"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenGetInfoField() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());//is4xxClientError() 返参状态码为400开头数字

    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        String context = "{\"userName\":\"xiaowei\",\"passWord\":null,\"sex\":null,\"birthday\":\""+date.getTime()+"\"}" ;
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenUpdateSuccess() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        String context = "{\"id\":\"1\",\"userName\":\"xiaowei\",\"passWord\":null,\"sex\":null,\"birthday\":\""+date.getTime()+"\"}" ;
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(context))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
