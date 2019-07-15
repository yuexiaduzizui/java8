package com.java8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectionAction3 {

    public static void main(String[] args) {
        testPartioningByWithPredicate();
        testPartioningByWithPredicateAndCollection();
        testReducingBinaryOperator();
        testReducingBinaryOperatorAndIdentiy();
        testReducingBinaryOperatorAndIdentiyAndFuction();
        testSummarizingDouble();

    }

    private static  void testPartioningByWithPredicate() {
        Map<Boolean, List<Dish>> collect = CollectorsAction.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testPartioningByWithPredicateAndCollection() {
        Map<Boolean, Double> collect = CollectorsAction.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperator() {
        CollectorsAction.menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Dish::getCalories)))).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentiy() {
        Integer collect = CollectorsAction.menu.stream().map(Dish::getCalories).
                collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

    private static void testReducingBinaryOperatorAndIdentiyAndFuction() {
        Integer collect = CollectorsAction.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

    private static void testSummarizingDouble() {
        DoubleSummaryStatistics collect = CollectorsAction.menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getAverage()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getCount()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getMax()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getMin()));

    }


}
