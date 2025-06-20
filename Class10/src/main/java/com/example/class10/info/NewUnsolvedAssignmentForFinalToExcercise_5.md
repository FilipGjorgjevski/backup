# Assignment: Vehicle Maintenance REST API with Spring Boot, JPA, and H2

## Objective

Build a Spring Boot REST API to manage vehicles, mechanics, and service records. The API should support CRUD operations, let mechanics log services performed on vehicles, and provide the total maintenance cost for each vehicle. Persist data with JPA and an in-memory H2 database, pre-loading sample data at startup.

## Requirements

### 1. Entities

* **Vehicle**: id, make, model, year, service records
* **Mechanic**: id, name, specialization, service records
* **ServiceRecord**: id, serviceDate, description, cost, vehicle, mechanic

### 2. Relationships

* Many-to-many between vehicles and mechanics (realized through **ServiceRecord**)
* One-to-many between vehicles and service records
* One-to-many between mechanics and service records

### 3. REST Endpoints

Implement endpoints for:

* CRUD operations for vehicles and mechanics
* List all service records for a vehicle
* Add a service record (date, description, cost) for a vehicle by a mechanic
* Delete a service record
* Get the **total maintenance cost** for a vehicle

### 4. Data Initialization

* Create at least **3 vehicles** and **3 mechanics** at startup
* Insert service records so every vehicle has work logged by multiple mechanics and every mechanic has serviced multiple vehicles
* Ensure total-cost and listing endpoints are testable immediately

### 5. Database

* Use H2 in-memory database
* Enable the H2 console for debugging

### 6. JSON Serialization

* Prevent infinite recursion in JSON responses (e.g., with `@JsonManagedReference` / `@JsonBackReference` or `@JsonIgnore`)

## Example Endpoints

* `GET /vehicles` — List all vehicles
* `GET /vehicles/{vehicleId}/services` — List service records for a vehicle
* `POST /vehicles/{vehicleId}/mechanics/{mechanicId}/services` — Add a service record
* `DELETE /vehicles/{vehicleId}/services/{serviceId}` — Delete a service record
* `GET /vehicles/{vehicleId}/total-cost` — Get total maintenance cost for a vehicle
* CRUD endpoints for vehicles and mechanics

## Deliverables

* Complete Spring Boot project with all code and configuration
* Data initialization logic (`CommandLineRunner` or similar)
* Example Postman collection or API documentation for testing

## Bonus

* Endpoints to list all service records performed by a mechanic
* Validation (e.g., `cost` must be positive, `serviceDate` not in the future) and robust error handling

---

**Try to implement this assignment yourself!**

* Follow the requirements above as your guide.
* Test your API with Postman or curl.
* Explore the H2 console at `/h2-console` (default username: `sa`, empty password unless changed).
