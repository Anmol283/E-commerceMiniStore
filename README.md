# 🛒 E-commerce Mini Store
<div align="center"> <img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExbm11OHEzeHZueHZscjBjc3Fia3o0YWcxdGV2Nzl5ZWU4YWUzY2JuNSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Hu475i12tHBg94FIeD/giphy.gif" alt="Shopping GIF" width="300" height="300"></div>

## ✨ Overview

E-Commerce Mini Store is a full-stack web application built with Spring Boot, Java, JWT, and MySQL. It provides a complete platform for product management, cart handling, order checkout, and user authentication with roles (CUSTOMER and MANAGER).

---


## 🌟 Features

- **👤 User Authentication**
  - Register and login functionality
  - Role-based access (CUSTOMER and MANAGER) 
  - JWT-based stateless authentication

- **🛍️ Product Mangement**
  - Managers can add, update, and delete products
  - Customers and Managers can view all available products

- **🛒 Cart System**
  - Add, update, and remove items from cart  
  - Customers can checkout orders 

---

## 🛠️ Tech Stack

| Category         | Technologies                                                                                                           |
|------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Backend**      | <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot" /> <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java" />
| **Database**     | <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
| **Security**   | <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jwt&logoColor=white" alt="JWT" /> <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Security" />|
| **Frontend**     | <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5" /> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="CSS3" />
---

## 📁 Directory Structure

```
E-Commerce-MiniStore/
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/com/example/E_commerceMiniStore/
│   │   │   ├── controller/          # REST Controllers for Products, Cart, Orders, Auth
│   │   │   ├── entity/              # JPA Entities (User, Product, CartItem, Order)
│   │   │   ├── repository/          # Spring Data JPA Repositories
│   │   │   ├── security/            # JWT Service, Filters, Security Config
│   │   │   ├── service/             # Service classes for business logic
│   │   │   └── ECommerceMiniStoreApplication.java  # Main Spring Boot application
│   │   └── 📂 resources/
│   │       ├── application.properties   # Application configuration
│   │       ├── static/                 # CSS, JS, images
│   │       └── templates/              # Thymeleaf templates (optional)
├── 📂 target/                        # Compiled files
├── 📄 pom.xml                        # Maven dependencies
├── 📄 README.md                       # Project documentation
└── 📄 .gitignore                      # Git ignore file

```
---
## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL
- Postman (for API testing)

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Anmol283/E-commerceMiniStore
   cd E-Commerce-MiniStore
   ```

2. **Configure Database**:
   Update `application.properties` with your `MySQL` credentials:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   jwt.secret=YourSecretKey
   jwt.expirationMs=3600000
   ```

4. **Build and run the application**:
   ```
   mvn clean install
   mvn spring-boot:run
   ```
---
## 🧭 API USAGE

### Auth
- POST `/api/auth/register` – Register new user
- POST /api/auth/login – Login and get JWT

### Products
- GET `/api/products` – Get all products (any role)
- POST `/api/products` – Add product (MANAGER only)
- PUT `/api/products/{id}` – Update product (MANAGER only)
- DELETE `/api/products/{id}` – Delete product (MANAGER only)

### Cart
- GET `/api/cart?userId={id}` – Get cart items (CUSTOMER only)
- POST `/api/cart/add` – Add item to cart (CUSTOMER only)
- PUT `/api/cart/{id}` – Update cart item (CUSTOMER only)
- DELETE `/api/cart/{id}` – Remove cart item (CUSTOMER only)

### Orders
- GET `/api/orders/my?userId={id}` – Get user orders (CUSTOMER only)
- POST `/api/orders/checkout?userId={id}` – Checkout cart (CUSTOMER only)
---

## 🔒 Security Features

- JWT-based stateless authentication
- Role-based access `(CUSTOMER and MANAGER)`
- Password hashing with BCrypt
- Protected API routes using Spring Security

---
## 🤝 Contributing

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Make your changes and commit (`git commit -m "Add feature"`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a Pull Request

---

## 📜 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

⭐ **Star this repository if you find it useful!** ⭐
