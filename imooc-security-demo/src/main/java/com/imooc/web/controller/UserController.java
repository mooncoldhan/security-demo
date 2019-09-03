package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@ClassName     ：UserController
 *@Description  : TODO
 *@author      : ljw
 *@date       : 2019/8/22 20:34
 *@version   : V1.0
 */
@RestController
@RequestMapping("/user") //父路径，此类下所有路径前缀
public class UserController {

    //@RequestParam() 修饰该值必须传递, name 修饰传参名称, required 为false 可以不传参数 ，defaultValue 传参为空使用默认值
    //public List<User> query(@RequestParam(name = "userName",required = false,defaultValue = "weiwei") String userName){

    //@PageableDefault 设置默认分页 size 每页显示数 ； page 当前页数 ；sort 排序


    @PostMapping
    //@RequestBody 映射请求体到java方法的参数 , BindingResult 与 @Validated 配合使用，用于收集校验参数用户传入参数是不符合参数规则的错误信息
    public User create(@Validated @RequestBody User user, BindingResult error){

        //判断error是否有值，有返回 ture
        if(error.hasErrors()){
            error.getAllErrors().stream().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }

        System.out.println(user.getUserName());
        System.out.println(user.getPassWord());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;

    }



    @GetMapping // 等同于@RequestMapping(method = RequestMethod.GET)
    @JsonView(User.UserSimpleView.class) //此注解与返参对象字段上相同注解配合使用
    public List<User> query(UserQuery userQuery,@PageableDefault(size = 2,page = 1,sort = "age,desc") Pageable pageable){
        List<User> list= new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }


    @GetMapping("/{id:\\d+}") // :后跟正则表达式，表示传参必须符合正则表达式格式
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){ //@PathVariable 表示我要从 url 中提取某个值作为参数
        User user = new User();
        user.setUserName("xiaowei");
        return user;
    }
}
