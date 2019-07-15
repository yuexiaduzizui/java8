package com.java8;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class GroupingByStream {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        testGroupingByFuctionAndCollection(menu);
        System.out.println("==================================");
        testGroupingBySupplierFuctionAndCollection(menu);
        System.out.println("===================================");
        testSummarizingInt(menu);
    }

    private static void testGroupingByFuctionAndCollection(List<Dish> menu) {
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect);
        Map<Dish.Type, Double> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        System.out.println(collect1);
    }

    private static void testGroupingBySupplierFuctionAndCollection(List<Dish> menu) {
        TreeMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getClass()));
    }

    private static void testSummarizingInt(List<Dish> menu) {
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getAverage()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getCount()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getMax()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getMin()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getSum()));
    }

}
