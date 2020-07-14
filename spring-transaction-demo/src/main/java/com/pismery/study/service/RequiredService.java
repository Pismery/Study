package com.pismery.study.service;

import com.pismery.study.dao.PersonRepository;
import com.pismery.study.po.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RequiredService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    @Lazy
    private RequiredService self;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * The nested transaction
     * @param personNo the person id
     * @return the person ,if find nothing throw runtime exception.
     */
    @Transactional(readOnly = true
            , isolation = Isolation.READ_UNCOMMITTED
            , propagation = Propagation.REQUIRED)
    public Person findByNo(String personNo) {
        Optional<Person> person = personRepository.findByPersonNo(personNo);
        if (person.isPresent())
            return person.get();
        else
            throw new RuntimeException();
    }


    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.REQUIRED)
    public void uploadWithTransaction(String personNo, String name) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);
    }

    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.REQUIRED)
    public void uploadWithException(String personNo, String name, String noExistNo) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);

        try {
            self.findByNo(noExistNo);
        } catch (RuntimeException e) {

        }
    }

    public void uploadNoTransaction(String personNo, String name) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);
    }


    public void uploadWithDefaultMethod(String personNo, String name, String noExistNo) {
        self.defaultMethod(personNo,name,noExistNo);
    }

    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.REQUIRED
            ,rollbackFor = Exception.class
    )
    public void defaultMethod(String personNo, String name, String noExistNo) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);

        findByNo(noExistNo);
    }

    /**
     * For rollback test.
     */
    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.REQUIRED)
    public void deleteAll() {
        personRepository.deleteAll();
    }


    /**
     * For init Database
     * @param personList given data
     */
    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.REQUIRED)
    public void saveAll(List<Person> personList) {
        personRepository.saveAll(personList);
    }


    /**
     * For After test check the result
     */
    @Transactional(readOnly = true
            , isolation = Isolation.READ_UNCOMMITTED
            , propagation = Propagation.REQUIRED)
    public void findAll() {
        List<Person> personList = personRepository.findAll();
        if (personList.isEmpty())
            log.debug("personList[] is empty");
        personList.forEach(person -> log.debug(person.toString()));
    }

}
