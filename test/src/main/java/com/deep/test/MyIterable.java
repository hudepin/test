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


	@Override
	public Iterator<Character> iterator() {
		return null;
	}
}
