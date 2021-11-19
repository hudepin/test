package com.deep.test;

import com.deep.test.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        changeList(list);
        System.out.println(list.size());
    }
    public static void changeList(List<User> ss){
        ss.add(new User());
    }
}
