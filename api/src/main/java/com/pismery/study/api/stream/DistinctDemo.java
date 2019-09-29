package com.pismery.study.api.stream;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Record> records = getRecords();

        System.out.println("Distinct by custom key");
        records.stream()
                .filter(distinctByKey(CustomKey::new))
                .forEach(System.out::println);

        System.out.println("Distinct by field");
        records.stream()
                .filter(distinctByKeys(Record::getId, Record::getName))
                .forEach(System.out::println);

    }

    private static List<Record> getRecords() {
        List<Record> records = new ArrayList<>();

        records.add(new Record(1L, 10L, "record1", "record1@email.com", "GZ"));
        records.add(new Record(1L, 20L, "record1", "record1@email.com", "GZ"));
        records.add(new Record(2L, 30L, "record2", "record2@email.com", "GZ"));
        records.add(new Record(2L, 40L, "record2", "record2@email.com", "GZ"));
        records.add(new Record(3L, 50L, "record3", "record3@email.com", "GZ"));

        return records;
    }

    @SafeVarargs
    private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

        return t -> {
            final List<?> list = Arrays.stream(keyExtractors)
                    .map(key -> key.apply(t))
                    .collect(Collectors.toList());
            return seen.putIfAbsent(list,Boolean.TRUE) == null;
        };
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @EqualsAndHashCode
    private static class CustomKey {
        private long id;
        private String name;

        CustomKey(final Record record) {
            this.id = record.getId();
            this.name = record.getName();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Record {
        private long id;
        private long count;
        private String name;
        private String email;
        private String location;

        @Override
        public String toString() {
            return "Record [id=" + id + ", count=" + count + ", name=" + name +
                    ", email=" + email + ", location="
                    + location + "]";
        }
    }
}
