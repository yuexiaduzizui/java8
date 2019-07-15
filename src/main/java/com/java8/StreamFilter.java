package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamFilter {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4,4, 5, 6,6);
        List<Integer> integerList = integers.stream().filter(x -> x % 2 == 0).distinct().skip(1).limit(1).collect(toList());
        System.out.println(integerList);

    }
}
