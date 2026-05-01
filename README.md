# Barbershop Appointment Scheduling System

## Overview

This project is a for a barbershop appointment scheduling System built using Java Spring Boot and SQLite. The application allows clients to view available slots, book appointments, cancel appointments, and view appointment data using a simple frontend interface.

The system uses a layered architecture through:

* Controller Layer
* Service Layer
* Repository Layer

The application also demonstrates:

* JDBC database integration
* Double-booking prevention
* Mock notification service
* Health check endpoint
* Simple frontend UI 

---

# Tools Used

* Java (Backend)
* Spring Boot
* SQLite (Database)
* JDBC
* HTML / CSS / JavaScript (Frontend)
* IntelliJ IDEA
* GitHub (Repository)

---

# Project Structure

```text
src/main/java/edu/sjsu/cmpe172/starterdemo/

├── controller
│   ├── AppointmentController.java
│   ├── AvailabilitySlotController.java
│   ├── HealthController.java
│   ├── HomeController.java
│   └── NotificationController.java
│
├── model
│   ├── Appointment.java
│   └── AvailabilitySlot.java
│
├── repository
│   ├── AppointmentRepository.java
│   └── AvailabilitySlotRepository.java
│
├── service
│   ├── AppointmentService.java
│   └── AvailabilitySlotService.java
│
└── StarterDemoApplication.java
```

---

# Features

## View Appointments

Users can view all appointment records held in the database.

## View Available Slots

Users can view all haircut availabilities.

## Book Appointment

Users can book an appointment using:

* Client ID
* Barber ID
* Service ID
* Slot ID

The system prevents duplicate booking.

## Cancel Appointment

Users can cancel an appointment and reopen the slot availability.

## Health Check Endpoint

Endpoint:

```text
/health
```

Returns:

```text
Application is running and database is connected
```

## Mock Notification Service

The application simulates a notification service call when user books an appointment.

---

# Database

The application utilizes SQLite via JDBC integration.

Main tables:

* appointments
* availability_slots

Database initialization is handled through:

```text
schema.sql
```

---

# Running the Application

## 1. Clone the Repository

```bash
git clone <https://github.com/nguyenalan422/cmpe172-barbershop-application.git>
```

## 2. Open in IntelliJ IDEA

Open the project folder in IntelliJ IDEA.

## 3. Run the Spring Boot Application

Run:

```text
StarterDemoApplication.java
```

Or use:

```bash
./mvnw spring-boot:run
```

---

# Frontend UI

The frontend is located at:

```text
src/main/resources/static/index.html
```

Open in browser:

```text
http://localhost:8080/index.html
```

The UI supports:

* Viewing appointments
* Viewing slots
* Booking appointments
* Canceling appointments

---

# API Endpoints

## Appointments

### Get All Appointments

```http
GET /appointments
```

### Get Appointment By ID

```http
GET /appointments/{id}
```

### Book Appointment

```http
POST /appointments/book
```

### Cancel Appointment

```http
POST /appointments/cancel/{id}
```

---

## Slots

### Get All Slots

```http
GET /slots
```

---

## Health Endpoint

```http
GET /health
```

---

# Double Booking Prevention

The system checks slot availability prior to appointment booking.

In the case that a slot is already booked:

* Appointment creation is blocked
* Slot remains unavailable

This helps demonstrate transaction and concurrency protection.

---

# Future Improvements

Possible future enhancements:

* User login and authentication
* Real customer accounts
* Real notification service integration
* Barber and Customer profile management
* Payment integration
* Cloud deployment

---

# Author

Alan Nguyen

CMPE 172 Enterprise Software

San Jose State University

Spring 2026
