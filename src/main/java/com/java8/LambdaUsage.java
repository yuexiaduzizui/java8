package com.java8;

public class LambdaUsage {

    public static void main(String[] args) {

        Runnable r = () -> System.out.println("hello");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        process(r);
        process(r1);
        process(() -> System.out.println("hello"));
    }

    public static  void process(Runnable r) {
        r.run();
    }
}
