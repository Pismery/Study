package com.pismery.study.structure.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class BTreeTest {

    @Test
    public void testList() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(2,3);
        log.debug(list.toString());
    }

}