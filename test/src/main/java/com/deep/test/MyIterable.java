/**
 * 
 */
package com.deep.test;

import java.util.Iterator;

/**
 * @author HDP23
 *
 */
public class MyIterable implements Iterable<Character> {
	private String str="";
	

	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}


	public Iterator<Character> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Character>() {
			private int index=0;
			public Character next() {
				// TODO Auto-generated method stub
				return str.toCharArray()[index++];
			}
			
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < str.length();
			}

			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
