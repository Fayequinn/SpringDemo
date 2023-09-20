package com.sky.Dogsdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    private String name;
    private String breed;

    private Integer age;

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

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
}
