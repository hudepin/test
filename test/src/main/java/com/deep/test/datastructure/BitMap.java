package com.deep.test.datastructure;

/**
 * @author hudepin
 * @Description
 * @ClassName BitMap
 * @create_date 2020.11.06 10:59
 * @since 1.2.0
 */
public class BitMap {
    private byte[] bits;
    private int capacity;
    public BitMap(int capacity){
        this.capacity = capacity;
        //1byte能存储8个数据，那么capacity数据需要多少个bit呢，capacity/8+1,右移3位相当于除以8
        bits = new  byte[(capacity>>3)+1];
    }
    public void add(int num){
        // num/8得到byte[]的index
        int araayIndx = num>>3;
        // num%8得到在byte[index]的位置
        int position = num & 0x07;
        bits[araayIndx] |= 1<<position;
    }
    public boolean contain(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bits[arrayIndex] & (1 << position)) !=0;
    }

    public void clear(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        bits[arrayIndex] &= ~(1 << position);

    }
    public static void main(String[] args) {
        BitMap bitmap = new BitMap(100);
        bitmap.add(7);
        System.out.println("插入7成功");

        boolean isexsit = bitmap.contain(7);
        System.out.println("7是否存在:"+isexsit);
        bitmap.add(7);
        bitmap.clear(7);
        isexsit = bitmap.contain(7);
        System.out.println("7是否存在:"+isexsit);
    }
}
