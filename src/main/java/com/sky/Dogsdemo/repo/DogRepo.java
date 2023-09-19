package com.sky.Dogsdemo.repo;

import com.sky.Dogsdemo.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepo extends JpaRepository<Dog, Integer> {

    Dog findByNameIgnoreCase(String name);
}
