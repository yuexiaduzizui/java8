package com.java8;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureInAction3 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> Integer.sum(i,10))
                .whenComplete((v,e) -> System.out.println(v));
        Thread.sleep(1000);

        CompletableFuture.supplyAsync(() -> 1).handle((v,e) -> Integer.sum(v,10)).whenComplete((v,e) -> System.out.println(v));
        Thread.sleep(1000);

        CompletableFuture.supplyAsync(()-> 1)
                .thenApply(i -> Integer.sum(i,10))
                .thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> 1)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> 10*i ))
                .thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> 1)
        .thenCombine(CompletableFuture.supplyAsync(() -> 2.0d),(r1,r2)  -> r1 + r2).
                thenAccept(System.out::println);



    }
}
