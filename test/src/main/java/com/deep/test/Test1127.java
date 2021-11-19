package com.deep.test;

import com.deep.test.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hudepin
 * @Description
 * @ClassName Test1127
 * @create_date 2020.11.27 17:00
 * @since 1.2.0
 */
public class Test1127 {
    public static void main(String[] args) {
        int i=3;
        int j=4;
        System.out.println(i^j);
        List<User> list = new ArrayList<>();
        User[] ss = new User[10];
       ss = list.toArray(new User[list.size()]);
    }
}
