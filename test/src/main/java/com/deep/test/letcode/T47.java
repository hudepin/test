package com.deep.test.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hudepin
 * @Description
 * @ClassName T47
 * @create_date 2020.10.13 13:52
 * @since 1.2.0
 */
public class T47 {


    public static void main(String[] args) {
         AtomicInteger firstJobDone = new AtomicInteger(0);
        AtomicBoolean flag = new AtomicBoolean(false);
        flag.getAndSet(true);
         firstJobDone.incrementAndGet();
         firstJobDone.decrementAndGet();
       Semaphore fooSemaphore = new Semaphore(1);


        int[] nums = {1,2,1};
        List<List<Integer>> res =  new T47().permuteUnique(nums);
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((char)((int)'z'-32));
        "1231".toLowerCase();
        char c='c';
        String.valueOf(c);
        Character.isLetter('c');
        String[] ssss = "a good   example".split(" ");
      new T47().reverseWords("a good   example");
    }
    public String reverseWords(String s) {
        if(s==null || s.trim().length()==0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        String[] cs = s.trim().split(" ");
        for(int i=cs.length-1;i>=0;i--){
            if(cs[i].trim().length() !=0){
                res.append(cs[i].trim() + " ");
            }
        }
        return res.toString().trim();

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums,res,list,0,vis);
        return res;

    }
    public void dfs(int[] nums,List<List<Integer>> res,List<Integer> list,int idx,boolean[] vis){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i] || (i>0 && nums[i]==nums[i-1] && !vis[i-1])){
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;
            dfs(nums,res,list,idx+1,vis);
            vis[i] = false;
            list.remove(idx);
        }

    }
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());
        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }
}
