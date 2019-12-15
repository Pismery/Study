package com.pismery.study.api.collector;

import com.pismery.study.api.collector.CollectorDemo.Task;
import com.pismery.study.api.collector.CollectorDemo.TaskType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectorDemoTest {

    private List<Task> taskList;

    @Before
    public void init() {
        taskList = Arrays.asList(
                getTask("1", "read", TaskType.READ, LocalDate.MIN, LocalDate.MAX),
                getTask("2", "write", TaskType.WRITE, LocalDate.MIN, LocalDate.MAX),
                getTask("3", "read", TaskType.READ, LocalDate.MIN, LocalDate.MAX),
                getTask("4", "write", TaskType.WRITE, LocalDate.MIN, LocalDate.MAX),
                getTask("5", "read", TaskType.READ, LocalDate.MIN, LocalDate.MAX),
                getTask("5", "read", TaskType.READ, LocalDate.MIN, LocalDate.MAX)
        );
    }

    private Task getTask(String id, String title, TaskType type, LocalDate createOn, LocalDate dueOn) {
        return new Task(id, title, type, createOn, 1, false, new HashSet(), dueOn);
    }

    @Test
    public void collectToList() {
        List result = CollectorDemo.collectToList(taskList);
        assertThat(result.size()).isEqualTo(6);
    }

    @Test
    public void collectToSet() {
        Set result = CollectorDemo.collectToSet(taskList);
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void collectToMap() {
        Map result = CollectorDemo.collectToMap(taskList);
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void collectToLinkedHashMap() {
        LinkedHashMap result = CollectorDemo.collectToLinkedHashMap(taskList);
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void collectToConcurrentHashMap() {
        ConcurrentHashMap result = CollectorDemo.collectToConcurrentHashMap(taskList);
        assertThat(result.size()).isEqualTo(2);
    }


    @Test
    public void collectToOther() {
        LinkedHashSet result = CollectorDemo.collectToLinkedHashSet(taskList);
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void groupByTaskType() {
        Map<TaskType, List<Task>> result = CollectorDemo.groupByTaskType(taskList);
        assertThat(result.get(TaskType.READ).size()).isEqualTo(4);
    }

    @Test
    public void partitionByTaskType() {
        Map<Boolean, List<Task>> result = CollectorDemo.partitionByTaskType(taskList);
        assertThat(result.get(true).size()).isEqualTo(4);

    }

    @Test
    public void joinTitle() {
        assertThat(CollectorDemo.joinTite(taskList)).isEqualTo("[read,write,read,write,read,read]");
    }

    @Test
    public void collectToValue() {
        CollectorDemo.collectToValue(taskList);
    }


}