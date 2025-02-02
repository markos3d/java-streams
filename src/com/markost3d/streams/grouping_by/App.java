package com.markost3d.streams.grouping_by;

import java.util.List;
import static java.util.stream.Collectors.*;

public class App {

    record Person(String name, int age, int height) {}

    public static void main(String[] args) {
        
        var people = List.of(
                        new Person("Bob", 52, 182),
                        new Person("Bob", 24, 184),
                        new Person("Claire", 46, 170),
                        new Person("Claire", 46, 165)
                    );

        var result1 = people
                        .stream()
                        .collect(groupingBy(Person::name));
        System.out.println(result1);

        var result2 = people
                        .stream()
                        .collect(groupingBy(Person::name, counting()));
        System.out.println(result2);

        var result3 = people
                        .stream()
                        .collect(groupingBy(Person::name, averagingInt(Person::age)));
        System.out.println(result3);

        var result4 = people
                        .stream()
                        .collect(
                            groupingBy(
                                Person::name, 
                                groupingBy(Person::age)
                            ));
        System.out.println(result4);

        var result5 = people
                        .stream()
                        .collect(
                            groupingBy(
                                Person::name, 
                                groupingBy(
                                    Person::age,
                                    counting()
                                )
                            ));
        System.out.println(result5);

        var result6 = people
                        .stream()
                        .collect(
                            groupingBy(
                                Person::name, 
                                mapping(Person::age, toList())
                            )
                        );
        System.out.println(result6);

        var result7 = people
                        .stream()
                        .collect(
                            groupingBy(
                                Person::name, 
                               filtering(p -> p.height() < 180, counting())
                            )
                        );
        System.out.println(result7);

    }
}
