package com.crud.json.service;

import com.crud.json.exception.PersonException;
import com.crud.json.model.Person;
import com.crud.json.repository.IPersonRepository;
import com.crud.json.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private IPersonRepository repo = new PersonRepository();

    public List<Person> listAll() {
        return repo.findAll();
    }

    public Person get(Integer id) {
        Person person = repo.get(id);
        if (person==null){
            throw new PersonException(PersonException.ErrorType.NOT_FOUND);
        }
        return person;
    }

    public void save(Person person) {
        repo.save(person);
    }

    public void delete(Integer id) {
        repo.removePerson(id);
    }
}
