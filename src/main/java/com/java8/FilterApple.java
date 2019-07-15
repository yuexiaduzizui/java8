package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

    //1.使用策略模式
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    //2.使用lamda表达式
    @FunctionalInterface
    public interface LambdaAppleFilter {
        boolean filter(Apple apple);
    }

    public static  List<Apple> findApple(List<Apple> appleList,AppleFilter appleFilter) {

        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if (appleFilter.filter(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }

    public  static class GreenFilter implements  AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return "green".equals(apple.getColor()) && 130 < apple.getWegiht();
        }
    }


    public static List<Apple> findGreenApple(List<Apple> appleList){

        List<Apple> newAppleList = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                newAppleList.add(apple);
            }
        }
        return newAppleList;
    }

    public static List<Apple> findApple(List<Apple> appleList,String color) {

        List<Apple> newAppleList = new ArrayList<>();
        for (Apple apple : appleList) {
            if (color.equals(apple.getColor())) {
                newAppleList.add(apple);
            }
        }
        return newAppleList;
    }

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("green",150L),new Apple("yellow",130L));
//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size() == 2;
//        System.out.println(greenApples);
//
//        System.out.println("=====================华丽的分割线====================");
//
//        List<Apple> list2 = Arrays.asList(new Apple("green",250L),new Apple("yellow",380L));
//        List<Apple> yellowApples = findApple(list2,"yellow");
//        assert yellowApples.size() == 2;
//        System.out.println(yellowApples);

        List<Apple> list3 = Arrays.asList(new Apple("green",150L),new Apple("yellow",130L));
//        System.out.println("=====================华丽的分割线====================");
//        List<Apple> result = findApple(list3, new GreenFilter());
//        System.out.println(result);
//
//        System.out.println("=====================华丽的分割线====================");
//
//        List<Apple> list4 = Arrays.asList(new Apple("red",150L),new Apple("yellow",130L));
//        List<Apple> resultList = findApple(list4, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "yellow".equals(apple.getColor());
//            }
//        });
//        System.out.println(resultList);

        List<Apple> appleList = findApple(list3, apple -> {
            return "green".equals(apple.getColor());
        });
        System.out.println(appleList);
    }
}
