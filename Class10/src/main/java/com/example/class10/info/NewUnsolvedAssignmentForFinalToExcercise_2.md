# Assignment: Employee Timesheet REST API with Spring Boot, JPA, and H2

## Objective

Build a Spring Boot REST API to manage employees, projects, and timesheet entries. The API should support CRUD operations, allow employees to log hours on projects, and retrieve total hours for each project. Persist data with JPA and an in-memory H2 database, and initialize sample data at startup.

## Requirements

### 1. Entities

* **Employee**: id, name, timesheet entries
* **Project**: id, name, description, timesheet entries
* **TimesheetEntry**: id, workDate, hoursWorked, employee, project

### 2. Relationships

* Many-to-many between employees and projects (via timesheet entries)
* One-to-many between employees and timesheet entries
* One-to-many between projects and timesheet entries

### 3. REST Endpoints

Implement endpoints for:

* CRUD operations for employees and projects
* List timesheet entries for a project
* Add a timesheet entry (date + hours) for an employee on a project
* Delete a timesheet entry
* Get the **total hours logged** for a project

### 4. Data Initialization

* Create at least **3 employees** and **3 projects** at startup
* Add timesheet entries so every project has hours from multiple employees
* Ensure total-hours endpoints are testable immediately

### 5. Database

* Use H2 in-memory database
* Enable the H2 console for debugging

### 6. JSON Serialization

* Prevent infinite recursion in JSON responses (e.g., with `@JsonManagedReference` / `@JsonBackReference` or `@JsonIgnore`)

## Example Endpoints

* `GET /projects` — List all projects
* `GET /projects/{projectId}/timesheets` — List timesheet entries for a project
* `POST /projects/{projectId}/employees/{employeeId}/timesheets` — Add timesheet entry
* `DELETE /projects/{projectId}/timesheets/{entryId}` — Delete a timesheet entry
* `GET /projects/{projectId}/total-hours` — Get total hours for a project
* CRUD endpoints for employees and projects

## Deliverables

* Complete Spring Boot project with code and configuration
* Data initialization logic (`CommandLineRunner` or similar)
* Example Postman collection or API documentation for testing

## Bonus

* Endpoints to list all timesheet entries by an employee
* Validation (e.g., `hoursWorked` must be > 0 and ≤ 24) and robust error handling

---

**Try to implement this assignment yourself!**

* Use the requirements above as your guide.
* Test your API with Postman or curl.
* Explore the H2 console at `/h2-console` (default username: `sa`, empty password unless changed).
