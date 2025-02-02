package com.markost3d.streams.collectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class App_01 {
    public static void main(String[] args) {
       
        // purpose is to create mutable container
        var supllier = new Supplier<List<Integer>>() {
            
            private static int instances;

            public void reset() {
                instances = 0;
            }

            public List<Integer> get() {
                instances++;
                System.out.println("supplier " + instances);
                return new ArrayList<Integer>();
            }
        };

        var accumulator = new BiConsumer<List<Integer>, Integer>() {
            public void accept(List<Integer> t, Integer u) {
                System.out.println("accumulate");
                t.add(u);
            }
        };
        
        // called only when using parallel streams
        var combiner = new BiConsumer<List<Integer>, List<Integer>>() {
            public void accept(List<Integer> t, List<Integer> u) {
                System.out.println("combiner");
                t.addAll(u);
            }
        };

        var result1 = IntStream.range(0, 5)
        .boxed()
        .collect(supllier, accumulator, combiner);

        System.out.println(result1);

        System.out.println();

        supllier.reset();

        var result2 = IntStream.range(0, 200)
        .boxed()
        .parallel()
        .collect(supllier, accumulator, combiner);

        System.out.println(result2);

        System.out.println();

        supllier.reset();

        var collector = new Collector<Integer, List<Integer>, Set<Integer>>() {

            public Supplier<List<Integer>> supplier() {
                return supllier;
            }

            public BiConsumer<List<Integer>, Integer> accumulator() {
                return accumulator;
            }

            public BinaryOperator<List<Integer>> combiner() {
                return (s, t) -> {s.addAll(t); return s;};
            }

            public Function<List<Integer>, Set<Integer>> finisher() {
                return u -> new HashSet<Integer>(u);
            }

            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.UNORDERED);
            }
            
        };

        var result3 = IntStream.range(0, 200)
        .boxed()
        .parallel()
        .collect(collector);

        System.out.println(result3);
        System.out.println(result3.getClass().getName());
    }
}
