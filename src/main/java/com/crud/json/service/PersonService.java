package com.crud.json.service;

import com.crud.json.model.Person;
import com.crud.json.repository.IPersonRepository;
import com.crud.json.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository repo = new PersonRepository();

    public List<Person> listAll() {
        return repo.findAll();
    }
}
