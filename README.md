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

**The Challenge:** Rainforest Retail have difficulty managing their employee details & schedules, recently transitioning from tedious paperwork to a flashy website.

**The Solution:** Madame Papier will create an efficient HR scheduling system: Schedulism to tackle this challenge Rainforest Retail have been facing. This will improve employee schedules & requests as well as provide a much more seamless system for the team.

### For Users:
* Implement an electronic calendar system for employees to view & request shifts.
* Provide extensive & comprehensive training to all staff for the app functionalities before the launch of the system.
* Create a responsive, mobile-friendly design.
* Comply with security regulations & protocols to protect confidential employee data.
* Allow separate access controls to employees & HR employees.


### For Developers:
* Create a scalable system with reusable & robust functionalities for future development.
* Clear, concise & well formatted code.


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

`{
    "id": 9,
    "name": "Prickle",
    "email": "prickle@mail.com",
    "username": "PrickleRF",
    "occupation": "Truck Driver",
    "userRole": "EMPLOYEE",
    "shiftRotations": null
}`


#### Shifts

**GET** Get All Shifts of Specific User: `localhost:8080/users/2/shift-rotations`

**JSON RESPONSE**

`[
    {
        "id": 4,
        "date": "2023-01-01",
        "createdBy": null,
        "user": {
            "id": 2,
            "name": "Janet",
            "email": "janet@mail.com",
            "username": "JanetRF",
            "occupation": "Sales Assistant",
            "userRole": "EMPLOYEE"
        },
        "shiftType": {
            "id": 1,
            "shiftSlot": "MORNING",
            "startTime": "08:00:00",
            "endTime": "14:00:00"
        },
        "hasBeenRequested": false,
        "approved": false
    },
    {
        "id": 5,
        "date": "2023-01-02",
        "createdBy": null,
        "user": {
            "id": 2,
            "name": "Janet",
            "email": "janet@mail.com",
            "username": "JanetRF",
            "occupation": "Sales Assistant",
            "userRole": "EMPLOYEE"
        },
        "shiftType": {
            "id": 3,
            "shiftSlot": "EVENING",
            "startTime": "16:00:00",
            "endTime": "22:00:00"
        },
        "hasBeenRequested": false,
        "approved": false
    },
    {
        "id": 6,
        "date": "2023-01-04",
        "createdBy": null,
        "user": {
            "id": 2,
            "name": "Janet",
            "email": "janet@mail.com",
            "username": "JanetRF",
            "occupation": "Sales Assistant",
            "userRole": "EMPLOYEE"
        },
        "shiftType": {
            "id": 2,
            "shiftSlot": "AFTERNOON",
            "startTime": "12:00:00",
            "endTime": "18:00:00"
        },
        "hasBeenRequested": false,
        "approved": false
    }
]`

**POST** Create New Shift Rotation: `localhost:8080/shift-rotations/createShift/4`

**JSON RESPONSE**

`{
   "date": "2024-01-15",
   "shiftType": {
       "id": 1,
       "shiftSlot": "MORNING",
       "startTime": "09:00:00",
       "endTime": "17:00:00"
   }
}`

**POST** Add User to Shift Rotation: `localhost:8080/shift-rotations/addUserToShift?shiftRotationId=7&hrEmployeeId=1&userToAddId=2`

**Request Params**

### GET Mapping

### POST Mapping
	
### PATCH Mapping

### DELETE Mapping


## Front-End Planning

### Wireframe:

### Props Diagram:




