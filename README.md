# Online Marketplace (Java Spring Boot)

## 🎯 Project Goal
This project was developed as a learning practice with **Java** using **Spring Boot**.  
Goals:  
- Learn the architecture of web applications in Java.  
- Practice working with Spring Boot, Spring Security, and Hibernate.  
- Demonstrate skills for portfolio purposes.  
- Create a fully functional prototype of an online marketplace.  

---

## 🛠️ Tech Stack
- **Java 17**  
- **Spring Boot** — main application framework  
- **Spring Security** — authentication and authorization  
- **Hibernate** — ORM for database interaction  
- **PostgreSQL** — relational database  
- **Lombok** — reduces boilerplate code  

---

## 🚀 How to Run the Project

### Requirements
- **Java 17+**  
- **PostgreSQL** (installed locally or remote instance)  
- **Maven**  

### Database Configuration
Database connection settings are located in the `application.yml` file:  
```yaml

spring:
    application:
        name: bysell
    datasource:
        url: jdbc:postgresql://localhost:5432/by_sell_db
        username: postgres
        password: postgres
        driver-class-name: org.postgresql.Driver
        hikari:
            auto-commit: false
    jpa:
        hibernate:
            ddl-auto: update
        database: postgresql
        database-platform: org.hibernate.dialect.PostgreSQLDialect
        show-sql: true
        properties:
            hibernate:
                format_sql: true
                default_schema: bysell
    freemarker:
        expose-request-attributes: true

    servlet:
        multipart:
            max-file-size: 100MB
            max-request-size: 100MB

```

### Run Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/NikitaSipeykin/SpringMarketPlace.git
   ```
2. Navigate into the project folder:
   ```bash
   cd SpringMarketPlace
   ```
3. Install dependencies and build the project:
   ```bash
   mvn clean install
   ```
4. Start the application:
   ```bash
   mvn spring-boot:run
   ```
5. By default, the server runs at:  
   [http://localhost:8080](http://localhost:8080)  

---

## 📂 API Examples

### 🔹 Products
- `GET /` — view all products (supports search by title).  
- `GET /product/{id}` — get product details by id.  
- `POST /product/create` — create a new product (with images).  
- `POST /product/delete/{id}` — delete a product of the current user.  
- `GET /my/products` — view products of the current user.  
- `GET /images/{id}` — retrieve an image by id.  

### 🔹 Users
- `GET /login` — login page.  
- `GET /registration` — registration page.  
- `POST /registration` — register a new user.  
- `GET /profile` — current user profile page.  
- `GET /user/{user}` — user details page with their products.  

### 🔹 Administration
- `GET /admin` — admin dashboard.  
- `POST /admin/user/ban/{id}` — ban a user.  
- `GET /admin/user/edit/{user}` — edit user roles form.  
- `POST /admin/user/edit` — save changes to user roles.  

---
