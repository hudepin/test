package com.deep.test.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author hudepin
 * @Description
 * @ClassName FlatMapTest
 * @create_date 2020.09.14 16:29
 * @since 1.2.0
 */
public class FlatMapTest {
    public static void main(String[] args) {
        String[] words = new String[]{"Hello","World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        a.forEach(System.out::println);
    }
}
