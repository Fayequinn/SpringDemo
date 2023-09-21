//package com.sky.Dogsdemo.services;
//
//import com.sky.Dogsdemo.domain.Dog;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DogServiceList implements DogService {
//    private List<Dog> dogs = new ArrayList<>();
//
//
//    @Override
//    public Dog createDog(Dog d) {
//        dogs.add(d);
//        Dog created = this.dogs.get(this.dogs.size() - 1);
//        return created;
//    }
//
//
//    public Dog getDog(int id) {
//        return dogs.get(id);
//    }
//
//    public List<Dog> getDogs() {
//        return dogs;
//    }
//
//
//    public Dog updateDog(int id, String name, String breed, Integer age) {
//        dogs.get(id).setName(name);
//        dogs.get(id).setBreed(breed);
//        dogs.get(id).setAge(age);
//        return dogs.get(id);
//    }
//
//    public String removeDog(int id) {
//        if (id >= this.dogs.size()) return "NOT FOUND";
//        else {
//            String removedName = dogs.get(id).getName();
//            dogs.remove(id);
//            return "You removed " + removedName;
//        }
//    }
//
//    public Dog findDogByName(String name){
//        return null;
//    }
//}
//
