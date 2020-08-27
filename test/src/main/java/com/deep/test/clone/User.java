package com.deep.test.clone;

import java.io.Serializable;

public class User implements Cloneable,Serializable{
    private static final long serialVersionUID = -1446637692276183950L;
    private String name;
    transient String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setName("hudepin");
        System.out.println(user);
        User user1 = (User)user.clone();
        System.out.println(user1);

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
