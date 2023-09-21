package com.sky.Dogsdemo.services;

import com.sky.Dogsdemo.domain.Book;
import com.sky.Dogsdemo.dtos.BookDTO;
import com.sky.Dogsdemo.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<BookDTO> getBooks(){
        List<BookDTO> dtos = new ArrayList<>();
        for (Book b : repo.findAll())
            dtos.add(new BookDTO(b));
        return dtos;
    }
}
