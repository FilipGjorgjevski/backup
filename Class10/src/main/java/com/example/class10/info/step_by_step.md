# Step-by-Step Guide: Building a Student Grades REST API with Spring Boot

This guide will help you implement the assignment step by step. Follow each step in order, and use it as a checklist or TODO for your project.

---

## 1. Set Up the Spring Boot Project
- Use [Spring Initializr](https://start.spring.io/) or your IDE to create a new Spring Boot project.
- Add dependencies: `Spring Web`, `Spring Data JPA`, and `H2 Database`.
- Set Java version to 17 or higher.

## 2. Define the Entity Classes
- Create a `model` package.
- Implement the following entities as Java classes annotated with `@Entity`:
  - **Student**: fields for id, name, courses, grades.
  - **Course**: fields for id, name, students, grades.
  - **Grade**: fields for id, grade value, student, course.
- Set up relationships:
  - Many-to-many between students and courses.
  - One-to-many between students and grades.
  - One-to-many between courses and grades.
- Use `@JsonIgnore` on fields that would cause infinite recursion in JSON responses.

## 3. Create Repository Interfaces
- Create a `repository` package.
- For each entity, create a repository interface extending `JpaRepository`:
  - `StudentRepository`
  - `CourseRepository`
  - `GradeRepository` (add custom queries if needed)

## 4. Implement Service Classes
- Create a `service` package.
- Implement service classes to handle business logic:
  - `StudentService`: CRUD for students, enroll/remove students in courses, add grades, get students by course, calculate average grade.
  - `CourseService`: CRUD for courses.
- Inject repositories using `@Autowired`.

## 5. Create REST Controllers
- Create a `controller` package.
- Implement REST controllers for API endpoints:
  - `StudentController`: CRUD endpoints for students.
  - `CourseController`: endpoints for listing courses, enrolling/removing students, adding grades, getting average grade.
  - (Optional) `CourseAdminController`: CRUD endpoints for courses.
- Use `@RestController` and `@RequestMapping` annotations.
- Map endpoints as described in the assignment.

## 6. Configure the Application
- In `src/main/resources/application.properties`:
  - Set up H2 database connection.
  - Enable the H2 console (`spring.h2.console.enabled=true`).
  - Set JPA to auto-update schema (`spring.jpa.hibernate.ddl-auto=update`).
  - (Optional) Change the server port if needed.

## 7. Initialize Sample Data
- Create a `config` package.
- Add a `DataInitializer` class with a `CommandLineRunner` bean.
- In the initializer:
  - Create and save several students and courses.
  - Enroll students in courses (update both sides of the relationship).
  - Assign some grades to students in courses.
  - Save all entities to the database.

## 8. Test the API
- Use Postman or curl to test all endpoints:
  - List courses and students.
  - Enroll/remove students in courses.
  - Add grades and get average grades.
  - Perform CRUD operations for students and courses.
- Use the H2 console at `/h2-console` to inspect the database.

## 9. (Bonus) Add More Features
- Add endpoints to list all grades for a student or course.
- Add validation and error handling (e.g., for missing entities).
- Write unit or integration tests.

---

**Tip:**
- Work incrementally: test each part as you build it.
- Read error messages carefully—they often tell you exactly what’s wrong.
- Use the official Spring Boot documentation for reference.

Good luck!
