package com.java8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableInFutrureAction2 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2, r -> {
            Thread t = new Thread();
            t.setDaemon(false);
            return t;
        });
        CompletableFuture.supplyAsync(CompletetableFutureInAction::get,executorService)
                .thenApply(CompletableInFutrureAction2::multiply)
                .whenComplete((x,y) -> {
            Optional.of(x).ifPresent(System.out::println);
        });
        Thread.currentThread().join();
        System.out.println("i am no block");
    }

    private static double multiply(double d) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return d*100;
    }
}
