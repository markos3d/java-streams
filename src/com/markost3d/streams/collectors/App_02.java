package com.markost3d.streams.collectors;

import static java.util.stream.Collectors.*;

import java.util.TreeSet;
import java.util.stream.IntStream;

// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html
/**
 * toList
 * toSet
 * toCollection
 * toMap
 * partitioningBy
 */

public class App_02 {
    public static void main(String[] args) {
        var result1 = IntStream
            .range(0, 10)
            .boxed()
            .collect(toList());

        System.out.println(result1);
        System.out.println(result1.getClass().getName());

        var result2 = IntStream
            .range(0, 10)
            .boxed()
            .collect(toSet());

        System.out.println(result2);
        System.out.println(result2.getClass().getName());

        var result3 = IntStream
            .range(0, 10)
            .boxed()
            .collect(toCollection(TreeSet::new));

        System.out.println(result3);
        System.out.println(result3.getClass().getName());

        // i -> i is same as Function.identity()
        var result4 = IntStream
            .range(0, 10)
            .boxed()
            .collect(toMap(i -> i, i -> i * 3));

        System.out.println(result4);
        System.out.println(result4.getClass().getName());


        var result5 = IntStream
            .range(0, 10)
            .boxed()
            .collect(partitioningBy(i -> i % 2 == 0, toSet() ));

        System.out.println(result5);
        System.out.println(result5.getClass().getName());

        System.out.println(result5.get(true).getClass().getName());

    }
}
