package com.deep.test.letcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-6-6 16:03
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

 返回获得利润的最大值。

 示例 1:

 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 输出: 8
 解释: 能够达到的最大利润:
 在此处买入 prices[0] = 1
 在此处卖出 prices[3] = 8
 在此处买入 prices[4] = 4
 在此处卖出 prices[5] = 9
 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 注意:

 0 < prices.length <= 50000.
 0 < prices[i] < 50000.
 0 <= fee < 50000.
 */
public class Price {
    public static final int priceMaxLength = 50000;
    public static final String stop="q";

    public int maxProfit(int[] prices, int fee) {
        if(prices==null|| prices.length>priceMaxLength){
            throw new RuntimeException("price length is too large");
        }
        if(fee<0||fee>=priceMaxLength){
            throw new RuntimeException("fee not over"+priceMaxLength);
        }
        // 1买，0卖
        Map<Integer,Integer> flag = new TreeMap<Integer, Integer>();
        int sell;
        int buy;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<0 || prices[i]>= priceMaxLength){
                throw new RuntimeException("price limit error");
            }
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){

                }
            }


        }

        return 0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.next();
            if(command !=null){
                if(stop.equals(command)){
                    break;
                }else{

                }
            }
        }

    }

}
