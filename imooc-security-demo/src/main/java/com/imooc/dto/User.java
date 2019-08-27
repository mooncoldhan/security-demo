package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 *
 *@ClassName     ：User
 *@Description  : TODO
 *@author      : ljw
 *@date       : 2019/8/22 20:38
 *@version   : V1.0
 */

public class User implements Serializable {

    //创建视图
    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    @JsonView(UserSimpleView.class) //声明当前视图展示该字段
    private String userName;

    @JsonView(UserDetailView.class)
    private String passWord;

    @JsonView({UserSimpleView.class,UserDetailView.class})
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
