package com.adlouniahmad.restspring.exceptions;

public class CityNotFoundException extends Exception {

    public CityNotFoundException(Long id) {
        super(String.format("City not found with id : %s", id));
    }
}
