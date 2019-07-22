package com.adlouniahmad.restspring.exceptions;

public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(Long id) {
        super(String.format("Country not found with id : %s", id));
    }

}
