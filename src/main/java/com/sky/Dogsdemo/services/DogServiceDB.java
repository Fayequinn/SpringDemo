package com.sky.Dogsdemo.services;

import com.sky.Dogsdemo.domain.Dog;
import com.sky.Dogsdemo.dtos.DogDTO;
import com.sky.Dogsdemo.repo.DogRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DogServiceDB implements DogService{

    private DogRepo repo;

    public DogServiceDB(DogRepo repo){
        this.repo = repo;
    }

    @Override
    public Dog createDog(Dog d) {
        return this.repo.save(d);
    }

    @Override
    public Dog getDog(int id) {
        Optional<Dog> found = this.repo.findById(id);
        return found.get();
    }

    public Dog findDogByName(String name){
        return this.repo.findByNameIgnoreCase(name);
    }

    @Override
    public List<DogDTO> getDogs() {
        List<DogDTO> dtos = new ArrayList<>();

        for (Dog d : this.repo.findAll())
            dtos.add(new DogDTO(d));
        return dtos;
    }

    @Override
    public Dog updateDog(int id, String name, String breed, Integer age) {
        Dog toUpdate = this.getDog(id);
        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (breed != null) toUpdate.setBreed(breed);
        return this.repo.save(toUpdate);
    }

    @Override
    public String removeDog(int id) {
        if (this.repo.existsById(id)){
            String removedName = repo.findById(id).get().getName();
            this.repo.deleteById(id);
            return "You removed " + removedName;
        } else{
        return "NOT FOUND";}
    }
}
