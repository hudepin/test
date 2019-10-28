package com.deep.test;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-22 17:00
 */
public class Test1022 {
    public static void main(String[] args) {
        String flieName="1322.13321.xls";
        System.out.println(flieName.substring(flieName.lastIndexOf(".")+1));
        String regEx = "^0?$|^([1-9][0-9]*)?$";
        System.out.println(matchRegEx(regEx, "123132130"));
        Long ss =null;
        System.out.println(Optional.ofNullable(ss).isPresent());

    }
    public static boolean matchRegEx(String regEx, String str) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
