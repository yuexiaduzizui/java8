package com.java8;

import sun.rmi.log.LogInputStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SimpleStream {

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
        List<String> lowCalories = getDishNameByCollections(menu);
        System.out.println(lowCalories);

        List<String> dishNameByStream = getDishNameByStream(menu);
        System.out.println(dishNameByStream);

        Stream.of( new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT)).forEach(System.out::println);

    }

    private static List<String> getDishNameByCollections(List<Dish> menu) {

        List<Dish> lowCalories = new ArrayList<>();
        menu.forEach(x ->{
            if (x.getCalories() < 400) {
                lowCalories.add(x);
            }
        });
        Collections.sort(lowCalories, Comparator.comparing(Dish::getCalories));

        List<String> disNames = new ArrayList<>();
        lowCalories.forEach(x -> {
            disNames.add(x.getName());
        });
        return disNames;
    }

    private static  List<String> getDishNameByStream(List<Dish> menu) {

        List<String> dishNames = menu.stream().filter(x -> x.getCalories() < 400).
                sorted(Comparator.comparing(Dish::getCalories)).
                map(Dish::getName).collect(toList());
        return  dishNames;
    }
}
