package com.deep.test.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 拆分大集合
 * 
 * @ClassName: CollectionSplitUtil 
 * @author 汪诗洋
 * @date 2018年1月4日 下午8:04:49
 * @version V2.0 
 *
 */
public class CollectionSplitUtil {
			
			public static <T> List<List<T>> split(List<T> resList,int count){
		        
		        if(resList==null ||count<1)
		            return  null ;
		        List<List<T>> ret=new ArrayList<List<T>>();
		        int size=resList.size();
		        if(size<=count){ //数据量不足count指定的大小
		            ret.add(resList);
		        }else{
		            int pre=size/count;
		            int last=size%count;
		            //前面pre个集合，每个大小都是count个元素
		            for(int i=0;i<pre;i++){
		                List<T> itemList=new ArrayList<T>();
		                for(int j=0;j<count;j++){
		                    itemList.add(resList.get(i*count+j));
		                }
		                ret.add(itemList);
		            }
		            //last的进行处理
		            if(last>0){
		                List<T> itemList=new ArrayList<T>();
		                for(int i=0;i<last;i++){
		                    itemList.add(resList.get(pre*count+i));
		                }
		                ret.add(itemList);
		            }
		        }
		        return ret;
		        
		    }
		
			
			public static Object[] splitAry(String[] ary, int subSize) {
		        int count = ary.length % subSize == 0 ? ary.length / subSize: ary.length / subSize + 1;
		        List<List<String>> subAryList = new ArrayList<List<String>>();
		        for (int i = 0; i < count; i++) {
		         int index = i * subSize;
		         List<String> list = new ArrayList<String>();
		         int j = 0;
		             while (j < subSize && index < ary.length) {
		                 list.add(ary[index++]);
		                 j++;
		             }
		         subAryList.add(list);
		        }
		        Object[] subAry = new Object[subAryList.size()];
			        for(int i = 0; i < subAryList.size(); i++){
			             List<String> subList = subAryList.get(i);
			             String[] subAryItem = new String[subList.size()];
			             for(int j = 0; j < subList.size(); j++){
			                 subAryItem[j] = subList.get(j);
			             }
			             subAry[i] = subAryItem;
			        }
		        return subAry;
		   }
			
}
	
