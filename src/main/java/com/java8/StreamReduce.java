package com.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Integer reduce = stream.reduce(0, (i, j) -> i + j);
        System.out.println(reduce);

        System.out.println("======================================================");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce((i,j) -> {
           return  i > j ? i : j;
        }).ifPresent(System.out::println);

        System.out.println("======================================================");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce(Integer::min).ifPresent(System.out::println);

        System.out.println("======================================================");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce(Integer::max).ifPresent(System.out::println);

        System.out.println("=====================================================");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce(Integer::sum).ifPresent(System.out::println);

    }

}
