package com.nido.urlshrinker.api.v1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController{

    @GetMapping("/")
    public String home(){
        return "URL Shrinker API is running \uD83D\uDE80";
    }
}