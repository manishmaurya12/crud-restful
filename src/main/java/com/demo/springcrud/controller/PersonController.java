package com.demo.springcrud.controller;

import com.demo.springcrud.model.Person;
import com.demo.springcrud.model.PersonResponse;
import com.demo.springcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(path = "/persons")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.addperson(person);
        return new ResponseEntity(personResponse,HttpStatus.OK);
    }

    @GetMapping(path = "/persons/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> allBooks() {
        List<Person> book = personService.allPersons();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}

