# Assignment: Library Loans REST API with Spring Boot, JPA, and H2

## Objective

Build a Spring Boot REST API to manage books, members, and loans. The API must support CRUD operations, allow members to borrow and return books, and retrieve the current number of active loans for each member. Persist data with JPA and an in-memory H2 database, and preload sample data at startup.

## Requirements

### 1. Entities

* **Book**: id, title, author, publicationYear, loans
* **Member**: id, name, membershipDate, loans
* **Loan**: id, loanDate, returnDate (nullable), member, book

### 2. Relationships

* Many-to-many between members and books (realized through **Loan**)
* One-to-many between members and loans
* One-to-many between books and loans

### 3. REST Endpoints

Implement endpoints for:

* CRUD operations for books and members
* List all books currently on loan to a member
* List all current borrowers of a book
* **Borrow a book** (create a loan with `returnDate = null`)
* **Return a book** (set `returnDate`)
* Get the **active-loan count** for a member

### 4. Data Initialization

* Create at least **3 members** and **3 books** at startup
* Insert loans so each member has borrowed books and each book has at least one loan
* Ensure active-loan and listing endpoints can be tested immediately

### 5. Database

* Use H2 in-memory database
* Enable the H2 console for debugging

### 6. JSON Serialization

* Prevent infinite recursion in JSON responses (e.g., `@JsonManagedReference` / `@JsonBackReference` or `@JsonIgnore`)

## Example Endpoints

* `GET /books` — List all books
* `GET /members/{memberId}/loans` — List books on loan to a member
* `POST /books/{bookId}/members/{memberId}/loans` — Borrow a book
* `PUT /loans/{loanId}/return` — Return a book (set `returnDate`)
* `GET /books/{bookId}/borrowers` — List current borrowers of a book
* `GET /members/{memberId}/active-loans` — Get active-loan count for a member
* CRUD endpoints for books and members

## Deliverables

* Complete Spring Boot project with code and configuration
* Data initialization logic (`CommandLineRunner` or similar)
* Example Postman collection or API documentation for testing

## Bonus

* Endpoint to list **loan history** (all past and present loans) for a member or a book
* Validation (e.g., prevent borrowing if a book is already out, require `returnDate` ≥ `loanDate`) and robust error handling

---

**Try to implement this assignment yourself!**

* Follow the requirements above as your guide.
* Test your API with Postman or curl.
* Explore the H2 console at `/h2-console` (default username: `sa`, empty password unless changed).
