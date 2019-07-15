package com.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

    public static void main(String[] args) {

        Comparator<Apple> bycolor = new Comparator<Apple>() {

            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getColor().compareTo(a2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        list.sort(bycolor);

        List<Apple> list2 = Collections.emptyList();
        Comparator<Apple> bycolor2 = (a1,a2) -> a1.getColor().compareTo(a2.getColor());
        list2.sort(bycolor2);
        System.out.println(list2);

    }
}
