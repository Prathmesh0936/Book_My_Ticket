# Book My Ticket

Book My Ticket is a bus ticket booking application built with Spring Boot. It allows users to register, login, book tickets, and generate PDF tickets.

## Key Features

Developed a full-stack bus ticket booking application using Spring Boot, providing functionalities for user registration, login, and ticket booking.<br>
Implemented RESTful APIs for managing buses, schedules, and ticket bookings, ensuring efficient and secure data handling.<br>
Integrated PDF generation for ticket bookings, allowing users to download and print their tickets.<br>
Utilized Spring Security for user authentication and authorization, enhancing the application's security.<br>
Configured email notifications for password reset functionality, improving user experience and account security.<br>
Designed and managed the MySQL database schema to store user, bus, schedule, and booking information.<br>
Employed Maven for project build and dependency management, ensuring a streamlined development process.<br>
Conducted unit testing using JUnit to ensure code quality and reliability.<br>
Deployed the application on a local server and tested it thoroughly to ensure functionality and performance.<br>
Collaborated with a team using Git for version control, facilitating efficient code management and collaboration.<br>

## Features

- User registration and login
- Bus management (add, update, delete, view buses)
- Schedule management
- Ticket booking
- PDF ticket generation
- Email notifications for password reset

## Project Structure
. ├── .classpath ├── .gitattributes ├── .gitignore ├── .mvn/ │ └── wrapper/ │ └── maven-wrapper.properties ├── .project ├── .settings/ │ ├── org.eclipse.core.resources.prefs │ ├── org.eclipse.jdt.apt.core.prefs │ ├── org.eclipse.jdt.core.prefs │ ├── org.eclipse.m2e.core.prefs │ └── org.springframework.ide.eclipse.prefs ├── .vscode/ │ └── settings.json ├── HELP.md ├── mvnw ├── mvnw.cmd ├── pom.xml ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── com/ │ │ │ └── prathmesh/ │ │ │ └── bookmyticket/ │ │ │ ├── BookMyTicketApplication.java │ │ │ ├── Controller/ │ │ │ │ ├── Auth_Controller.java │ │ │ │ ├── Bus_Controller.java │ │ │ │ ├── ChangePasswordController.java │ │ │ │ └── Ticket_Controller.java │ │ │ ├── DAO/ │ │ │ │ ├── Add_Bus_DAO.java │ │ │ │ ├── ChangePasswordDAO.java │ │ │ │ ├── CheckOtpDAO.java │ │ │ │ ├── Login_DAO.java │ │ │ │ ├── Register_User_DAO.java │ │ │ │ ├── SendEmailDAO.java │ │ │ │ └── Update_Bus_DAO.java │ │ │ ├── Repository/ │ │ │ │ ├── Booking_Repository.java │ │ │ │ ├── Bus_Repository.java │ │ │ │ ├── PDFGeneration_Repository.java │ │ │ │ ├── Schedule_Repository.java │ │ │ │ └── User_Repository.java │ │ │ ├── Security_Configuration.java │ │ │ ├── Service/ │ │ │ │ ├── Bus_Service.java │ │ │ │ ├── ChangeUserPasswordService.java │ │ │ │ ├── MyUserDetialsService.java │ │ │ │ ├── TicketGeneration_Service.java │ │ │ │ └── User_Service.java │ │ │ └── entity/ │ │ │ ├── Booking.java │ │ │ ├── Buses.java │ │ │ ├── PDFGeneration.java │ │ │ ├── Schedule.java │ │ │ └── User.java │ │ └── resources/ │ │ ├── application.properties │ │ └── static/ │ │ └── templates/ │ └── test/ │ └── java/ │ └── com/ │ └── prathmesh/ │ └── bookmyticket/ │ └── BookMyTicketApplicationTests.java └── target/ ├── classes/ └── test-classes/


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
