package com.imooc.dto;
/**
 *
 *@ClassName     ：UserQuery
 *@Description  : TODO
 *@author      : ljw
 *@date       : 2019/8/22 20:55
 *@version   : V1.0
 */
public class UserQuery {

    private String userName;

    private int age;

    private int ageTo;

    private String xxx;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}
