# Assignment: Workout Tracker REST API with Spring Boot, JPA, and H2

## Objective

Build a Spring Boot REST API to manage users, workout types, and workout logs. The API should support CRUD operations, let users log workouts, and provide the total calories burned by each user. Persist data with JPA and an in-memory H2 database, pre-loading sample data at startup.

## Requirements

### 1. Entities

* **User**: id, name, workout logs
* **Workout**: id, name, caloriesPerHour, workout logs
* **WorkoutLog**: id, workoutDate, durationMinutes, caloriesBurned, user, workout

### 2. Relationships

* Many-to-many between users and workouts (realized through **WorkoutLog**)
* One-to-many between users and workout logs
* One-to-many between workouts and workout logs

### 3. REST Endpoints

Implement endpoints for:

* CRUD operations for users and workouts
* List all workout logs for a user
* Log a workout (`POST` – create a workout log for a user and workout)
* Delete a workout log
* Get the **total calories burned** by a user

### 4. Data Initialization

* Create at least **3 users** and **3 workout types** at startup
* Insert workout logs so every user has performed multiple workouts and every workout type is used
* Ensure total-calories endpoints are testable immediately

### 5. Database

* Use H2 in-memory database
* Enable the H2 console for debugging

### 6. JSON Serialization

* Prevent infinite recursion in JSON responses (e.g., with `@JsonManagedReference` / `@JsonBackReference` or `@JsonIgnore`)

## Example Endpoints

* `GET /workouts` — List all workouts
* `GET /users/{userId}/logs` — List workout logs for a user
* `POST /users/{userId}/workouts/{workoutId}/logs` — Log a workout
* `DELETE /users/{userId}/logs/{logId}` — Delete a workout log
* `GET /users/{userId}/total-calories` — Get total calories burned by a user
* CRUD endpoints for users and workouts

## Deliverables

* Complete Spring Boot project with code and configuration
* Data initialization logic (`CommandLineRunner` or similar)
* Example Postman collection or API documentation for testing

## Bonus

* Endpoint to list workouts performed within a date range for a user
* Validation (e.g., `durationMinutes` must be > 0) and robust error handling

---

**Try to implement this assignment yourself!**

* Follow the requirements above as your guide.
* Test your API with Postman or curl.
* Explore the H2 console at `/h2-console` (default username: `sa`, empty password unless changed).
