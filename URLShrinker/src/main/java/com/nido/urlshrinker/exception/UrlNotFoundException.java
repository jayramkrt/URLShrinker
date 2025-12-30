package com.nido.urlshrinker.exception;

import org.springframework.http.HttpStatus;

public class UrlNotFoundException extends ApiException {

    public UrlNotFoundException(String shortCode){
        super(HttpStatus.NOT_FOUND, "URL not found for short code : "+shortCode);
    }
}
