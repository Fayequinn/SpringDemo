package com.sky.Dogsdemo.rest;

import com.sky.Dogsdemo.domain.Dog;
import com.sky.Dogsdemo.dtos.DogDTO;
import com.sky.Dogsdemo.services.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {
    private DogService service;

    private DogController(DogService service){
        this.service=service;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

    // 'maps' the method to a POST request at /create
    // this dog will be passed in via the request body
    @PostMapping("/create")
    public ResponseEntity<Dog> createDog(@RequestBody Dog d) {
        Dog created = this.service.createDog(d);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public Dog getDog(@PathVariable int id) {
        return this.service.getDog(id);
    }

    @GetMapping("get/name/{name}")
    public Dog getByName(@PathVariable String name){
        return this.service.findDogByName(name);
    }


    @GetMapping("/getAll")
    public List<DogDTO> getDogs() {
        return this.service.getDogs();
    }

    @PatchMapping("/update/{id}")
    public Dog updateDog(
            @PathVariable int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "breed", required = false) String breed,
            @RequestParam(name = "age", required = false) Integer age) {
        return this.service.updateDog(id, name, breed, age);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeDog(@PathVariable int id) {
        String result = this.service.removeDog(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);
    }


}
