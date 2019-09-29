package com.pismery.study.service;

import com.pismery.study.dao.PersonRepository;
import com.pismery.study.po.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class NestedService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private NestedService self;

    /**
     * The nested transaction
     * @param personNo the person id
     * @return the person ,if find nothing throw runtime exception.
     */
    @Transactional(readOnly = true
            , isolation = Isolation.READ_UNCOMMITTED
            , propagation = Propagation.NESTED)
    public Person findByNo(String personNo) {
        return personRepository.findByPersonNo(personNo).orElseThrow(() -> {
            log.debug("throw runtime exception");
            return new RuntimeException();
        });
    }


    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.NESTED)
    public void uploadWithTransaction(String personNo, String name) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);
    }

    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.NESTED)
    public void uploadWithException(String personNo, String name, String noExistNo) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);

        self.findByNo(noExistNo);
    }

    public void uploadNoTransaction(String personNo, String name) {
        Person person = self.findByNo(personNo);
        person.setName(name);
        personRepository.save(person);

    }


    /**
     * For rollback test.
     */
    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.NESTED)
    public void deleteAll() {
        personRepository.deleteAll();
    }


    /**
     * For init Database
     * @param personList given data
     */
    @Transactional(readOnly = false
            , isolation = Isolation.READ_COMMITTED
            , propagation = Propagation.NESTED)
    public void saveAll(List<Person> personList) {
        personRepository.saveAll(personList);
    }


    /**
     * For After test check the result
     */
    @Transactional(readOnly = true
            , isolation = Isolation.READ_UNCOMMITTED
            , propagation = Propagation.NESTED)
    public void findAll() {
        List<Person> personList = personRepository.findAll();
        if (personList.isEmpty())
            log.debug("personList[] is empty");
        personList.forEach(person -> log.debug(person.toString()));
    }

}
