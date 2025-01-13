package com.k.webscraper.exceptions;

public class NFNotFoundException extends RuntimeException {

    public NFNotFoundException(String code) {
        super("Unable to obtain invoice data by code " + code);
    }

}
