package com.adlouniahmad.restspring.person;

import com.adlouniahmad.restspring.exceptions.PersonNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(PersonController.BASE_URL)
public class PersonController {

    static final String BASE_URL = "/api/v1/persons";

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findPersonById(id);
    }

    @GetMapping("/search/n")
    public List<Person> getPersonsByName(@RequestParam String name) {
        return personService.findAllByName(name);
    }

    @GetMapping("/search/m")
    public Person getPersonsByMobile(@RequestParam int mobile) throws PersonNotFoundException {
        return personService.findByMobile(mobile);
    }

    @PostMapping
    public Person savePerson(@Valid @RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @Valid @RequestBody Person person) throws PersonNotFoundException {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id) throws PersonNotFoundException {
        return personService.deletePerson(id);
    }

}
