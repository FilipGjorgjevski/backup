# Assignment: Product Reviews REST API with Spring Boot, JPA, and H2

## Objective

Build a Spring Boot REST API to manage customers, products, and reviews. The API should support CRUD operations, allow customers to review products, and retrieve the average rating for each product. Data must be persisted with JPA and an in-memory H2 database, and sample data should be initialized at startup.

## Requirements

### 1. Entities

* **Customer**: id, name, reviewed products, reviews
* **Product**: id, name, description, reviewers, reviews
* **Review**: id, rating (1-5), comment, customer, product

### 2. Relationships

* Many-to-many between customers and products (via reviews)
* One-to-many between customers and reviews
* One-to-many between products and reviews

### 3. REST Endpoints

Implement endpoints for:

* CRUD operations for customers and products
* List reviews for a product
* Add a review (rating + optional comment) for a product by a customer
* Delete a review
* Get the average rating for a product

### 4. Data Initialization

* Create at least **3 customers** and **3 products** at startup
* Add reviews so every product has ratings from multiple customers
* Ensure average-rating endpoints are testable immediately

### 5. Database

* Use H2 in-memory database
* Enable the H2 console for debugging

### 6. JSON Serialization

* Prevent infinite recursion in JSON responses (e.g., with `@JsonIgnore` or `@JsonManagedReference` / `@JsonBackReference`)

## Example Endpoints

* `GET /products` — List all products
* `GET /products/{productId}/reviews` — List reviews for a product
* `POST /products/{productId}/customers/{customerId}/reviews` — Add review for a product
* `DELETE /products/{productId}/reviews/{reviewId}` — Delete a review
* `GET /products/{productId}/average-rating` — Get average rating for a product
* CRUD endpoints for customers and products

## Deliverables

* Complete Spring Boot project with code and configuration
* Data initialization logic (`CommandLineRunner` or similar)
* Example Postman collection or API documentation for testing

## Bonus

* Endpoints to list all reviews by a customer
* Validation (e.g., rating must be 1-5) and custom error handling

---

**Try to implement this assignment yourself!**

* Use the requirements above as your guide.
* Test your API with Postman or curl.
* Explore the H2 console at `/h2-console` (default username: `sa`, empty password unless changed).
