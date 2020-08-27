package com.deep.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-11-1 16:49
 */
public class QueueTets {
    private static InheritableThreadLocal<ConcurrentLinkedQueue<Long>> waitProcessStoreQueue =new InheritableThreadLocal<>();
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Long> queue =new ConcurrentLinkedQueue<>();
        List<Long> ids =new ArrayList<Long>();
        for (long i=0l;i<100l;i++){
            ids.add(i);
        }
        queue.addAll(ids);
        waitProcessStoreQueue.set(queue);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ConcurrentLinkedQueue<Long> queue = waitProcessStoreQueue.get();
                Long sid =null;
                while((sid = queue.poll())!=null){
                    System.out.println("sid"+sid);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ConcurrentLinkedQueue<Long> queue = waitProcessStoreQueue.get();
                if(queue == null || queue.isEmpty()){
                    System.out.println("queue is null");
                }
                Long sid =null;
                while((sid = queue.poll())!=null){
                    System.out.println("sid1"+sid);
                }
            }
        }).start();

    }
}
