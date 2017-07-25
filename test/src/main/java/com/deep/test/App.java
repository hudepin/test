package com.deep.test;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MyIterable test = new MyIterable();
        test.setStr("abc");
        Iterator<Character> ii =  test.iterator();
        while(ii.hasNext()){
        	System.out.println(ii.next());
        }
        for(char item:test){
        	System.out.println(item);
        }
    }
}
