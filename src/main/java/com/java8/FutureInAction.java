package com.java8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureInAction {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                return "i am finished";
            } catch (InterruptedException e) {
                return "error";
            }
        });
        String value = future.get();
        System.out.println(value);
        executorService.shutdown();
    }


}
