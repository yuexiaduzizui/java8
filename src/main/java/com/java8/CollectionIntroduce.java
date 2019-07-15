package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CollectionIntroduce {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("green", 150L)
                , new Apple("yellow", 120L)
                , new Apple("green", 170L)
                , new Apple("green", 150L)
                , new Apple("yellow", 120L)
                , new Apple("green", 170L));
        Map<String, List<Apple>> collect = list.stream().collect(groupingBy(Apple::getColor));
        System.out.println(collect);
    }
}
