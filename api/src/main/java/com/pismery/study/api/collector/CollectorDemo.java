package com.pismery.study.api.collector;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class CollectorDemo {

    public static List<Task> collectToList(List<Task> list) {
        return new ArrayList<>(list);
    }

    public static Set<Task> collectToSet(List<Task> list) {
        return new HashSet<>(list);
    }

    public static HashMap<String, Task> collectToMap(List<Task> list) {
        return list.stream().collect(Collectors.toMap(Task::getTitle, Function.identity(), (t1, t2) -> t2, HashMap::new));
    }

    public static ConcurrentHashMap<String, Task> collectToConcurrentHashMap(List<Task> list) {
        return list.stream().collect(Collectors.toMap(Task::getTitle, Function.identity(), (t1, t2) -> t2, ConcurrentHashMap::new));
    }

    public static LinkedHashMap<String, Task> collectToLinkedHashMap(List<Task> list) {
        return list.stream().collect(Collectors.toMap(Task::getTitle, Function.identity(), (t1, t2) -> t2, LinkedHashMap::new));
    }

    public static LinkedHashSet<Task> collectToLinkedHashSet(List<Task> list) {
        return new LinkedHashSet<>(list);
    }

    public static Map<TaskType, List<Task>> groupByTaskType(List<Task> list) {
        return list.stream().collect(Collectors.groupingBy(Task::getType));
    }

    public static Map<Boolean, List<Task>> partitionByTaskType(List<Task> list) {
        return list.stream().collect(
                Collectors.partitioningBy(task -> task.getType().equals(TaskType.READ))
        );
    }




    public static void collectToValue(List<Task> list) {
        Double average = list.stream().collect(Collectors.averagingInt(Task::getValue));
        log.debug("task list average: " + average);


        List<Long> integerList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L);
        average = integerList.stream().collect(Collectors.averagingInt(value -> value.intValue())); //4.5
        log.debug("integer list  (averagingInt) average: " + average);
        average = integerList.stream().collect(Collectors.averagingLong(value -> value)); //4.5
        log.debug("integer list  (averagingLong) average: " + average);
        average = integerList.stream().collect(Collectors.averagingDouble(value -> value)); //4.5
        log.debug("integer list  (averagingDouble) average: " + average);


        IntSummaryStatistics collect = integerList.stream().collect(Collectors.summarizingInt(value -> value.intValue()));
        log.debug("integer list (IntSummaryStatistics) average: " + collect.getAverage()); //4.5
        log.debug("integer list (IntSummaryStatistics) getMax: " + collect.getMax()); //1
        log.debug("integer list (IntSummaryStatistics) getMin: " + collect.getMin()); //8
        log.debug("integer list (IntSummaryStatistics) getSum: " + collect.getSum()); //1+2+..+8 = 36
        log.debug("integer list (IntSummaryStatistics) getCount: " + collect.getCount()); //8
        log.debug("integer list (Collectors) counting: " + (Long) integerList.stream().count()); //8
    }


    public static String joinTite(List<Task> taskList) {
        return taskList.stream()
                .map(Task::getTitle)
                .collect(Collectors.joining(",", "[", "]"));

    }


    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Task {
        private final String id;
        private final String title;
        private final TaskType type;
        private final LocalDate createdOn;
        private Integer value;

        private boolean done = false;
        private Set tags = new HashSet<>();
        private LocalDate dueOn;
    }


    public enum TaskType {
        WRITE, READ
    }
}
