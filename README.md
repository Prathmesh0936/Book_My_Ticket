# Book My Ticket

Book My Ticket is a bus ticket booking application built with Spring Boot. It allows users to register, login, book tickets, and generate PDF tickets.

## Key Features

- Developed a full-stack bus ticket booking application using Spring Boot, providing functionalities for user registration, login, and ticket booking.<br>
- Implemented RESTful APIs for managing buses, schedules, and ticket bookings, ensuring efficient and secure data handling.<br>
- Integrated PDF generation for ticket bookings, allowing users to download and print their tickets.<br>
- Utilized Spring Security for user authentication and authorization, enhancing the application's security.<br>
- Configured email notifications for password reset functionality, improving user experience and account security.<br>
- Designed and managed the MySQL database schema to store user, bus, schedule, and booking information.<br>
- Employed Maven for project build and dependency management, ensuring a streamlined development process.<br>
- Conducte- d unit testing using JUnit to ensure code quality and reliability.<br>
- Deployed the application on a local server and tested it thoroughly to ensure functionality and performance.<br>
- Collaborated with a team using Git for version control, facilitating efficient code management and collaboration.<br>

## Features

- User registration and login
- Bus management (add, update, delete, view buses)
- Schedule management
- Ticket booking
- PDF ticket generation
- Email notifications for password reset

# 💻 Tech Stack:
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

## Project Structure
.
├── .classpath<br>
├── .gitattributes<br>
├── .gitignore<br>
├── .mvn/<br>
│   └── wrapper/<br>
│       └── maven-wrapper.properties<br>
├── .project<br>
├── .settings/<br>
│   ├── org.eclipse.core.resources.prefs<br>
│   ├── org.eclipse.jdt.apt.core.prefs<br>
│   ├── org.eclipse.jdt.core.prefs<br>
│   ├── org.eclipse.m2e.core.prefs<br>
│   └── org.springframework.ide.eclipse.prefs<br>
├── .vscode/<br>
│   └── settings.json<br>
├── HELP.md<br>
├── mvnw<br>
├── mvnw.cmd<br>
├── pom.xml<br>
├── src/<br>
│   ├── main/<br>
│   │   ├── java/<br>
│   │   │   └── com/prathmesh/bookmyticket/<br>
│   │   │       ├── BookMyTicketApplication.java<br>
│   │   │       ├── Controller/<br>
│   │   │       │   ├── Auth_Controller.java<br>
│   │   │       │   ├── Bus_Controller.java<br>
│   │   │       │   ├── ChangePasswordController.java<br>
│   │   │       │   └── Ticket_Controller.java<br>
│   │   │       ├── DAO/<br>
│   │   │       │   ├── Add_Bus_DAO.java<br>
│   │   │       │   ├── ChangePasswordDAO.java<br>
│   │   │       │   ├── CheckOtpDAO.java<br>
│   │   │       │   ├── Login_DAO.java<br>
│   │   │       │   ├── Register_User_DAO.java<br>
│   │   │       │   ├── SendEmailDAO.java<br>
│   │   │       │   └── Update_Bus_DAO.java<br>
│   │   │       ├── Repository/<br>
│   │   │       │   ├── Booking_Repository.java<br>
│   │   │       │   ├── Bus_Repository.java<br>
│   │   │       │   ├── PDFGeneration_Repository.java<br>
│   │   │       │   ├── Schedule_Repository.java<br>
│   │   │       │   └── User_Repository.java<br>
│   │   │       ├── Security_Configuration.java<br>
│   │   │       ├── Service/<br>
│   │   │       │   ├── Bus_Service.java<br>
│   │   │       │   ├── ChangeUserPasswordService.java<br>
│   │   │       │   ├── MyUserDetialsService.java<br>
│   │   │       │   ├── TicketGeneration_Service.java<br>
│   │   │       │   └── User_Service.java<br>
│   │   │       ├── entity/<br>
│   │   │       │   ├── Booking.java<br>
│   │   │       │   ├── Buses.java<br>
│   │   │       │   ├── PDFGeneration.java<br>
│   │   │       │   ├── Schedule.java<br>
│   │   │       │   └── User.java<br>
│   │   └── resources/<br>
│   │       ├── application.properties<br>
│   │       └── static/<br>
│   │       └── templates/<br>
│   └── test/
│       └── java/com/prathmesh/bookmyticket/<br>
│           └── BookMyTicketApplicationTests.java<br>
└── target/<br>
    ├── classes/<br>
    └── test-classes/<br>


## Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/book-my-ticket.git
    cd book-my-ticket
    ```

2. Update the database configuration in [application.properties](http://_vscodecontentref_/37):
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/book_my_ticket_db
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    ```

3. Build the project:
    ```sh
    ./mvnw clean install
    ```

4. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

## Usage

- Access the application at [http://localhost:8080](http://_vscodecontentref_/38)
- Use the following endpoints:
    - `/auth/register` - Register a new user
    - `/auth/login` - Login a user
    - `/buseses` - Manage buses
    - `/tickets/generate/{id}` - Generate a ticket PDF

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
