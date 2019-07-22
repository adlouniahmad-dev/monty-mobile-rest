package com.adlouniahmad.restspring.person;

import com.adlouniahmad.restspring.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findPersonById(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findByMobile(int mobile) throws PersonNotFoundException {
        Person person = personRepository.findByMobile(mobile);
        if (person != null)
            return person;
        throw new PersonNotFoundException();
    }


    @Override
    public List<Person> findAllByName(String name) {
        return personRepository.findAllByName(name);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person updatedPerson) throws PersonNotFoundException {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setAddress(updatedPerson.getAddress());
                    person.setMobile(updatedPerson.getMobile());
                    person.setNotes(updatedPerson.getNotes());
                    person.setCountry(updatedPerson.getCountry());
                    person.setCity(updatedPerson.getCity());
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public ResponseEntity deletePerson(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.delete(person);
        return ResponseEntity.ok().build();
    }
}
