package com.deep.test.entity;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-25 17:00
 */
public class User {
    private String userName;
    private String phone;
    private String age;
    public User(){
        
    }

    public User(String userName, String phone, String age) {
        this.userName = userName;
        this.phone = phone;
        this.age = age;
    }

    public User(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
