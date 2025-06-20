# Postman API Testing Guide for Class10 Spring Boot Student Grades API

This document lists all REST endpoints and provides example requests and payloads for testing with Postman.

---

## 1. List All Courses
**GET** `/courses`

### Example Request
```
GET http://localhost:8081/courses
```

---

## 2. List Students in a Course
**GET** `/courses/{courseId}/students`

### Example Request
```
GET http://localhost:8081/courses/1/students
```

---

## 3. Add Student to a Course
**POST** `/courses/{courseId}/students`

### Example Request
```
POST http://localhost:8081/courses/1/students
Content-Type: application/json

{
  "studentId": 2
}
```

---

## 4. Remove Student from a Course
**DELETE** `/courses/{courseId}/students/{studentId}`

### Example Request
```
DELETE http://localhost:8081/courses/1/students/2
```

---

## 5. Add Grade for Student in Course
**POST** `/courses/{courseId}/students/{studentId}/grades`

### Example Request
```
POST http://localhost:8081/courses/1/students/2/grades
Content-Type: application/json

{
  "gradeValue": 5.5
}
```

---

## 6. Get Average Grade for a Course
**GET** `/courses/{courseId}/average-grade`

### Example Request
```
GET http://localhost:8081/courses/1/average-grade
```

---

## 7. CRUD for Students

### List All Students
```
GET http://localhost:8081/students
```

### Get Student by ID
```
GET http://localhost:8081/students/2
```

### Create Student
```
POST http://localhost:8081/students
Content-Type: application/json

{
  "name": "John Doe"
}
```

### Update Student
```
PUT http://localhost:8081/students/2
Content-Type: application/json

{
  "name": "Jane Doe"
}
```

### Delete Student
```
DELETE http://localhost:8081/students/2
```

---

## 8. CRUD for Courses (Admin)

### List All Courses
```
GET http://localhost:8081/courses-admin
```

### Get Course by ID
```
GET http://localhost:8081/courses-admin/1
```

### Create Course
```
POST http://localhost:8081/courses-admin
Content-Type: application/json

{
  "name": "Mathematics"
}
```

### Update Course
```
PUT http://localhost:8081/courses-admin/1
Content-Type: application/json

{
  "name": "Physics"
}
```

### Delete Course
```
DELETE http://localhost:8081/courses-admin/1
```

---

## Notes
- All endpoints return JSON.
- Use the correct IDs for students and courses as initialized or created.
- The server runs on port 8081 as configured.
