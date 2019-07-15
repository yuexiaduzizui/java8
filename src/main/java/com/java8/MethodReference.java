package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("abc",160L),new Apple("green",120L),new Apple("yellow",130L),new Apple("red",140L));
        list.sort(Comparator.comparing(Apple::getColor).reversed());
        System.out.println(list);
        list.forEach(System.out::println);

        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("123");
        System.out.println(apply);

        BiFunction<String, Integer, Character> function2 = String::charAt;
        Character hello = function2.apply("hello", 2);
        System.out.println(hello);


    }
}
