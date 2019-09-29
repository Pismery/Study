package com.pismery.study.api.stream;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamApi {
    public static void main(String[] args) {
        intermediate();
        terminal();
    }

    private static void intermediate() {
        map();
        mapToInt();
        flatMap();
        filter();
        distinct();
        distictById();
        sorted();
        peek();
        limit();
        sequentialAndParallel();
        unordered();
    }

    private static void terminal() {
        foreach();
        forEachOrdered();
        toArray();
        reduce();
        collect();
        min_max_count();
        match();
        find();
    }
    private static void find() {
        System.out.println("find");
        Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x >= 2).findFirst().ifPresent(x -> System.out.println("findFirst:" + x));
        Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x >= 2).findAny().ifPresent(x -> System.out.println("findAny:" + x));
        Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x >= 2).parallel().findAny().ifPresent(x -> System.out.println("findAny:" + x));
    }
    private static void match() {
        System.out.println("match");
        System.out.println("[1, 2, 3, 5, 4].anyMatch: x -> x > 4): " + Stream.of(1, 2, 3, 5, 4).anyMatch(x -> x > 4));
        System.out.println("[1, 2, 3, 5, 4].anyMatch: x -> x > 5): " + Stream.of(1, 2, 3, 5, 4).anyMatch(x -> x > 5));

        System.out.println("[1, 2, 3, 5, 4].allMatch: x -> x > 0): " + Stream.of(1, 2, 3, 5, 4).allMatch(x -> x > 0));
        System.out.println("[1, 2, 3, 5, 4].allMatch: x -> x > 1): " + Stream.of(1, 2, 3, 5, 4).allMatch(x -> x > 1));

        System.out.println("[1, 2, 3, 5, 4].noneMatch: x -> x > 5): " + Stream.of(1, 2, 3, 5, 4).noneMatch(x -> x > 5));
        System.out.println("[1, 2, 3, 5, 4].noneMatch: x -> x > 4): " + Stream.of(1, 2, 3, 5, 4).noneMatch(x -> x > 4));
    }

    private static void min_max_count() {
        System.out.println("min_max_count");
        Stream.of(1,2,3,4).min(Integer::compareTo).ifPresent(min-> System.out.println("min: "+min));
        Stream.of(1,2,3,4).max(Integer::compareTo).ifPresent(max-> System.out.println("max: "+max));
        System.out.println("count: " + Stream.of(1, 2, 3, 4).count());
        System.out.println("mapToLong.sum: " + Stream.of(1, 2, 3, 4).mapToLong(x -> 1L).sum());
    }
    private static void collect() {
        System.out.println("collect");
        List result = Stream.of(1,2,3,4).collect(
                () -> new ArrayList<>(), //第一个方法
                (list, item) -> list.add(item),//第二个方法
                (one, two) -> one.addAll(two)//第三个方法
        );
        System.out.println("result:" + result);

        result = Stream.of(1,2,3,4).collect(Collectors.toList());
        System.out.println("result:" + result);
    }
    private static void reduce() {
        System.out.println("reduce");
        int startValue = 100;
        int result = Stream.of(1, 2, 3, 4).reduce(startValue, (sum, item) -> sum += item);
        System.out.println("T reduce(T identity, BinaryOperator<T> accumulator) : " + result);

        Stream.of(1, 2, 3, 4).reduce(Integer::sum).ifPresent(r -> System.out.println("Optional<T> reduce(BinaryOperator<T> accumulator): " + r));


        result = Stream.of(1, 2, 3, 4)
                .reduce(0, Integer::sum, (a, b) -> {
                    System.out.println("combiner");
                    return a + b;
                });
        System.out.println("<U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner) 1: " + result);

        result = Stream.of(1, 2, 3, 4)
                .parallel()
                .reduce(0, Integer::sum, (a, b) -> {
                    System.out.println("combiner");
                    return a + b;
                });
        System.out.println("<U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner) 1: " + result);
    }
    private static void toArray() {
        System.out.println("toArray");
        Object[] arr = Stream.of(1,2,3,4,5).toArray();
        for (Object o : arr) {
            System.out.print((int)o+" ");
        }
        System.out.println();
        System.out.println("toArray(IntFunction<A[]> generator)");
        String[] strs = Stream.of("a","b","c","d","e").toArray(String[]::new);
        for (String str : strs) {
            System.out.print(str+" ");
        }
    }
    private static void forEachOrdered() {
        System.out.println("forEach in parallel");
        Stream.of("1","2","3","4")
                .parallel().forEach(System.out::print);

        System.out.println();
        System.out.println("forEachOrdered in parallel");
        Stream.of("1","2","3","4")
                .parallel().forEachOrdered(System.out::print);
    }
    private static void foreach() {
        System.out.println("foreach");
        Stream.of(1,5,7,8,6)
                .forEach(x-> System.out.print(x+" "));
        System.out.println();
    }

    private static void unordered() {
        System.out.println("unordered");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(1));
        for (Integer i : list) {
            System.out.println("identityHashCode: "+System.identityHashCode(i));
        }

        System.out.println();
        list.stream()
                .parallel()
                .distinct()
                .forEach(x -> System.out.println("identityHashCode: "+System.identityHashCode(x)));

        System.out.println();
        list.stream()
                .unordered()
                .parallel()
                .distinct()
                .forEach(x -> System.out.println("identityHashCode: "+System.identityHashCode(x)));
    }

    private static void sequentialAndParallel() {
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(strings).sequential());
        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(strings).parallel());
    }

    public static void run (Stream<String> stream) {

        stream.forEach(s -> {
            log.debug(LocalTime.now() + " - value: " + s +
                    " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void limit() {
        log.debug("peek");
        Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> list = stream.limit(3).collect(Collectors.toList());
        log.debug(list.toString());
    }

    private static void peek() {
        log.debug("peek");
        Stream.of("bus", "car", "bycle", "flight", "train")
                .filter(e -> e.length() > 3)
                .peek(e -> log.debug("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> log.debug("Mapped value: " + e))
                .limit(1)
                .collect(Collectors.toList());
    }

    private static void sorted() {
        log.debug("sorted");
        Person p1 = new Person(1, "Pismery1");
        Person p2 = new Person(2, "Pismery2");
        Person p3 = new Person(2, "Pismery3");
        List<Person> people;
        Stream<Person> stream;

        stream = Stream.of(p1, p2, p1, p2, p2);
        people = stream.sorted().collect(Collectors.toList());
        log.debug("sorted: " + people.toString());

        stream = Stream.of(p1, p2, p1, p2, p2);
        people = stream.sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
        log.debug("comparing: " + people.toString());

        stream = Stream.of(p1, p3, p2);
        people = stream.sorted(
                            Comparator.comparing(
                                    p -> ((Person) p).getId())
                                    .thenComparing(p -> ((Person) p).getName()
                            )
                        ).collect(Collectors.toList());
        log.debug("thenComparing: " + people.toString());

        Stream<Integer> stream2 = Stream.of(5, 7, 2, 1, 3, 6, 4);
        List<Integer> integerList = stream2.sorted(Comparator.comparing(p -> (Integer) p).reversed()).collect(Collectors.toList());
        log.debug(integerList.toString());

        stream2 = Stream.of(5, 7, 2, 1, 3, 6, 4);
        integerList = stream2.sorted(Integer::compareTo).collect(Collectors.toList());
        log.debug(integerList.toString());
    }

    private static void distictById() {
        log.debug("distictById");
        Person p1 = new Person(1, "Pismery");
        Person p2 = new Person(1, "PismeryCopy");
        List<Person> people;
        Stream<Person> stream;

        stream = Stream.of(p1, p2, p1, p1, p2);
        people = stream.collect(Collectors.toList());
        log.debug(people.toString());

        stream = Stream.of(p1, p2, p1, p1, p2);
        people = stream.distinct().collect(Collectors.toList());
        log.debug(people.toString());

        stream = Stream.of(p1, p2, p1, p1, p2);
        people = stream.filter(disiinctByKey(person -> person.getId()))
                .collect(Collectors.toList());
        log.debug(people.toString());
    }

    //putIfAbsent(key,value)：如果map.get(key)不存在则put(value)，返回null；若存在则返回已有的value，并且不会put新的value进去；
    private static <T> Predicate<T> disiinctByKey(Function<? super T, Object> function) {
        Map map = new ConcurrentHashMap();
        return t -> map.putIfAbsent(function.apply(t), Boolean.TRUE) == null;
    }

    private static void distinct() {
        log.debug("distinct");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 2, 3, 3, 4);
        List<Integer> result = stream.distinct().collect(Collectors.toList());
        log.debug(result.toString());
    }

    private static void filter() {
        log.debug("filter");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = stream.filter(n -> n % 2 == 0).collect(Collectors.toList());
        log.debug(result.toString());
    }

    private static void flatMap() {
        log.debug("flatMap");
        //{{1,2,3},{4,5,6},{7,8}}
        Stream<List<Integer>> stream = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8));

        //{1,2,3,4,5,6,7,8}
        List<Integer> result = stream.flatMap(x -> x.stream()).collect(Collectors.toList());
        log.debug(result.toString());

    }

    private static void mapToInt() {
        log.debug("mapToInt");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        stream.mapToInt(n -> n * n).forEach(i -> log.debug("" + i));
    }

    private static void map() {
        log.debug("map");
        Stream<String> stream;
        List<String> result;

        //匿名函数写法
        stream = init();
        result = stream.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).collect(Collectors.toList());
        log.debug(result.toString());

        //lambda写法
        stream = init();
        result = stream.map(e -> e.toUpperCase())
                .collect(Collectors.toList());
        log.debug(result.toString());

        //函数引用写法
        stream = init();
        result = stream.map(String::toUpperCase)
                .collect(Collectors.toList());
        log.debug(result.toString());
    }

    private static Stream<String> init() {
        return Stream.of("a", "c", "e", "d");
    }
}
