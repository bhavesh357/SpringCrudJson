package com.crud.json.controller;


import com.crud.json.model.Person;
import com.crud.json.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/all")
    public List<Person> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Integer id) {
        try {
            Person person = service.get(id);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Person person) {
        service.save(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Person person, @PathVariable Integer id) {
        try {
            Person existPerson = service.get(id);
            person.setId(id);
            service.save(person);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
