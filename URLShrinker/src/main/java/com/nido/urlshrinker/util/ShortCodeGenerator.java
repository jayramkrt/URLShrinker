package com.nido.urlshrinker.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShortCodeGenerator {

    public String generateCode(){
        return UUID.randomUUID().toString().substring(0,6);
    }
}
