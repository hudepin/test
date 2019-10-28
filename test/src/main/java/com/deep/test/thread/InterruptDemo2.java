package com.deep.test.thread;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-5-28 13:58
 */
public class InterruptDemo2 {
    public static boolean interrupted = false;
    public static int sum=0;

    public static void main(String[] args) {
        new Thread(()->{
            while(!interrupted){
                sum++;
            }
            System.out.println(sum);
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interrupted = true;
        System.out.println(interrupted);
    }
}
