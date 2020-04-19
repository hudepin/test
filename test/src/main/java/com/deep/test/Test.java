/**
 * 
 */
package com.deep.test;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HDP23
 *
 */
public class Test {
	public static final String s = "";
	static final String s1 = "";

	public static void main(String[] args) {
			System.out.println(Runtime.getRuntime().availableProcessors());
			System.out.println(Runtime.getRuntime().totalMemory()/1024);
			System.out.println(Runtime.getRuntime().maxMemory()/1024);
			int arg0=10;
			int arg1 = 4;
			int arg2 = arg1 + (arg1 >> 1);
			System.out.println(arg1 >> 1);
			if (arg2 - arg0 < 0) {
				arg2 = arg0;
			}
			List list = new ArrayList();
			list.add(1);
			System.out.println(1<<30);
			System.out.println(Integer.MAX_VALUE);
			int j =1<<30;
			int k =0;
			while(j!=0){
				j=j/2;
				System.out.println("J:"+j);
				k++;
				System.out.println("k:"+(k+1));
			}
			System.out.println("k:"+k);

			Object o = new Object();
			Integer i=2;
			//460141958
		System.out.println("hashCode:"+o.hashCode());
		for( i=0;i<200;i++){
			int h = i.hashCode();
			System.out.println(h^h>>>16);
		}


			

	}
}
