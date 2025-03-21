Library Management System
Project Overview
The Library Management System is a web-based application built using Jakarta EE with JPA (EclipseLink) for persistence and Gson for JSON serialization. The application allows users to:

View available documents (Books and Magazines)
Borrow and return documents
Register new users
Add books or magazines to the system
The project follows a Model-View-Controller (MVC) architecture and uses Apache Tomcat as the servlet container.

Technologies Used
Jakarta EE (Servlets, JPA)
EclipseLink for JPA
Gson for JSON serialization
MySQL for the database
Apache Tomcat for running the web application
Maven for dependency management and building the project

Installation Instructions
1. Clone the Repository
   First, clone the repository to your local machine.

bash
Copy
git clone <repository_url>
cd LibraryManagement
2. Install Dependencies
   Ensure that Maven is installed on your machine. If not, download and install it from here.

Run the following command to download all dependencies:

bash
Copy
mvn install
3. Set Up the Database
   The application uses MySQL as the database.

Create a database in MySQL:
sql
Copy
CREATE DATABASE library_db;
Update Database Configuration in persistence.xml (located in src/main/resources/META-INF/persistence.xml) with your MySQL credentials:
xml
Copy
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/library_db"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value=""/>
4. Deploy the Application
   Download and Set Up Apache Tomcat from here.

Start Tomcat:

Navigate to the bin folder of Tomcat and run:
bash
Copy
./startup.sh
Deploy the WAR file:

Build the project by running:
bash
Copy
mvn clean package
Copy the LibraryManagement.war file from target/ to the webapps/ folder of your Tomcat installation.
Access the Application:

Open a browser and go to: http://localhost:8080/LibraryManagement
API Endpoints
The application exposes the following RESTful APIs:

1. List All Documents
   URL: /documents
   Method: GET
   Description: Retrieves a list of all available documents (books and magazines).
   Response:
   json
   Copy
   [
   {
   "id": 1,
   "title": "Java Programming",
   "dateCreate": "2024-03-21"
   },
   {
   "id": 2,
   "title": "Machine Learning",
   "dateCreate": "2024-03-20"
   }
   ]
2. Add a Book
   URL: /documents/book
   Method: POST
   Request Body:
   json
   Copy
   {
   "title": "Java EE Basics",
   "author": "John Doe",
   "isbn": "123456789",
   "datePublication": "2025-03-21"
   }
3. Register a User
   URL: /users
   Method: POST
   Request Body:
   json
   Copy
   {
   "name": "Alice",
   "mail": "alice@example.com"
   }
4. Borrow a Document
   URL: /borrows
   Method: POST
   Request Body:
   json
   Copy
   {
   "user": {
   "id": 1
   },
   "document": {
   "id": 1
   }
   }
5. Return a Document
   URL: /borrows/return
   Method: PUT
   Request Body:
   json
   Copy
   {
   "id": 1
   }
   Configuration
1. Tomcat Configuration
   Ensure Tomcat is configured to listen on port 8080 by checking server.xml under the conf/ directory:

xml
Copy
<Connector port="8080" protocol="HTTP/1.1"
connectionTimeout="20000"
redirectPort="8443" />
2. MySQL Configuration
   Ensure MySQL is running and the database is created (library_db).
   Project Structure Overview
   Controllers: Handle HTTP requests and map them to services (e.g., UserController, DocumentController).
   DAO (Data Access Objects): Interact with the database using JPA to persist and retrieve entities (e.g., UserDAO, DocumentDAO).
   Entities: Represent the database tables (e.g., User, Document, Book).
   Services: Contain the business logic and interact with DAO classes.
   Troubleshooting
   404 Error: Make sure the application is correctly deployed and that the servlet mappings are correct.
   Database Connection: Ensure MySQL is running and configured correctly in persistence.xml.
   Port Conflicts: If another application is using port 8080, change it in server.xml to another available port.

