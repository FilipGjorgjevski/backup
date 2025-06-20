package jpa.service;

import jpa.entity.Book;
import jpa.entity.Bookstore;
import jpa.repostiory.BookRepository;
import jpa.repostiory.BookstoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner dataInitialize(BookRepository bookRepository, BookstoreRepository bookstoreRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String[] args) {
                List<Bookstore> savedBookStore = bookstoreRepository.saveAll(
                        List.of(
                        new Bookstore("Knizarnica TRI", "Partizanski odredi 5"),
                        new Bookstore("Prosvetno Delo", "Ruzveltova 45"),
                        new Bookstore("Trimaks", "Karposova 23")
                        )
                );

                List<Book> savedBooks = bookRepository.saveAll(
                        List.of(
                        new Book("Zoki Poki", "Olivera Nikolovska", savedBookStore.get(0)),
                        new Book("Papokot na svetot", "Venko Andonovski", savedBookStore.get(1)),
                        new Book("1984", "George Orwell", savedBookStore.get(0)),
                        new Book("Thus Spoke Zarathustra", "Friedrich Nietzsche", savedBookStore.get(1))
                        )
                );

                savedBookStore.get(0).getBooks().add(savedBooks.get(0));
                savedBookStore.get(0).getBooks().add(savedBooks.get(2));
                savedBookStore.get(1).getBooks().add(savedBooks.get(1));
                savedBookStore.get(1).getBooks().add(savedBooks.get(3));

                bookstoreRepository.saveAll(savedBookStore);
            }
        };
    }
}
