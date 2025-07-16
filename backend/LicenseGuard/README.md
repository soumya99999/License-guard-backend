# LicenseGuard Backend

## Project Overview
LicenseGuard is a backend application designed to manage licenses and procurement records. It provides RESTful APIs to handle license data, procurement records, and related business logic. The application follows a layered architecture with controllers, services, and repositories to ensure clean separation of concerns.

## Tech Stack
- Java 11+
- Spring Boot (for building REST APIs and application framework)
- Maven (build and dependency management)
- JPA / Hibernate (for database interaction)
- Any relational database (configured via application.properties)
- Other dependencies as defined in `pom.xml`

## Sequence Flow / Functionality Overview
1. Client sends HTTP requests to the REST API endpoints exposed by controllers.
2. Controllers handle incoming requests, validate input, and delegate business logic to services.
3. Services contain the core business logic and interact with repositories for data persistence.
4. Repositories provide data access layer using JPA to perform CRUD operations on the database.
5. The application manages License entities and ProcurementRecord entities, allowing creation, retrieval, update, and deletion.
6. Configuration and application properties are managed in `src/main/resources/application.properties`.

### Project Specific Flow
1. Procurement record sends information to the system.
2. Admin of LicenseGuard creates a license based on the procurement record.
3. The license is then assigned to the vendor.
*In this way, the system manages licenses efficiently from procurement to vendor assignment.*

## How to Start

### Prerequisites
- Java Development Kit (JDK) 11 or higher installed
- Maven installed
- A configured relational database (e.g., MySQL, PostgreSQL) and connection details set in `application.properties`

### Build and Run
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd LicenseGuard
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. The backend server will start, typically on `http://localhost:8080`.

### Configuration
- Update database connection settings in `src/main/resources/application.properties` as per your environment.

---

For further details, refer to the source code and documentation within the project.
