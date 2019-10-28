package com.deep.test.collection;

import com.deep.test.entity.Shop;
import com.deep.test.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-25 16:59
 */
public class ListTest {
    List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
       List<User> list = new ArrayList<User>();
       for(int i=0;i<10;i++){
           User user = new User("userName"+i,"phone"+i,"age"+i);
           list.add(user);
       }
        ConcurrentLinkedQueue<User> queue = new ConcurrentLinkedQueue<>();
        queue.addAll(list);

        int count =10;
        for(int i=0;i<count;i++){
            new Thread(()->{

            });
        }
    }
}
