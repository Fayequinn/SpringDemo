package com.sky.Dogsdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @GetMapping("/hello")
    public String test(){
        return "Hello, World!";
    }

}
