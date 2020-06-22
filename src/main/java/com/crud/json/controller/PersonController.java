package com.crud.json.controller;


import com.crud.json.model.Person;
import com.crud.json.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("")
    public List<Person> list() {
        return service.listAll();
    }

}
