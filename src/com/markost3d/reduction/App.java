package com.markost3d.reduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        double[] doubles = {1.0, 2.0, 3.0};

        var result1 = DoubleStream.of(doubles).count();
        System.out.println(result1);

        var result2 = DoubleStream.of(doubles).sum();
        System.out.println(result2);

        var result3 = DoubleStream.of(doubles).average();
        System.out.println(result3.getAsDouble());

        var result4 = DoubleStream.of(doubles).min();
        System.out.println(result4.getAsDouble());

        var result5 = DoubleStream.of(doubles).max();
        System.out.println(result5.getAsDouble());

        var result6 = DoubleStream.of(doubles).reduce((a, b) -> a * b);
        System.out.println(result6.getAsDouble());

        // Identity element (identitetni element) je neutralna vrednost za datu operaciju,
        // koja ne menja rezultat kada se kombinuje sa ostalim elementima u strimu.
        // - Za sabiranje: 0 (n + 0 = n)
        // - Za množenje: 1 (n * 1 = n)
        // - Za spajanje stringova: "" (prazan string, s + "" = s)
        // - Za spajanje kolekcija: prazna kolekcija (npr. Collections.emptyList())
        //
        // Koristi se kao početna vrednost u redukciji (reduce) operacijama Stream API-ja.
        var result7 = DoubleStream.of(doubles).reduce(1, (a, b) -> a * b);
        System.out.println(result7);

        var result8 = Stream.of("hello", "to", "you").reduce("", (a, b) -> a + b);
        System.out.println(result8);

        var result9 = Stream
            .of(1, 2, 3, 4)
            .map(List::of)
            .reduce(Collections.emptyList(), (a, b) -> {
                List<Integer> combined = new ArrayList<>(a);
                combined.addAll(b);
                return combined;
            });
        System.out.println(result9);

        // ili

        var result10 = Stream
            .of(1, 2, 3, 4)
            .map(List::of)
            .reduce(new ArrayList<>(), (a, b) -> {
                a.addAll(b);
                return a;
            });
        System.out.println(result10);

        // sum element of stream (doesn't showed in tutorial)
        var result11 = Stream
            .of(1, 2, 3, 4)
            .reduce(0, Integer::sum);
        System.out.println(result11);

    }
}
