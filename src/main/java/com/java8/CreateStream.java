package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {

//        createStreamFromCollection().forEach(System.out::println);
//        System.out.println("=====================================");
//        createStreamFromValues().forEach(System.out::println);
//        System.out.println("====================================");
//        createStreamFromArrays().forEach(System.out::println);
//        System.out.println("=====================================");
//        createStreamFromIterator().forEach(System.out::println);
        System.out.println("=====================================");
        createStreamFromGrenareter().forEach(System.out::println);

    }

    private static Stream<String> createStreamFromCollection() {

        List<String> list = Arrays.asList("hello", "alex", "lucy", "lily", "world");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues() {

        return Stream.of("hello", "alex", "lucy", "lily", "world");
    }

    private static Stream<String> createStreamFromArrays() {

        return Arrays.stream(new String[]{"hello", "alex", "lucy", "lily", "world"});
    }

    private static Stream<Integer> createStreamFromIterator() {

        return Stream.iterate(0,n -> n+2);
    }

    private static Stream<Double> createStreamFromGrenareter() {

        return Stream.generate(Math::random).limit(10);
    }

}
