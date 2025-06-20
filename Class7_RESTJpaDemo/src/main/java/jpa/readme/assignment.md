# Spring Boot Bookstore API Development Assignment

## Overview

This assignment focuses on developing a RESTful API for a bookstore management system using Spring Boot, Spring Data JPA, and H2 Database. You will learn how to implement a complete end-to-end application with proper layering and RESTful principles.

## Learning Objectives

By completing this assignment, you will:

1. Understand the fundamentals of building RESTful APIs with Spring Boot
2. Learn Spring Data JPA for database interactions without writing SQL queries
3. Apply proper layering (Controller, Service, Repository) in a Spring Boot application
4. Implement entity relationships (One-to-Many) between domain models
5. Practice handling HTTP request methods (GET, POST, PUT, DELETE)
6. Gain experience with data initialization and in-memory databases

## Assignment Description

You will build a Bookstore Management System that allows users to:

1. View all bookstores
2. Find bookstores by ID
3. Create, update, and delete bookstores
4. Add books to bookstores
5. Remove books from bookstores
6. Search for bookstores by various criteria (book ID, book name, bookstore name and address)

The system consists of two main entities:
- **Bookstore**: Represents a physical bookstore with a name and address
- **Book**: Represents a book with a title and author, associated with a bookstore

## Technical Requirements

1. **Project Structure**:
    - Create a Spring Boot application with proper package organization
    - Follow the MVC pattern with clear separation of concerns

2. **Data Model**:
    - Implement Bookstore and Book entities with appropriate relationships
    - Configure JPA annotations correctly

3. **API Endpoints**:
    - Implement RESTful endpoints for all required operations
    - Use appropriate HTTP methods and status codes
    - Handle error cases properly

4. **Database**:
    - Use H2 in-memory database for development
    - Implement proper repository interfaces with Spring Data JPA
    - Initialize sample data for testing

5. **Testing**:
    - Test all API endpoints using a tool like Postman or cURL

## Implementation Details

The application should include:

1. **Entity Classes**:
    - `Bookstore`: With ID, name, address, and a list of books
    - `Book`: With ID, title, author, and a reference to its bookstore

2. **Repository Interfaces**:
    - `BookstoreRepository`: For basic CRUD operations on bookstores
    - `BookRepository`: For basic CRUD operations on books

3. **Service Classes**:
    - `BookstoreService`: For business logic related to bookstores
    - `BookService`: For business logic related to books

4. **Controller Classes**:
    - `BookstoreController`: For handling HTTP requests related to bookstores
    - `BookController`: For handling HTTP requests related to books

5. **Data Initializer**:
    - Code to populate the database with sample data on application startup

## API Endpoints to Implement

```
GET    /api/bookstores              - Get all bookstores
GET    /api/bookstores/{id}         - Get bookstore by ID
POST   /api/bookstores/addBook      - Create a new bookstore
PUT    /api/bookstores/{id}         - Update a bookstore
DELETE /api/bookstores/{id}         - Delete a bookstore
POST   /api/bookstores/{id}/books   - Add a book to a bookstore
DELETE /api/bookstores/{id}/books/{bookId} - Remove a book from a bookstore
GET    /api/bookstores/byBookId/{id} - Find bookstore by book ID
GET    /api/bookstores/byBookName/{name} - Find bookstore by book name
GET    /api/bookstores/byNameAndAddress/{name}/{address} - Find bookstore by name and address
```


## Deliverables

1. Complete source code of the Spring Boot application
3. H2 database configuration

## Getting Started

1. Generate a Spring Boot project using Spring Initializer with the following dependencies:
    - Spring Web
    - Spring Data JPA
    - H2 Database

2. Set up the H2 database configuration in application.properties

3. Implement the entity classes with appropriate JPA annotations

4. Create repository interfaces extending JpaRepository

5. Implement service classes with business logic

6. Create REST controllers to expose API endpoints

7. Initialize sample data for testing

8. Test all endpoints to ensure they work as expected

Good luck ;)