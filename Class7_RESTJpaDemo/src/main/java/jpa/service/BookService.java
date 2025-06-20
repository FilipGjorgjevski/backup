package jpa.service;

import jpa.entity.Book;
import jpa.repostiory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBookById(Long id){
       return bookRepository.findById(id);
    }

}
