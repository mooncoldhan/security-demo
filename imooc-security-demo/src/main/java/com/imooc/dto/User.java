package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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


    private String id;

    @JsonView(UserSimpleView.class) //声明当前视图展示该字段
    private String userName;

    @JsonView(UserDetailView.class)
    @NotNull //此注解表示该参数不可为空或空字符串，配合@Validated 使用开启
    private String passWord;

    @JsonView({UserSimpleView.class,UserDetailView.class})
    private String sex;

    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
