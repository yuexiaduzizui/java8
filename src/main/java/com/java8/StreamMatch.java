package com.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
//        boolean b = stream.allMatch(i -> i > 5);
//        System.out.println(b);
//        boolean b1 = stream.allMatch(i -> i > 0);
//        System.out.println(b1);
//        boolean b = stream.anyMatch(i -> i > 6);
//        System.out.println(b);
        boolean b = stream.noneMatch(i -> i < 0);
        System.out.println(b);


    }
}
