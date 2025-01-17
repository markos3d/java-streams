package com.markost3d.streams.introduction;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
       
       var set1 = Set.of(1, 2, 3, 4);
       var stream1 = set1.stream();
       stream1.forEach(System.out::println);

       Arrays.asList("one", "two", "three", "four").forEach(System.out::println);

       Stream.Builder<Double> streamBuilder = Stream.builder();
       streamBuilder.add(1.2);
       streamBuilder.add(2.3).add(3.4).add(7.1);

       Stream<Double> stream2 = streamBuilder.build();
       stream2.forEach(System.out::println);

       System.out.println();
       IntStream.range(0, 10).forEach(System.out::println);
       System.out.println();
       IntStream.iterate(2, a -> a < 100,a-> a + 2).forEach(System.out::println);
       System.out.println();
       IntStream.iterate(2, a-> a + 2).takeWhile(a -> a < 100).forEach(System.out::println);
       System.out.println();
       Stream.iterate("a", a -> a + "a").takeWhile(a -> a.length() < 20).forEach(System.out::println);
       System.out.println();
       Random random = new Random();
       Stream.generate(() -> random.nextDouble()).takeWhile(a -> a > 0.01).forEach(System.out::println);
    }
} 
