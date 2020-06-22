package com.crud.json.repository;

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
    public PersonRepository() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream inputStream = new FileInputStream(new File("./src/main/resources/person.json"));
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
        return people;
    }
}
