package com.markost3d.mapping;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class App {
    
    public static void main(String[] args) {

        var list1 = IntStream.range(0, 10)
                .boxed()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());

        System.out.println(list1);

        var list2 = IntStream.range(0, 10)
                .boxed()
                .map(n -> String.format("Option number: %d", n))
                .collect(Collectors.toList());

        System.out.println(list2);
        System.out.println();

        Map<String, Integer> peopleMap = Map.of("Pip", 23, "Estella", 23, "Miss Haversham", 56, "Magwitch", 60);
        
        peopleMap.entrySet()
            .stream()
            .map(e -> new Person(e.getKey(), e.getValue()))
            .forEach(System.out::println);

        System.out.println();

        peopleMap.keySet()
            .stream()
            .map(Person::new)
            .forEach(System.out::println);
    }
}
