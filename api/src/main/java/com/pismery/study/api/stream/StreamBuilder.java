package com.pismery.study.api.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class StreamBuilder {

    public static void main(String[] args) {
        createStream();
        streamToCollection();
    }

    private static void streamToCollection(){
        log.debug("streamToCollection");
        Stream stream = Stream.of(1,2,3,4);
        log.debug("stream.collect(Collectors.toList()):"+stream.collect(Collectors.toList()).toString());
        stream = Stream.of(1,2,3,4);
        log.debug("stream.collect(Collectors.toCollection(ArrayList::new)):"+stream.collect(Collectors.toCollection(ArrayList::new)).toString());
        stream = Stream.of(1,2,3,4);
        log.debug("stream.collect(Collectors.toSet()):"+stream.collect(Collectors.toSet()).toString());
        stream = Stream.of("1","2","3","4");
        log.debug("stream.collect(Collectors.joining()):"+stream.collect(Collectors.joining()).toString());
        stream = Stream.of(1,2,3,4);
        log.debug("stream.collect(Collectors.joining()):" + stream.toArray(Integer[]::new));
    }

    private static void createStream(){
        log.debug("createStream");

        Stream stream ;
        //way1
        stream = Stream.of(1,2,3,4);
        log.debug("way1"+stream.collect(Collectors.toList()).toString());

        //way2
        int[] ints = new int[]{1,2,3,4};
        Integer[] integers = new Integer[]{1,2,3,4};
        stream = Arrays.stream(integers);
        log.debug("way2"+stream.collect(Collectors.toList()).toString());
        stream = Stream.of(ints);
        log.debug("way2"+stream.collect(Collectors.toList()).toString());
        stream = Stream.of(integers);
        log.debug("way2"+stream.collect(Collectors.toList()).toString());

        //way3
        List list = Arrays.asList(1,2,3,4);
        stream = list.stream();
        log.debug("way3"+stream.collect(Collectors.toList()).toString());

        stream = Stream.generate(() -> 1).limit(4);
        log.debug("way4"+stream.collect(Collectors.toList()).toString());

        //way4
        stream = Stream.iterate(0, n -> n+3).limit(4);
        log.debug("way4"+stream.collect(Collectors.toList()).toString());

        //way5
        IntStream streamInt = "12345_abcdefg".chars();
        streamInt.forEach(p -> System.out.println(p));
    }
}
