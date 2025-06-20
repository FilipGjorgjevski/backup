# Assignment: Student Grades REST API with Spring Boot, JPA, and H2

## Objective
Build a Spring Boot REST API to manage students, courses, and grades. The API should support CRUD operations, allow enrolling students in courses, assigning grades, and retrieving the average grade for each course. Data should be persisted using JPA and an in-memory H2 database. Sample data must be initialized at startup.

## Requirements

### 1. Entities
- **Student**: id, name, enrolled courses, grades
- **Course**: id, name, enrolled students, grades
- **Grade**: id, grade value, student, course

### 2. Relationships
- Many-to-many between students and courses
- One-to-many between students and grades
- One-to-many between courses and grades

### 3. REST Endpoints
Implement endpoints for:
- CRUD operations for students and courses
- List students in a course
- Add/remove students to/from a course
- Add a grade for a student in a course
- Get the average grade for a course

### 4. Data Initialization
- Initialize at least 3 students and 3 courses at startup
- Enroll students in courses so that each course has students
- Assign some grades to students in courses so average grade endpoints can be tested immediately

### 5. Database
- Use H2 in-memory database
- Enable H2 console for debugging

### 6. JSON Serialization
- Prevent infinite recursion in JSON responses (e.g., with `@JsonIgnore`)

## Example Endpoints
- `GET /courses` — List all courses
- `GET /courses/{courseId}/students` — List students in a course
- `POST /courses/{courseId}/students` — Add student to a course
- `DELETE /courses/{courseId}/students/{studentId}` — Remove student from a course
- `POST /courses/{courseId}/students/{studentId}/grades` — Add grade for student in course
- `GET /courses/{courseId}/average-grade` — Get average grade for course
- CRUD endpoints for students and courses

## Deliverables
- Spring Boot project with all code and configuration
- Data initialization logic
- Example Postman collection or documentation for testing

## Bonus
- Add endpoints to list all grades for a student or course
- Add validation and error handling

---

**Try to implement this assignment yourself!**
- Use the requirements above as your guide.
- Test your API using Postman or curl.
- Explore the H2 console at `/h2-console` (default username: `sa`, and `password` as password).
