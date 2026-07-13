package com.cognizant.SpringJPA.service.exception;

public class CountryNotFoundException extends Exception {

    public CountryNotFoundException() {
        super();
    }

    public CountryNotFoundException(String message) {
        super(message);
    }
}