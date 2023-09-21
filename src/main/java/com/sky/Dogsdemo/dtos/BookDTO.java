package com.sky.Dogsdemo.dtos;

import com.sky.Dogsdemo.domain.Book;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BookDTO {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String author;

    private Integer ownerId;

    public BookDTO(Book b){
        this.id = b.getId();
        this.title=b.getTitle();
        this.author=b.getAuthor();
        if (b.getOwner() != null)
            this.ownerId = b.getOwner().getId();
    }

    public BookDTO(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
