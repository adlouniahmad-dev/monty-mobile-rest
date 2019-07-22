package com.adlouniahmad.restspring.person;

import com.adlouniahmad.restspring.exceptions.PersonNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    Person findPersonById(Long id) throws PersonNotFoundException;

    List<Person> findAllPersons();

    Person findByMobile(int mobile) throws PersonNotFoundException;

    List<Person> findAllByName(String name);

    Person savePerson(Person person);

    Person updatePerson(Long id, Person person) throws PersonNotFoundException;

    ResponseEntity deletePerson(Long id) throws PersonNotFoundException;
}
