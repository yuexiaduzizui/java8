package com.java8;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.filter(x -> x > 3).reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("========================================");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        int sum = stream.mapToInt(Integer::intValue).sum();
        System.out.println(sum);
//        int(4byte/32bite)

        System.out.println("========================================");
        int a = 9;
        IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a,b,(int)Math.sqrt(a*a+b*b)})
                .forEach(r -> System.out.println("a="+r[0]+",b="+r[1]+",c="+r[2]));

    }
}
