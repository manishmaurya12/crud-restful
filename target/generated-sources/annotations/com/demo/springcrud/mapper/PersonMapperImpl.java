package com.demo.springcrud.mapper;

import com.demo.springcrud.enttity.PersonEntity;
import com.demo.springcrud.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T14:21:44+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
*/
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity modelToEntity(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirstName( person.getFirstName() );
        personEntity.setLastName( person.getLastName() );

        return personEntity;
    }

    @Override
    public Person entityToModel(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        Person person = new Person();

        person.setFirstName( personEntity.getFirstName() );
        person.setLastName( personEntity.getLastName() );

        return person;
    }

    @Override
    public List<Person> entityToList(List<PersonEntity> all) {
        if ( all == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( all.size() );
        for ( PersonEntity personEntity : all ) {
            list.add( entityToModel( personEntity ) );
        }

        return list;
    }
}
