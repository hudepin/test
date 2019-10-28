package com.deep.test.entity;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * <p>Description:</p>
 * Created with IDEA
 * author:hudepin
 * createTime:2019-6-3 16:47
 */
public class Shop {
    Random random = new Random();

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getPice(String product) {
        delay();
        return random.nextDouble() * 100;
    }

    public Future<Double> getPriceAsync(String product) {
        //CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //new Thread(() -> futurePrice.complete(getPice(product))).start();
        /*
        * supplyAsync()该方法对线程异常进行处理，避免出现异常后的堵塞
        * */
        return CompletableFuture.supplyAsync(() -> (getPice(product)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        Shop show = new Shop("bestShow");
        long start = System.currentTimeMillis();
        Future<Double> futurePrice = show.getPriceAsync("some product");
        System.out.println("调用返回，耗时" + (System.currentTimeMillis() - start));
        double price = futurePrice.get();
        System.out.println("价格返回，耗时" + (System.currentTimeMillis() - start));

    }


}
