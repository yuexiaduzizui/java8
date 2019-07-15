package com.java8;

import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

public class CollectorAction2 {

    public static void main(String[] args) {
        testGroupingByConcurrent();
        testGroupingByConcurrentWithFuctionAndCollection();
        testJoining();
        testJoiningWithPrefixAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
    }

    private static void testGroupingByConcurrent() {
        ConcurrentMap<Dish.Type, Double> collect = CollectorsAction.menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(collect).ifPresent(System.out::println);

    }

    private static void testGroupingByConcurrentWithFuctionAndCollection() {
        ConcurrentMap<Dish.Type, Double> collect = CollectorsAction.menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(collect).ifPresent(System.out::println);

        ConcurrentSkipListMap<Dish.Type, Double> collect1 = CollectorsAction.menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(collect1.getClass()).ifPresent(System.out::println);

    }

    private static void testJoining() {
        Optional.of(CollectorsAction.menu.stream().map(Dish::getName).collect(Collectors.joining(":"))).ifPresent(System.out::println);

    }

    private static void testJoiningWithPrefixAndSuffix() {
        Optional.of(CollectorsAction.menu.stream().map(Dish::getName).collect(Collectors.joining(",","NAMES[","]"))).ifPresent(System.out::println);

    }

    private static  void testMapping() {
        Optional.of(CollectorsAction.menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")))).ifPresent(System.out::println);

    }

    private static void testMaxBy() {
        CollectorsAction.menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testMinBy() {
        CollectorsAction.menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories))).ifPresent(System.out::println);
    }
}
