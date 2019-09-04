package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 *
 *@ClassName     ：HelloServiceImpl
 *@Description  : TODO
 *@author      : ljw
 *@date       : 2019/9/4 14:32
 *@version   : V1.0
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println(name);
        return "hello" + name;
    }
}
