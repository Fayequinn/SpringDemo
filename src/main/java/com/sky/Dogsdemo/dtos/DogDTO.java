package com.sky.Dogsdemo.dtos;

import com.sky.Dogsdemo.domain.Book;
import com.sky.Dogsdemo.domain.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogDTO {

    private Integer id;
    private String name;
    private String breed;

    private Integer age;

    private List<BookDTO> books;




    public DogDTO(Dog d){
        this.id = d.getId();
        this.name = d.getName();
        this.breed = d.getBreed();
        this.age = d.getAge();
        List<BookDTO> dtos = new ArrayList<>();
        for (Book b : d.getBooks())
            dtos.add(new BookDTO(b));
        this.books = dtos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public DogDTO(){
        super();


    }


}
