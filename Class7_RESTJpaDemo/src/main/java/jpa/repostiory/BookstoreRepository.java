package jpa.repostiory;

import jpa.entity.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {

    //Optional because the query may not find a matching Bookstore entity for the given name and address.
    //You can use concatenation without the underscore, like findByBooksId(Long bookId).
    //Spring Data JPA supports both findByBooks_Id and findByBooksId as long as the property path matches your entity structure.
    //Both forms are valid and will work the same way.
    public Optional<Bookstore> findByNameAndAddress(String name, String address);
    public Optional<Bookstore> findByBooks_Id(Long bookId);
    public Optional<Bookstore> findByBooks_Name(String name);

}
