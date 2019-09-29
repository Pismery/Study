package com.pismery.study.dao;

import com.pismery.study.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByPersonNo(String personNo);


    @Query(
       value = "SELECT id,personNo,name " +
               "FROM Person " +
               "WHERE personNo = :personNo"

    )
    Optional<Person> findA(@Param("personNo") String personNo);
}
