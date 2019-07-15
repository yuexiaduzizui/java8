package com.java8;

import sun.rmi.runtime.Log;

import java.util.DuplicateFormatFlagsException;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallerProcessing {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("The best process time=> "+measureSumPerformance(ParallerProcessing::normalAdd,100000000)+"ms");
//        System.out.println("==========================================================");
//        System.out.println("The best process time=> "+measureSumPerformance(ParallerProcessing::iteratorStream,10000000)+"ms");
//        System.out.println("==========================================================");
//        System.out.println("The best process time=> "+measureSumPerformance(ParallerProcessing::iteratorParellStream,10000000)+"ms");
        System.out.println("The best process time=> "+measureSumPerformance(ParallerProcessing::longStream,100000000)+"ms");
    }

    private static long measureSumPerformance(Function<Long,Long> adder,long limit) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0;i < 10;i++) {
            long start = System.currentTimeMillis();
            Long result = adder.apply(limit);
            long duration = System.currentTimeMillis()-start;
            System.out.println("The result of sum=>"+result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    private static Long iteratorStream(long limit) {
        return Stream.iterate(1L,i -> i+1).limit(limit).reduce(0L,Long::sum);
    }

    private static Long iteratorParellStream(long limit) {
        return Stream.iterate(1L,i -> i+1).parallel().limit(limit).reduce(0L,Long::sum);
    }

    private static Long longStream(long limit) {
        return LongStream.rangeClosed(0L,limit).parallel().sum();
    }

    private static Long normalAdd(long limit) {
        long result = 0L;
        for (long i = 1L;i < limit;i++) {
            result += i;
        }
        return result;
    }
}
