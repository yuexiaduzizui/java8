package com.java8;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletetableFutureInAction {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> completableFuture = new CompletableFuture();
        new Thread(() -> {
            double v = get();
            completableFuture.complete(v);
        }).start();
        System.out.println("no-------block---------");
//        Optional.of(completableFuture.get()).ifPresent(System.out::println);
        completableFuture.whenComplete((x,y) ->{
           Optional.of(x).ifPresent(System.out::println);
           Optional.of(y).ifPresent(e -> e.printStackTrace());
        });
    }

    public static double get() {
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new Random().nextDouble();
    }
}
