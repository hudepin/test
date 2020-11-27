package com.deep.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hudepin
 * @Description
 * @ClassName TestString
 * @create_date 2020.11.16 14:02
 * @since 1.2.0
 */
public class TestString{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.stream().forEach(s->{

        });
        System.out.println(System.currentTimeMillis());
    }
}
