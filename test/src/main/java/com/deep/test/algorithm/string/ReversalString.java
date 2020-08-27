package com.deep.test.algorithm.string;

/**
 * 字符传反转
 */
public class ReversalString {
    public static void main(String[] args) {
        System.out.println(reversal("hudepinij"));
    }

    public static String reversal(String str){

        char[] chars = str.toCharArray();
        char start ,end;
        int length=chars.length;
        int i=0;
        while(i<(length-i-1)){
            start = chars[i];
            end=chars[length-i-1];
            chars[i]=end;
            chars[length-i-1]=start;
            i++;
        }
        return String.valueOf(chars);


    }
}
