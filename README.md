# Book My Ticket - Bus Booking System

A full-stack bus booking application built with Spring Boot and React, providing a seamless experience for users to book bus tickets online.

## Features

### User Features
- User registration and authentication
- Secure password management with OTP verification
- Bus search with source and destination
- Seat selection and booking
- PDF ticket generation
- Booking history
- Profile management

### Admin Features
- Bus management (CRUD operations)
- Schedule management
- Booking management
- User management
- Report generation

## 🛠️ Technology Stack

### Backend
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- MySQL Database
- Maven
- JWT Authentication
- iText PDF (for ticket generation)

### Frontend (Planned)
- React
- Material-UI
- Redux Toolkit
- React Router
- Axios
- Formik & Yup

## 📋 Prerequisites

- JDK 17 or higher
- Maven
- MySQL
- Node.js (for frontend)
- IDE (IntelliJ IDEA/Eclipse)

## 🚀 Getting Started

### Backend Setup

1. Clone the repository
```bash
git clone [repository-url]
cd Book_My_Ticket
```

2. Configure MySQL database
```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyticket
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build and run the application
```bash
mvn clean install
mvn spring-boot:run
```

The backend server will start at `http://localhost:8080`

### Frontend Setup (Coming Soon)

1. Navigate to frontend directory
```bash
cd frontend
```

2. Install dependencies
```bash
npm install
```

3. Start development server
```bash
npm run dev
```

## 📚 API Documentation

### Authentication APIs
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /users/changepassword/email` - Send password reset OTP
- `POST /users/changepassword/check` - Verify OTP
- `PUT /users/changepassword` - Change password

### Bus Management APIs
- `GET /buseses` - Get all buses
- `GET /buseses/{id}` - Get bus by ID
- `POST /buseses` - Add new bus (Admin only)
- `PUT /buseses/{id}` - Update bus (Admin only)
- `DELETE /buseses/{id}` - Delete bus (Admin only)

### Ticket Management APIs
- `GET /tickets/generate/{id}` - Generate PDF ticket

## 🔒 Security

- JWT-based authentication
- Role-based access control (USER/ADMIN)
- Password encryption using BCrypt
- OTP verification for password reset
- CSRF protection
- Secure session management

##  Project Structure
# Book My Ticket - Bus Booking System

A full-stack bus booking application built with Spring Boot and React, providing a seamless experience for users to book bus tickets online.

## �� Features

### User Features
- User registration and authentication
- Secure password management with OTP verification
- Bus search with source and destination
- Seat selection and booking
- PDF ticket generation
- Booking history
- Profile management

### Admin Features
- Bus management (CRUD operations)
- Schedule management
- Booking management
- User management
- Report generation

## 🛠️ Technology Stack

### Backend
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- MySQL Database
- Maven
- JWT Authentication
- iText PDF (for ticket generation)

### Frontend (Planned)
- React
- Material-UI
- Redux Toolkit
- React Router
- Axios
- Formik & Yup

## 📋 Prerequisites

- JDK 17 or higher
- Maven
- MySQL
- Node.js (for frontend)
- IDE (IntelliJ IDEA/Eclipse)

## 🚀 Getting Started

### Backend Setup

1. Clone the repository
```bash
git clone [repository-url]
cd Book_My_Ticket
```

2. Configure MySQL database
```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyticket
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build and run the application
```bash
mvn clean install
mvn spring-boot:run
```

The backend server will start at `http://localhost:8080`

### Frontend Setup (Coming Soon)

1. Navigate to frontend directory
```bash
cd frontend
```

2. Install dependencies
```bash
npm install
```

3. Start development server
```bash
npm run dev
```

## 📚 API Documentation

### Authentication APIs
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /users/changepassword/email` - Send password reset OTP
- `POST /users/changepassword/check` - Verify OTP
- `PUT /users/changepassword` - Change password

### Bus Management APIs
- `GET /buseses` - Get all buses
- `GET /buseses/{id}` - Get bus by ID
- `POST /buseses` - Add new bus (Admin only)
- `PUT /buseses/{id}` - Update bus (Admin only)
- `DELETE /buseses/{id}` - Delete bus (Admin only)

### Ticket Management APIs
- `GET /tickets/generate/{id}` - Generate PDF ticket

## 🔒 Security

- JWT-based authentication
- Role-based access control (USER/ADMIN)
- Password encryption using BCrypt
- OTP verification for password reset
- CSRF protection
- Secure session management

## 📦 Project Structure
src/ <br>
├── main/<br>
│ ├── java/<br>
│ │ └── com/<br>
│ │ └── prathmesh/<br>
│ │ └── bookmyticket/<br>
│ │ ├── Controller/<br>
│ │ ├── Service/<br>
│ │ ├── Repository/<br>
│ │ ├── entity/<br>
│ │ ├── DAO/<br>
│ │ └── Security_Configuration.java<br>
│ └── resources/<br>
│ └── application.properties<br>
