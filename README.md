# Seller Management System

A full-stack web application for managing seller information, built with Spring Boot (backend) and Angular (frontend). This project implements a complete CRUD (Create, Read, Update, Delete) system for seller management.

## Project Overview

This application allows users to:
- View a list of all registered sellers
- Add new sellers with validation
- Edit existing seller information
- Delete sellers from the system
- Navigate through a responsive web interface

The system manages seller data including name, salary, bonus percentage, and gender information.

## Technology Stack

### Backend
- **Java 21**
- **Spring Boot 4.0.1**
- **Spring Data JPA** - Database operations
- **Spring Validation** - Input validation
- **H2 Database** - In-memory database for development
- **Maven** - Dependency management

### Frontend
- **Angular 21.0.0**
- **TypeScript 5.9.2**
- **Bootstrap 5.3.8** - UI framework
- **Bootstrap Icons** - Icon library
- **RxJS** - Reactive programming
- **Angular Reactive Forms** - Form handling

## Project Structure

```
capitulo08-sellers/
├── backend/                 # Spring Boot application
│   ├── src/main/java/
│   │   └── com/sellers/backend/
│   │       ├── controllers/     # REST controllers
│   │       ├── models/          # Entity classes
│   │       ├── repositories/    # Data access layer
│   │       ├── services/        # Business logic
│   │       └── dto/             # Data transfer objects
│   └── src/main/resources/
│       ├── application.properties
│       └── data.sql            # Initial data
└── frontend/                # Angular application
    └── src/app/
        ├── components/      # Angular components
        ├── services/        # HTTP services
        └── interfaces/      # TypeScript interfaces
```

## Prerequisites

Before running this application, make sure you have the following installed:

- **Java 21** or higher
- **Node.js 18** or higher
- **npm** package manager
- **Maven 3.6** or higher

## Installation and Setup

### Backend Setup

1. Navigate to the backend directory:
```bash
cd backend
```

2. Install dependencies and run the application:
```bash
./mvnw spring-boot:run
```

The backend server will start on `http://localhost:8080`

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The frontend application will be available at `http://localhost:4200`

## API Endpoints

The backend provides the following REST endpoints:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/sellers` | Retrieve all sellers |
| GET | `/sellers/{id}` | Retrieve a specific seller |
| POST | `/sellers` | Create a new seller |
| PUT | `/sellers/{id}` | Update an existing seller |
| DELETE | `/sellers/{id}` | Delete a seller |

## Database Configuration

The application uses H2 in-memory database for development. The database is automatically initialized with sample data on startup.

**Database Access:**
- Endpoint: `/h2-console`
- URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)

## Features

### Seller Management
- **Create**: Add new sellers with form validation
- **Read**: View all sellers in a responsive table
- **Update**: Edit seller information inline
- **Delete**: Remove sellers with confirmation dialog

### Validation
- Name: Required, 2-255 characters
- Salary: Required, positive number
- Bonus: Required, 0-100%
- Gender: Male (1) or Female (0)

### User Interface
- Responsive design with Bootstrap
- Clean and intuitive navigation
- Form validation with error messages
- Confirmation dialogs for destructive actions

## Contributing

This project was developed as part of a coursework assignment. For educational purposes, feel free to explore and learn from the implementation.

## Academic Context

This project was developed as a task for the **DevJr Bootcamp** under the guidance of **Teacher Glauco Todesco** at **Abútua**. The project demonstrates the implementation of a full-stack web application using modern Java and Angular technologies.

## License

This project is for educational purposes only.