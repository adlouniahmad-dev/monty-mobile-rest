package com.adlouniahmad.restspring.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Person not found");
    }

    public PersonNotFoundException(Long personId) {
        super(String.format("Person not found with id : %s", personId));
    }
}
