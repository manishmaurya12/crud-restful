package com.demo.springcrud.service;

import com.demo.springcrud.enttity.PersonEntity;
import com.demo.springcrud.mapper.PersonMapper;
import com.demo.springcrud.model.Person;
import com.demo.springcrud.model.PersonResponse;
import com.demo.springcrud.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;

    public PersonResponse addperson(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        log.info("Person is Added");
        return personResponse;
    }

    public Person getPersonById(Long id) {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        Person person = new Person();
        if (optionalPersonEntity.isPresent()) {
            PersonEntity personEntity = optionalPersonEntity.get();
            person = personMapper.entityToModel(personEntity);
            log.info("Person found with id {}", id);
        } else {
            log.info("Person id", id + "not found");
        }
        return person;

    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
        log.info("Person id {} ", id + "deleted successfully");

    }

    public List<Person> allPersons() {
        List<Person> persons = personMapper.entityToList(personRepository.findAll());
        return persons;
    }
}
