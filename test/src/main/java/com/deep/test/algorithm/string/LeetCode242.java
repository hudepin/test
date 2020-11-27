package com.deep.test.algorithm.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author hudepin
 * @Description
 * LeetCode第242题：给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。说明：你可以假设字符串只包含小写字母。
 *
 * @ClassName LeetCode242
 * @create_date 2020.04.11 22:39
 * @since 1.2.0
 */
public class LeetCode242 {
    private volatile  static int[] letters =new int[26];
    static {
        for(int i=0;i<26;i++){
            letters[i]=0;
        }

    }
    public static void main(String[] args) {
        System.out.println(isHavaSameWord("lettre","leettr"));
    }

    /**
     * 是否是字母异为词 忽略大小写,相同字符的数量也要相等
     * 解题思路：利用一个int s1中字符出现的次数记录到26个长度的数组中，s2中出现字符次数对数组中的元素减1
     * @param s1 abciq
     * @param s2 bcaqi
     * @return
     */
    public static boolean isHavaSameWord(String s1,String s2){
        if(StringUtils.isBlank(s1)||StringUtils.isBlank(s2)){
            return false;
        }
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();


        char[] char1 = s1.toCharArray();
        for(char c:char1){
            int index = (int)c -(int)'a';
            letters[index]=letters[index]+1;
        }

        char[] char2 = s2.toCharArray();
        for(char c:char2){
            int index = (int)c -(int)'a';
            letters[index]=letters[index]-1;
        }
        for(int c:letters){
            if(c != 0){
                return false;
            }
        }
        return true;

    }
}
