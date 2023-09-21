package com.sky.Dogsdemo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.Dogsdemo.domain.Dog;
import com.sky.Dogsdemo.dtos.DogDTO;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:dog-schema.sql", "classpath:dog-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DogIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {

        Dog testDog = new Dog("Darcey", "English Setter", 5);
        String reqBody = this.mapper.writeValueAsString(testDog);

        System.out.println("DOG: " + testDog);
        System.out.println("JSON: " + reqBody);

        RequestBuilder req = post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        testDog.setId(2);

        String resBody = this.mapper.writeValueAsString(testDog);

        System.out.println("SAVED DOG" + testDog);
        System.out.println("RES JSON" + resBody);

        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

    }
//@Test
//        void testCreate2() throws Exception{
//
//            Dog testDog = new Dog("Darcey", "English Setter", 5);
//            String reqBody = this.mapper.writeValueAsString(testDog);
//
//            System.out.println("DOG: " +testDog);
//            System.out.println("JSON: "+ reqBody);
//
//            RequestBuilder req = post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON);
//
//            ResultMatcher checkStatus = status().isCreated();
//            testDog.setId(2);
//
//            String resBody = this.mapper.writeValueAsString(testDog);
//
//            System.out.println("SAVED DOG" +testDog);
//            System.out.println("RES JSON" +resBody);
//
//            ResultMatcher checkBody = content().json(resBody);
//
//            mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//
//    }

    @Test
    void testRead() throws Exception{
        String resBody = this.mapper.writeValueAsString(new Dog(1, "Enzo", "Jack Russell", 3));
        this.mvc.perform(MockMvcRequestBuilders.get("/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testReadAll() throws Exception{
//        List <Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog(1, "Enzo", "Jack Russell", 3));
//  could use this above and then do
//  String resBody=this.mapper.writeValueAsString(dogs);

        String resBody = this.mapper.writeValueAsString(List.of(new Dog(1, "Enzo", "Jack Russell", 3)));
        this.mvc.perform(MockMvcRequestBuilders.get("/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testUpdate() throws Exception{
        Dog testUpdateDog = new Dog("Charlie", "JackRussell", 14);
        String reqBody = this.mapper.writeValueAsString(testUpdateDog);

        RequestBuilder req = patch("/update/1?name=Charlie&breed=JackRussell&age=14").content(reqBody).contentType(MediaType.APPLICATION_JSON);
        ResultMatcher checkStatus = status().isOk();
testUpdateDog.setId(1);
        String resBody = this.mapper.writeValueAsString(testUpdateDog);

        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testRemove() throws Exception{
        String resBody = this.mapper.writeValueAsString(new Dog(1, "Enzo", "Jack Russell", 3));
        this.mvc.perform(MockMvcRequestBuilders.delete("/remove/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
