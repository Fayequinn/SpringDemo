package com.sky.Dogsdemo.services;

import com.sky.Dogsdemo.domain.Dog;
import com.sky.Dogsdemo.dtos.DogDTO;

import java.util.List;

public interface DogService {

   Dog createDog(Dog d);

    Dog getDog(int id);

    List<DogDTO> getDogs();

    Dog updateDog(int id, String name, String breed, Integer age);

String removeDog(int id);

Dog findDogByName(String name);
}
