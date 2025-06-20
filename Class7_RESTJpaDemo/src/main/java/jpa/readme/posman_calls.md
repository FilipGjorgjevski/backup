Lecture 10: api calls postman

1. [GET] getBookstoreByBookId: http://localhost:8080/api/bookstores/byBookId/1

2. [GET] getBookStoreByBooksName: http://localhost:8080/api/bookstores/byBookName/Zoki Poki

3. [GET] getAllBookStores: http://localhost:8080/api/bookstores

4. [GET] getBookStoreById: http://localhost:8080/api/bookstores/2

5. [POST] createBookStore:
   url: http://localhost:8080/api/bookstores/addBook 
    {
   "name": "Jason Sweet",
   "address": "address",
   "books": []
   }

6. [PUT] updateBookStore:
   url: http://localhost:8080/api/bookstores/2
   {
   "name": "New name",
   "address": "new address",
   "books": []
   }

7. [DELETE] deleteBookStore:
   url: http://localhost:8080/api/bookstores/3

8. [POST] addBookToBookStore
   url: http://localhost:8080/api/bookstores/1/books
   {
   "name": "New name",
   "author": "new address"
   }

9. [POST] addExistingBookToBookStore
   url: http://localhost:8080/api/bookstores/2/1/books

10. [DELETE] removeBookFromBookStore
    url: http://localhost:8080/api/bookstores/1/books/3