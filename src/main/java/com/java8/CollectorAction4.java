package com.java8;

import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

public class CollectorAction4 {

    public static void main(String[] args) {
        testSummingDouble();
        testToCollection();
        testToConrrentMap();
        testToConrrentMapWithOperator();
        testToConrrentMapWithOperatorAndSupplier();
        testToSynchronizedMap();
    }

    private static void testSummingDouble() {
        DoubleSummaryStatistics collect = CollectorsAction.menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getMin()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getMax()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getCount()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getAverage()));
        Optional.of(collect).ifPresent(x -> System.out.println(x.getSum()));

        int sum = CollectorsAction.menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum();
        Optional.of(sum).ifPresent(System.out::println);
    }

    private static void testToCollection() {
        Optional.of(CollectorsAction.menu.stream().filter(x -> x.getCalories() > 600).collect(Collectors.toCollection(LinkedList::new))).ifPresent(System.out::println);
    }

    private static void testToConrrentMap() {
        Optional.of(CollectorsAction.menu.stream().collect(Collectors.toConcurrentMap(Dish::getName,Dish::getCalories))).ifPresent(x -> {
            System.out.println(x);
            System.out.println(x.getClass());
        });
    }

    private static void testToConrrentMapWithOperator() {
        Optional.of(CollectorsAction.menu.stream().collect(Collectors.toConcurrentMap(Dish::getType,v -> 1L,(a,b) -> a+b))).ifPresent(x -> {
            System.out.println(x);
            System.out.println(x.getClass());
        });
    }

    private static void testToConrrentMapWithOperatorAndSupplier() {
        Optional.of(CollectorsAction.menu.stream().
                collect(Collectors.toConcurrentMap(Dish::getType,v -> 1L,(a,b) -> a+b ,ConcurrentSkipListMap::new)))
        .ifPresent(x -> {
            System.out.println(x);
            System.out.println(x.getClass());
        });
    }

    private static void testToSynchronizedMap() {
        Optional.of(CollectorsAction.menu.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toMap(Dish::getName,Dish::getCalories),
                        Collections::synchronizedMap))
        ).ifPresent(x -> {
            System.out.println(x);
            System.out.println(x.getClass());
        });
    }
}
