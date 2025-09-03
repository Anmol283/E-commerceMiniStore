# 🛍️ E-Commerce Mini Store

A mini e-commerce platform built with Spring Boot, Spring Security (JWT), and MySQL.
This project demonstrates a production-ready backend for handling user authentication, role-based authorization, and basic store functionality.

## 🚀 Features

- ✅ User Registration & Login (with JWT Authentication)  
- ✅ Role-based Access Control (**USER** & **ADMIN**)  
- ✅ Secure Password Storage (BCrypt)  
- ✅ REST API for Authentication  
- ✅ MySQL Database Integration with JPA/Hibernate  
- ✅ Spring Security with Stateless Sessions  
- ✅ Extensible structure for adding products, orders, and payments  

## 🏗️ Tech Stack

- **Backend Framework:** Spring Boot 3
- **Database:** MySQL
- **ORM:** Hibernate / JPA
- **Security:** Spring Security, JWT
- **Build Tool:** Maven
- **Testing:** Postman (for API testing)

## 📂 Project Structure
```
E_commerceMiniStore/
│── src/main/java/com/example/E_commerceMiniStore
│   ├── entity/        # JPA Entities (User, Role, Product etc.)
│   ├── repository/    # Spring Data JPA Repositories
│   ├── service/       # Business Logic Layer
│   ├── controller/    # REST Controllers
│   ├── security/      # JWT & Security Configurations
│   └── ECommerceMiniStoreApplication.java
│
│── src/main/resources
│   ├── application.properties  # DB Configurations
│
└── pom.xml
```

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/yourusername/E_commerceMiniStore.git
cd E_commerceMiniStore
```

### 2️⃣ Configure MySQL Database
Create a database in MySQL (use _ instead of -):
```sql
CREATE DATABASE e_commerce;
```

Update your application.properties file:
```
spring.datasource.url=jdbc:mysql://localhost:3306/e_commerce
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Build & Run the Project
```sh
mvn spring-boot:run
```

Application will start at:
👉 http://localhost:8080

## 🔑 API Endpoints

### Authentication

#### 1. Register User
**POST** `/api/auth/register`
Content-Type: application/json

Request Body (JSON):
```json
{
	"fullName": "Akshit Salwan",
	"email": "akshit@example.com",
	"password": "securepassword",
	"role": "USER"
}
```

#### 2. Login User
**POST** `/api/auth/login`
Content-Type: application/json

Request Body (JSON):
```json
{
	"email": "akshit@example.com",
	"password": "securepassword"
}
```

Response:
```json
{
	"token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Use this token in headers for secured endpoints:
```
Authorization: Bearer <your_token_here>
```

## 🛡️ Security

**Public Endpoints:**
- `/api/auth/**` → accessible to everyone

**Protected Endpoints:**
- `/api/**` → requires JWT authentication

## 📌 Future Enhancements

🔹 Product & Category Management
🔹 Shopping Cart & Orders
🔹 Payment Gateway Integration
🔹 Admin Dashboard
🔹 Email Notifications

## 🤝 Contributing

- Fork the repo
- Create a feature branch (`git checkout -b feature/new-feature`)
- Commit changes (`git commit -m 'Added new feature'`)
- Push to branch (`git push origin feature/new-feature`)
- Create a Pull Request

## 📜 License

This project is licensed under the MIT License – free to use and modify.
