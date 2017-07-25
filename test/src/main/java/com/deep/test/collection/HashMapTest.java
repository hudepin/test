/**
 * 
 */
package com.deep.test.collection;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author HDP23
 *
 */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Object,Object> hash = new HashMap();
		System.out.println(hash.isEmpty());
		System.out.println(hash.hashCode());
		hash.put("1", "1");
		hash.put("2", "3");
		hash.put("3", "4");
		System.out.println(hash.isEmpty());
		System.out.println(hash.hashCode());
		System.out.println(roundUpToPowerOf2(123456));
		HashMap map = new HashMap(23,0.81f);
		map.put("1", "2");
		System.out.println(map.size());
		System.out.println(tableSizeFor(34));
		System.out.println(hash(1123213131));
		System.out.println();
	}
	private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
		System.out.println((number - 1) << 1);
        return highestOneBit((number - 1) << 1) ;
    }
	/**
	 * 将数值转换为2的幂次方数
	 * @param arg
	 * @return
	 */
	public static int highestOneBit(int arg) {
		System.out.println("0:"+arg);
		arg |= arg >> 1;
        System.out.println("2进制高位有两个1:"+Integer.toBinaryString(arg));
		arg |= arg >> 2;
		System.out.println("2进制高位有4个1:"+Integer.toBinaryString(arg));
		arg |= arg >> 4;
		System.out.println("2进制高位有8个1:"+Integer.toBinaryString(arg));
		arg |= arg >> 8;
		System.out.println("2进制高位有16个1:"+Integer.toBinaryString(arg));
		arg |= arg >> 16;
		System.out.println("2进制高位有32个1:"+Integer.toBinaryString(arg));
		System.out.println("2进制右移一位:"+ Integer.toBinaryString(arg>>>1));
		return arg - (arg >>> 1);
	}
	
	static final int tableSizeFor(int arg) {
		  System.out.println("2进制高位有0个1:"+Integer.toBinaryString(arg));
		int arg0 = arg - 1;
		  System.out.println("2进制高位有1个1:"+Integer.toBinaryString(arg0));
		arg0 |= arg0 >>> 1;
		  System.out.println("2进制高位有2个1:"+Integer.toBinaryString(arg0));
		arg0 |= arg0 >>> 2;
		  System.out.println("2进制高位有4个1:"+Integer.toBinaryString(arg0));
		arg0 |= arg0 >>> 4;
		  System.out.println("2进制高位有8个1:"+Integer.toBinaryString(arg0));
		arg0 |= arg0 >>> 8;
		  System.out.println("2进制高位有16个1:"+Integer.toBinaryString(arg0));
		arg0 |= arg0 >>> 16;
		  System.out.println("2进制高位有32个1:"+Integer.toBinaryString(arg0));
		return arg0 < 0 ? 1 : (arg0 >= 1073741824 ? 1073741824 : arg0 + 1);
	}
	
	static int hash(Object k) {
		 	int h = 0;
	         h ^= k.hashCode();

	        // This function ensures that hashCodes that differ only by
	        // constant multiples at each bit position have a bounded
	        // number of collisions (approximately 8 at default load factor).
	        h ^= (h >>> 20) ^ (h >>> 12);
	        return h ^ (h >>> 7) ^ (h >>> 4);
	    }

}
