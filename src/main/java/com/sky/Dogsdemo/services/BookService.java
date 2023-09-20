package com.sky.Dogsdemo.services;

import com.sky.Dogsdemo.domain.Book;
import com.sky.Dogsdemo.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepo repo;

    public BookService(BookRepo repo){
        this.repo = repo;
    }

    public Book createBook(Book b){
        return this.repo.save(b);
    }

    public List<Book> getBooks(){
        return this.repo.findAll();
    }
}
