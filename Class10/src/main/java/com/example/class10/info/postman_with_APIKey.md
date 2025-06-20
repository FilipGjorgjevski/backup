# Postman API Testing Guide with API Key Authentication

This document provides detailed instructions for testing all endpoints in the Class10 Spring Boot Student Grades API using Postman, including the required API Key authentication.

## API Key Authentication Setup

All requests to the API require an API Key for authentication. Follow these steps:

1. **API Key Details:**
   - **Header Name:** `X-API-KEY`
   - **API Key Value:** `e1c11dc9-9f1b-4d13-b3a1-a7f00ea39aca`

2. **Setting up in Postman:**
   - Open Postman
   - For each request, add a header with key `X-API-KEY` and value `e1c11dc9-9f1b-4d13-b3a1-a7f00ea39aca`
   - Alternatively, set up a global header in your collection settings
# Postman API Testing Guide with API Key Authentication

This document lists all REST endpoints for the Class10 Spring Boot Student Grades API and provides example requests and payloads for testing with Postman, including the required API key authentication.

## API Key Authentication

All endpoints require API key authentication using the following HTTP header:
- Header Name: `X-API-KEY`
- Header Value: `e1c11dc9-9f1b-4d13-b3a1-a7f00ea39aca`

Make sure to add this header to all your Postman requests.

## Setting Up API Key in Postman

1. You can add the API key to each individual request, or
2. Create a collection and set the API key at the collection level:
   - Click on the collection settings (...)
   - Go to the "Authorization" tab
   - Select "API Key" from the Type dropdown
   - Enter "X-API-KEY" as the Key
   - Enter "e1c11dc9-9f1b-4d13-b3a1-a7f00ea39aca" as the Value
   - Select "Header" for Add to

---

## Endpoints

### 1. List All Courses
**GET** `/courses`

#### Example Request
3. **Response if API Key is Missing or Invalid:**
   - Status Code: 401 Unauthorized
   - Body: "Invalid or missing API key"

## Student Endpoints

### 1. List All Students
**GET** `/students`

This endpoint retrieves a list of all students in the system.

**Example Request:**
