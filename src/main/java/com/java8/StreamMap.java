package com.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamMap {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,2,3,4);
        List<Integer> collect = integers.stream().map(i -> i * 2).collect(toList());
//        System.out.println(collect);

        String[] worlds = {"hello", "world"};
        List<String> collect1 = Arrays.stream(worlds).map(x -> x.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collect1);
    }

}
