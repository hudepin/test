package com.deep.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hudepin
 * @Description
 * @ClassName TestMatch
 * @create_date 2021.01.04 17:09
 * @since 1.2.0
 */
public class TestMatch {
    private static final Pattern DECRYPTED_PATTERN = Pattern.compile("ENC.(\\d+)\\((.*?)\\)", 32);
    public static void main(String[] args) {
        String templateTtext="13917287804";
        Matcher matcher = DECRYPTED_PATTERN.matcher(templateTtext);
        if(matcher.find()) {
            System.out.println(true);
        }
    }
}
