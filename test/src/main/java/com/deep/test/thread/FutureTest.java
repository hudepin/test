package com.deep.test.thread;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName FutureTest
 * @create_date 2021.03.24 14:30
 * @since
 */
public class FutureTest {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.println("耗时任务执行完成！");
                return 200;
            }
        };
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callable);
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        try {
            //异步获取返回值，未返回阻塞直到获取结果
            Integer integer = integerFutureTask.get();
            //可以添加获取超时
            Integer result = integerFutureTask.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }


//        System.out.println(Runtime.getRuntime().availableProcessors());
//        long start = System.currentTimeMillis();
//        //IntStream.rangeClosed方法就是产生1到4整数，parallel为并行产生
//        IntStream.rangeClosed(1, 4).parallel().mapToObj(i -> delayMethod()
//        ).collect(Collectors.toList());//使用collect将所有结果收集起来，保证4个线程都执行完成再进入下一行打印
//        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * @return
     */
    private static int delayMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
