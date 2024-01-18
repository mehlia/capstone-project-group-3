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

User Personas

![Screenshot 2024-01-16 at 12 08 53](https://github.com/mehlia/capstone-project-group-3/assets/131881583/472bfcd1-aa53-469f-b56f-1fced9e939e1)


### For Developers:

### Libraries Used:
* Spring Boot Starter Data JPA
* Spring Boot Starter Web
* Spring Boot devtools
* PostgreSQL

## MVP

MSCW Diagram

![Screenshot 2024-01-16 at 12 15 54](https://github.com/mehlia/capstone-project-group-3/assets/131881583/4fae84d7-7b49-4062-bece-56c2f0050f46)

## Extensions

## Back-End Planning

### UML Class Diagram:

![Screenshot 2024-01-16 at 12 05 21](https://github.com/mehlia/capstone-project-group-3/assets/131881583/b09655da-b2fe-449e-98a6-93f6e00f845b)

### ERD Diagram:

![Screenshot 2024-01-16 at 12 04 48](https://github.com/mehlia/capstone-project-group-3/assets/131881583/5ee24798-3f4a-46c7-878d-beab003e2338)

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

![Screenshot 2024-01-16 at 12 14 16](https://github.com/mehlia/capstone-project-group-3/assets/131881583/794e0537-f6aa-4b8c-b57d-226235fe84fe)

### Props Diagram:






