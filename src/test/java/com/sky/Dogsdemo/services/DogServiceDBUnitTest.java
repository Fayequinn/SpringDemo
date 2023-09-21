package com.sky.Dogsdemo.services;


import com.sky.Dogsdemo.domain.Dog;
import com.sky.Dogsdemo.repo.DogRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class DogServiceDBUnitTest {

    @Autowired
    private DogService service;

    @MockBean
    private DogRepo repo;

    @Test
    void testUpdate(){
        Integer id = 24;

        Optional<Dog> found = Optional.of(new Dog(id, "Frankie", "Boxer", 7));
        Dog updated = new Dog(id, "Rocko", "Boxer", 3);

        Mockito.when(this.repo.findById(id)).thenReturn(found);
        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        Assertions.assertEquals(updated, this.service.updateDog(id, "Rocko", "Boxer", 3));


    }

}
