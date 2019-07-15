package com.java8;

import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectionAction {

    public static void main(String[] args) {
        Collector<String, List<String>,List<String>> collector = new ToListCollector();
        String[] arr = new String[]{"alax","lucy","lambda","java8","hello","lily"};
        List<String> result = Arrays.stream(arr).filter(s -> s.length() > 5).collect(collector);
        System.out.println(result);

    }
}
