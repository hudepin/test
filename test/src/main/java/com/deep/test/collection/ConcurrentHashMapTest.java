package com.deep.test.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName ConcurrentHashMapTest
 * @create_date 2021.03.31 10:11
 * @since
 */
public class ConcurrentHashMapTest {


    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("a","1");
        String key = "a1231231";
        System.out.println("a".hashCode());
        System.out.println(map.size());
        System.out.println(Integer.parseInt(String.valueOf(HASH_BITS),10));
        int h = key.hashCode();
        System.out.println(h);
        System.out.println(h>>>16);
        System.out.println(h^(h>>>16));
        System.out.println((h^(h>>>16) )& HASH_BITS);

        System.out.println(tableSizeFor(17));

    }
    static final int spread(int h) {

        return (h ^ (h >>> 16)) & HASH_BITS;
    }
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
