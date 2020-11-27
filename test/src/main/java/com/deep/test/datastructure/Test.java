package com.deep.test.datastructure;

import com.deep.test.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-25 17:17
 */
public class Test {
    public static void main(String[] args) {
        String ss ="123";
        char[] chars = ss.toCharArray();
       combine(chars,0,chars.length);
        User u = new User("1");
        User u1 = u;
        u = new User("2");
        System.out.println(u1);
        Object o = new Object();

    }
    public static void combine(char[] chars,int start,int end){
        if(start==end){
            System.out.println(chars);
        }else{
            for(int j=start;j<end;j++){
                if(chars[start]==chars[j] && start !=j)continue;
                swap(chars,start,j);
                combine(chars,start+1,end);//递归
                swap(chars,start,j);  //还原字符串，为下一for循环准备

            }

        }



    }
    public static void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
