package com.crud.json.repository;

import com.crud.json.exception.PersonException;
import com.crud.json.model.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository{
    private List<Person> people;
    private InputStream inputStream;
    private ObjectMapper mapper;
    public PersonRepository() {

    }

    public void loadData(){
        mapper = new ObjectMapper();

        try {
            inputStream = new FileInputStream(new File("./src/main/resources/person.json"));
            TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>(){};
            people = mapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        loadData();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    private void closeData() {

    }

    @Override
    public Person get(Integer id) {loadData();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Person p: people) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void save(Person person) {
        removePerson(person.getId());
        people.add(person);
        writeData();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removePerson(int id) {
        loadData();
        for (Person p: people){
            if (p.getId()==id){
                people.remove(p);
            }
        }
        writeData();
    }

    private void writeData() {
        try {
            mapper.writeValue(new File("./src/main/resources/person.json"),people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
