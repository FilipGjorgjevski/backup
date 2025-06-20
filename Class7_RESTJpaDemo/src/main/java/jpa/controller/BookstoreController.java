package jpa.controller;

import jpa.entity.Book;
import jpa.entity.Bookstore;
import jpa.repostiory.BookstoreRepository;
import jpa.service.BookService;
import jpa.service.BookstoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookstores")
public class BookstoreController {

    private Logger logger = LoggerFactory.getLogger(BookstoreController.class);

    @Autowired
    BookService bookService;

    @Autowired
    private BookstoreService bookstoreService;

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @GetMapping
    public List<Bookstore> getAllBookstores(){
       return bookstoreService.getAllBookstores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookstore> getBookStoreById(@PathVariable Long id) {
        Optional<Bookstore> bookStore = bookstoreService.getBookstoreById(id);
        return bookStore.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/addBook")
    public Bookstore createBookstore(@RequestBody Bookstore bookstore){
        return bookstoreService.createBookstore(bookstore);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Bookstore> updateBookStore(@PathVariable Long id, @RequestBody Bookstore bookStore) {
        try {
            return ResponseEntity.ok(bookstoreService.updateBookstore(id, bookStore));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookStore(@PathVariable Long id) {
        bookstoreService.deleteBookstore(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{bookStoreId}/books")
    public ResponseEntity<Bookstore> addBookToBookStore(@PathVariable Long bookStoreId, @RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookstoreService.addBookToBookstore(bookStoreId, book));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value="/{bookStoreId}/{bookId}/books")
    public ResponseEntity<Bookstore> addExistingBookToBookStore(@PathVariable Long bookStoreId, @PathVariable Long bookId) {
        try {
            Book book = bookService.getBookById(bookId).get();
            return ResponseEntity.ok(bookstoreService.addBookToBookstore(bookStoreId, book));

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{bookStoreId}/books/{bookId}")
    public ResponseEntity<Void> removeBookFromBookStore(@PathVariable Long bookStoreId, @PathVariable Long bookId) {
        bookstoreService.deleteBookFromBookstore(bookStoreId, bookId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/byBookId/{id}")
    public Optional<Bookstore> getBookstoreByBookId(@PathVariable Long id) {
        logger.info("Get book store by book id");
        return bookstoreService.getBookstoreByBookId(id);
    }


    @GetMapping("/byBookName/{name}")
    public Optional<Bookstore> getBookStoreByBooksName(@PathVariable String name) {
        logger.info("Get book store by book name");
        return bookstoreService.getBookstoreByBooksName(name);
    }

    @GetMapping("/byNameAndAddress/{name}/{address}")
    public Optional<Bookstore> getBookStoreByNameAndAddress(@PathVariable String name, @PathVariable String address) {
        logger.info("Get book store by name and address");
        return bookstoreService.getBookstoreByNameAndAddress(name, address);
    }

}
