# GamingCafeBackend

A **Spring MVC-based project** to manage user sessions and personal computers (PCs) in a gaming cafe. This system allows the registration of PCs, session management (start and end sessions), and retrieval of available PCs with real-time charges generation.

---

## Features

### 1. **Personal Computer Management**
   - Register new PCs.
   - Retrieve a list of available PCs.

### 2. **Session Management**
   - Start a new user session.
   - End a session and calculate charges based on session duration.
   - Store session details, such as user name, start time, end time, duration, and charges.

---

## Technologies Used
- **Spring MVC**: For REST API and application logic.
- **JPA (Java Persistence API)**: For database interaction.
- **MySQL**: Database to store PC and session details.
- **Lombok**: To reduce boilerplate code.
- **Jakarta Validation API**: For request validation.

---

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK) 17 or later
- Apache Maven
- MySQL server
- An IDE (e.g., IntelliJ IDEA, Eclipse)

## Project Structure

gaming-cafe/
├── src/
│   ├── main/
│   │   ├── java/com/example/gamingCafe/
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── entities/         # JPA entities
│   │   │   ├── repository/       # JPA repositories
│   │   │   ├── service/          # Service interfaces
│   │   │   ├── serviceImpl/      # Service implementations
│   │   │   └── GamingCafeApplication.java # Main entry point
│   │   └── resources/
│   │       ├── application.properties # Configuration
│   │       └── data.sql          # Initial database seed (optional)
│   └── test/
│       └── java/com/example/gamingCafe/ # Unit and integration tests
└── pom.xml                       # Maven configuration

## License

This project is licensed under the MIT License.

## Contact

mail : nailwalnikhil17@gmail.com
