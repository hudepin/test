package com.deep.test.letcode.datastructure;

import java.util.Stack;

/**
 * @author hudepin
 * @Description
 * @ClassName StackSolution
 * @create_date 2020.09.17 09:19
 * @since 1.2.0
 */
public class StackSolution {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        if(s== null || s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char cha : s.toCharArray()){
            if('('==cha || '['==cha || '{' == cha){
                stack.push(cha);
            }
            if(')' == cha ){
                if( stack.isEmpty() || stack.pop() != '(' ){
                    return false;
                }
            }
            if(']' == cha ){
                if( stack.isEmpty() || stack.pop() != ']' ){
                    return false;
                }
            }
            if('}' == cha ){
                if( stack.isEmpty() || stack.pop() != '{' ){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
