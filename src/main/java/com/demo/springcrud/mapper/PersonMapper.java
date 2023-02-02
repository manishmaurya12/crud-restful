package com.demo.springcrud.mapper;

import com.demo.springcrud.enttity.PersonEntity;
import com.demo.springcrud.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity modelToEntity (Person person);
    Person entityToModel (PersonEntity personEntity);
    List<Person> entityToList (List<PersonEntity> all);

}
