package com.java8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompletableFutureInAction {

    public static void main(String[] args) {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CompletableFuture.supplyAsync(CompletetableFutureInAction::get)
        .whenComplete((x,y) -> {
            Optional.of(x).ifPresent(System.out::println);
            atomicBoolean.set(true);
            Optional.of(y).ifPresent(e -> e.printStackTrace());
        });
//        Thread.currentThread().join();
        while (!atomicBoolean.get()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i no block");
    }
}
