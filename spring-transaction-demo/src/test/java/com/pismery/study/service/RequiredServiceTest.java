package com.pismery.study.service;

import com.pismery.study.po.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


/**
 * senior:
 * 1. transaction nested transaction
 * 2. transaction nested exception transaction And exception in the first
 * 3. transaction nested exception transaction And exception in the last
 * 4. no transaction nested transaction
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequiredServiceTest {

    @Autowired
    private RequiredService service;

    @Before
    public void init() {

        log.debug("-------------------------------");
        log.debug("init...");
        service.saveAll(Arrays.asList(
                buildPerson("n1","p1"),
                buildPerson("n2","p2"),
                buildPerson("n3","p3"),
                buildPerson("n4","p4"))
        );
        log.debug("-------------------------------");
        log.debug("");
    }

    @After
    public void rollback() {
        log.debug("-------------------------------");
        log.debug("rollback...");
        service.findAll();
        service.deleteAll();
        service.findAll();
        log.debug("-------------------------------");
        log.debug("");
    }

    /**
     * 1. transaction nested transaction
     */
    @Test
    public void senior1() {
        log.debug("-------------------------------");
        log.debug("uploadWithTransaction begin...");
        service.uploadWithTransaction("n2", "updateName");
        log.debug("-------------------------------");
        log.debug("");
    }

    /**
     * 2. transaction nested exception transaction And exception in the first
     */
    @Test(expected = RuntimeException.class)
    public void senior2() {
        log.debug("-------------------------------");
        log.debug("uploadWithTransaction(exception) begin...");
        service.uploadWithTransaction("n5", "updateName");
        log.debug("-------------------------------");
        log.debug("");
    }

    /**
     * 3. transaction nested exception transaction And exception in the last
     */
    @Test(expected = RuntimeException.class)
    public void senior3() {
        log.debug("-------------------------------");
        log.debug("uploadWithException begin...");
        service.uploadWithException("n2", "updateName", "n5");
        log.debug("-------------------------------");
        log.debug("");
    }

    /**
     * 4. no transaction nested transaction
     */
    @Test
    public void senior4() {
        log.debug("-------------------------------");
        log.debug("uploadNoTransaction begin...");
        service.uploadNoTransaction("n2", "updateName");
        log.debug("-------------------------------");
        log.debug("");
    }

    /**
     * 5.
     */
    @Test(expected = RuntimeException.class)
    public void senior5() {
        log.debug("-------------------------------");
        log.debug("uploadNoTransaction begin...");
        service.uploadWithDefaultMethod("n2","updateName","n5");
        log.debug("-------------------------------");
        log.debug("");
    }


    private Person buildPerson(String personNo,String name) {
        Person person = new Person();
        person.setName(name);
        person.setPersonNo(personNo);
        return person;
    }
}