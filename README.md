# Group 3 Capstone Project: Employee HR System "Madame Papier" 📅

## About:
An Employee management system application, where the main function is to track an employee’s details & work schedule with additional options to request/approve shifts depending on their employee type e.g. Employee or HR Employee.

### The Fullstack Team:
* **Janet Mensah**
* **Mehlia Rahman**
* **Annie Wilson**
* **Kacper Nowak**
* **Rayster Ramos**

## Project Aims:
### For Users:
Personas -->

### For Developers:

### Libraries Used:
* Spring Boot Starter Data JPA
* Spring Boot Starter Web
* Spring Boot devtools
* PostgreSQL

## MVP
MSCW Diagram -->

## Extensions

## Back-End Planning

### UML Class Diagram:

### ERD Diagram:

### RESTful Routes:

#### Users

**GET** All Users: `localhost:8080/users/1`

**JSON RESPONSE**


**GET** User by ID with Access Control: `localhost:8080/users/2/find/2`

**JSON RESPONSE**

`{
    "id": 2,
    "name": "Janet",
    "email": "janet@mail.com",
    "username": "JanetRF",
    "occupation": "Sales Assistant",
    "userRole": "EMPLOYEE",
    "shiftRotations": []
}`


**POST** Create New User: `localhost:8080/users/1`

**JSON RESPONSE**


#### Shifts

**GET** 

**JSON RESPONSE**


### GET Mapping

### POST Mapping
	
### PATCH Mapping

### DELETE Mapping


## Front-End Planning

### Wireframe:

### Props Diagram:




