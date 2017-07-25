/**
 * 
 */
package com.deep.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * 
 * JDK中推荐的是对List集合尽量要实现RandomAccess接口
 * 如果集合类是RandomAccess的实现，则尽量用for(int i = 0; i < size; i++) 来遍历而不要用Iterator迭代器来遍历，
 * 在效率上要差一些。反过来，如果List是Sequence List，则最好用迭代器来进行迭代。
 * 
 * JDK中说的很清楚，在对List特别是Huge size的List的遍历算法中，要尽量来判断是属于RandomAccess(如ArrayList)还是Sequence List (如LinkedList），
 * 因为适合RandomAccess List的遍历算法，用在Sequence List上就差别很大，常用的作法就是：
 *要作一个判断：
 * if (list instance of RandomAccess) {
 *      for(int m = 0; m < list.size(); m++){}
 *  }else{
 *       Iterator iter = list.iterator();
 *      while(iter.hasNext()){}
 *   }
 * @author deephex
 *
 */
public class TestRandomAccess {
	public static void initList(List list,int n){
		for(int i=0;i < n;i++){
			list.add(i);
		}
	}
	//使用循环队列表迭代
	public static void traverseWithLoop(List list){
		long startTime,endTime;
		startTime = System.currentTimeMillis();
		for(int count=0;count<1000;count++){
			for(int i=0;i<list.size();i++){
				list.get(i);
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("traverseWithLoop taste time:"+(endTime-startTime)+ "ms");
	}
	  public static void traverseWithIterator(List list) {  
	        long starttime = 0;  
	        long endtime = 0;  
	        starttime = System.currentTimeMillis();  
	        for (int count = 0; count <= 1000; count++) {  
	            for (Iterator itr = list.iterator(); itr.hasNext();) {  
	                itr.next();  
	            }  
	        }  
	        endtime = System.currentTimeMillis();  
	        System.out.println("traverseWithIterator taste time:" + (endtime - starttime) + "ms");  
	    }  
	  public static void traverse(List list) {  
		  
	        long starttime = 0;  
	        long endtime = 0;  
	        if (list instanceof RandomAccess) {  
	            System.out.println("该list实现了RandomAccess接口");  
	            starttime = System.currentTimeMillis();  
	            for (int count = 0; count <= 1000; count++) {  
	                for (int i = 0; i < list.size(); i++) {  
	                    list.get(i);  
	                }  
	            }  
	            endtime = System.currentTimeMillis();  
	            System.out.println("迭代一共花了" + (endtime - starttime) + "ms时间");  
	        } else {  
	            System.out.println("该list未实现RandomAccess接口");  
	            starttime = System.currentTimeMillis();  
	            for (int count = 0; count <= 1000; count++) {  
	                for (Iterator itr = list.iterator(); itr.hasNext();) {  
	                    itr.next();  
	                }  
	            }  
	            endtime = System.currentTimeMillis();  
	            System.out.println("迭代一共花了" + (endtime - starttime) + "ms时间");  
	        }  
	    }  
	  public static void main(String[] args) {
		  	ArrayList arraylist = new ArrayList();  
	        LinkedList linkedlist = new LinkedList();  
	        initList(arraylist, 1000);  
	        initList(linkedlist, 1000);  
	        traverse(arraylist);  
	        traverse(linkedlist);  
	        traverseWithIterator(arraylist);  
	        traverseWithLoop(arraylist);  
	        traverseWithIterator(linkedlist);  
	        traverseWithLoop(linkedlist);  
	}
}
