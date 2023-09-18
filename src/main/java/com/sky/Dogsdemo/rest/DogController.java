package com.sky.Dogsdemo.rest;

import com.sky.Dogsdemo.domain.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    private List<Dog> dogs = new ArrayList<>();

    @GetMapping("/hello")
    public String test(){
        return "Hello, World!";
    }

    // 'maps' the method to a POST request at /create
    // this dog will be passed in via the request body
    @PostMapping("/create")
    public ResponseEntity<Dog> createDog(@RequestBody Dog d){
        dogs.add(d);
        Dog created = this.dogs.get(this.dogs.size()-1);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public Dog getDog(@PathVariable int id){
        return dogs.get(id);
    }

    @GetMapping("/getAll")
    public List<Dog> getDog(){
        return dogs;
    }

    @PatchMapping("/update/{id}")
    public Dog updateDog(
            @PathVariable int id,
            @RequestParam(name = "name", required = false) String name,
             @RequestParam(name = "breed", required = false) String breed,
            @RequestParam(name = "age", required = false) Integer age){
        dogs.get(id).setName(name);
        dogs.get(id).setBreed(breed);
        dogs.get(id).setAge(age);
        return dogs.get(id);
    }

@DeleteMapping("/remove/{id}")
    public String removeDog(@PathVariable int id){
        String removedName = dogs.get(id).getName();
        dogs.remove(id);
        return "You removed "+ removedName;
}


}
