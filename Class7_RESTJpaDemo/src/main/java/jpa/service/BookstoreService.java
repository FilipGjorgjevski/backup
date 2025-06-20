package jpa.service;

import jpa.entity.Book;
import jpa.entity.Bookstore;
import jpa.repostiory.BookRepository;
import jpa.repostiory.BookstoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookstoreService {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Bookstore> getAllBookstores(){
       return bookstoreRepository.findAll();
    }

    public Optional<Bookstore> getBookstoreById(Long bookstoreId){
        return bookstoreRepository.findById(bookstoreId);
    }

    public Bookstore createBookstore(Bookstore bookstore){
        return bookstoreRepository.save(bookstore);
    }

    public Bookstore updateBookstore(Long bookstoreId, Bookstore bookstoreDetails){
        return bookstoreRepository.findById(bookstoreId).map(bookstore -> {
            bookstore.setName(bookstoreDetails.getName());
            bookstore.setAddress(bookstoreDetails.getAddress());
            return bookstoreRepository.save(bookstore);
        }).orElseThrow(()-> new RuntimeException("Bookstore not found"));
    }

    public void deleteBookstore(Long id){
        bookstoreRepository.deleteById(id);
    }

    public Bookstore addBookToBookstore(Long bookstoreId, Book book){
        return bookstoreRepository.findById(bookstoreId).map(bookstore -> {
            bookstore.getBooks().add(book);
            book.setBookstore(bookstore);
            bookRepository.save(book);
           return bookstoreRepository.save(bookstore);
        }).orElseThrow(()-> new RuntimeException("Bookstore not found"));
    }

    public void deleteBookFromBookstore(Long bookstoreId, Long bookId){
        bookstoreRepository.findById(bookstoreId).ifPresent(bookstore -> {
            Book foundBook = bookRepository.findById(bookId).get();
            bookstore.getBooks().remove(foundBook);
            bookstoreRepository.save(bookstore);
            bookRepository.deleteById(bookId);
        });
    }

    public Optional<Bookstore> getBookstoreByBookId(Long bookId) {
        return bookstoreRepository.findByBooks_Id(bookId);
    }

    public Optional<Bookstore> getBookstoreByBooksName(String bookName) {
        return bookstoreRepository.findByBooks_Name(bookName);
    }

    public Optional<Bookstore> getBookstoreByNameAndAddress(String name, String address) {
        return bookstoreRepository.findByNameAndAddress(name, address);
    }


}
