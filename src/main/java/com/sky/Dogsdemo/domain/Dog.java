package com.sky.Dogsdemo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    private String name;
    private String breed;

    private Integer age;

    //Bidirectional
    @OneToMany(mappedBy = "owner")
//    @JsonManagedReference
    private List<Book> books;




    public Dog(Integer Id, String name, String breed, int age){
        this.id = Id;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public Dog(String name, String breed, int age){
        super();
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public Dog(){
        super();
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed) && Objects.equals(age, dog.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, age);
    }
}
