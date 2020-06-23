package com.crud.json.repository;


import com.crud.json.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository {
    List<Person> findAll();

    Person get(Integer id);

    void save(Person person);

    void removePerson(Integer id);
}
