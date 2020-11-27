package com.deep.test.collection.list;

import com.deep.test.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hudepin
 * @Description
 * @ClassName StreamTest
 * @create_date 2020.09.14 16:09
 * @since 1.2.0
 */
public class StreamTest {
    public static void main(String[] args) {
        List<User> list = genUsers();
        List<User> filterUsers = list.
                                    stream().
                                    filter(e->e.getUserName().equals("1")).
                                            collect(Collectors.toList());
        list.parallelStream();
    }

    private static List<User> genUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("1","1345621345","21"));
        list.add(new User("2","1345621345","22"));
        list.add(new User("3","1345621346","23"));
        list.add(new User("4","1345621347","24"));
        return list;
    }
}
