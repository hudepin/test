/**
 * 
 */
package com.deep.test;

import org.springframework.beans.factory.InitializingBean;

import javax.print.attribute.IntegerSyntax;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author HDP23
 *
 */
public class Test {
	public static final String s = "";
	static final String s1 = "";
	List<Boolean> bList;

	public static void main(String[] args) {
		int[] res = {-1,-1};
		Arrays.sort(res);
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
			String s="JACKY CELINE ŮʿţƤ��� ˮ��ɫ  39*10*30cm .";
		System.out.println(s.length());
		System.out.println(System.currentTimeMillis());

		Double temp = 222.1234;
		System.out.println(Double.valueOf(new DecimalFormat("0.00").format(temp)));
		System.out.println(Double.valueOf(new DecimalFormat("##0.00").format(temp)));
		System.out.println(new DecimalFormat("0.00").format(temp));
		System.out.println(new DecimalFormat("#00.00").format(temp));
		System.out.println(new DecimalFormat("0.00%").format(temp));
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
			@Override
			public int compare(Integer i1,Integer i2){
				return i2-i1;
			}
		});
		maxHeap.add(2);
		maxHeap.add(3);
		maxHeap.add(4);
		maxHeap.add(1);

		System.out.println(maxHeap.size());
		System.out.println(maxHeap.peek());
		reverse(1534236469);
		char c ='x';
		int[] aa = {1,2,3};


	}

	public static int reverse(int x) {
		System.out.println(x);
		if(x==0||x>Integer.MAX_VALUE||x<Integer.MIN_VALUE){
			return 0;
		}
		int revertNumber = 0;
		while(x!=0){
			int pop =x%10;
			if(revertNumber> Integer.MAX_VALUE/10 || revertNumber<Integer.MIN_VALUE/10){
				return 0;
			}
			revertNumber = revertNumber*10+pop;
			x=x/10;
		}
		System.out.println(revertNumber);
		return revertNumber;

	}

	/**
	 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

	 字符          数值
	 I             1
	 V             5
	 X             10
	 L             50
	 C             100
	 D             500
	 M             1000
	 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

	 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

	 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
	 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
	 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

	 来源：力扣（LeetCode）
	 链接：https://leetcode-cn.com/problems/roman-to-integer
	 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		char[] chars = s.toCharArray();
		int res = get(chars[0],'n');
		for(int i=1;i<s.length();i++){
			if('I' == chars[i]){
				res = res + 1;
			}else if('X'==chars[i] || 'V'==chars[i]){
				if('I' == chars[i-1]){
					res = res + get(chars[i-1],chars[i]) - get(chars[i-1],'n');
				}else{
					res = res + get(chars[i],'n');
				}

			}else if('C'==chars[i] || 'L' == chars[i]){
				if('X'== chars[i-1]){
					res = res + get(chars[i-1],chars[i]) - get(chars[i-1],'n');
				}else{
					res = res + get(chars[i],'n');
				}
			}else if('D' == chars[i] || 'M' == chars[i]){
				if('C'== chars[i-1]){
					res = res + get(chars[i-1],chars[i]) - get(chars[i-1],'n');
				}else{
					res = res + get(chars[i],'n');
				}
			}
		}
		return res;

	}
	public int get(char c1,char c2){
		if(c1=='I'){
			if('V'==c2){
				return 4;
			}else if('X'==c2){
				return 9;
			}else{
				return 1;
			}
		}else if(c1=='X'){
			if('L'==c2){
				return 40;
			}else if('C'==c2){
				return 90;
			}else{
				return 10;
			}
		} else if(c1=='C'){
			if('D'==c2){
				return 400;
			}else if('M'==c2){
				return 900;
			}else{
				return 100;
			}
		}else if(c1=='V'){
			return 5;
		}else if(c1=='L'){
			return 50;
		}else if(c1=='C'){
			return 100;
		}else if(c1=='D'){
			return 500;
		}else if(c1=='M'){
			return 1000;
		}else{
			return 0;
		}

	}
}
