<h1 align="center">🛒🛍️ E-commerce Mini Store</h1>
</br>
<div align="center"> <img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExbm11OHEzeHZueHZscjBjc3Fia3o0YWcxdGV2Nzl5ZWU4YWUzY2JuNSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Hu475i12tHBg94FIeD/giphy.gif" alt="Shopping GIF" width="300" height="300"></div>
</br>
<div align="center"> <i> Secure shopping, smooth coding.</i> </div>

---

## ✨ Overview

E-Commerce Mini Store is a full-stack web application leveraging Spring Boot, Java, JWT, and MySQL, designed with a scalable microservices architecture. It provides a complete platform for product management, cart handling, order checkout, and user authentication with roles (CUSTOMER and MANAGER).

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

| Category          | Technologies                                                                                                                                                                                                                                                                                                                                                      |
| ----------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Backend**       | <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot" /> <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java" />                                                                                                                 |
| **Database**      | <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />                                                                                                                                                                                                                                                |
| **Security**      | <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jwt&logoColor=white" alt="JWT" /> <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Security" />                                                                                                            |
| **Frontend**      | <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" alt="Thymeleaf" /> <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5" /> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="CSS3" /> |
| **Microservices** | <img src="https://img.shields.io/badge/Spring%20Cloud%20Gateway-00BCD4?style=for-the-badge&logo=spring&logoColor=white" alt="Gateway" /> <img src="https://img.shields.io/badge/Resilience4j-F57C00?style=for-the-badge&logo=java&logoColor=white" alt="Circuit Breaker" />                                                                                       |

---

## 📁 Directory Structure

```
.idea/
    ├── .gitignore
    ├── compiler.xml
    ├── encodings.xml
    ├── jarRepositories.xml
    ├── misc.xml
    └── vcs.xml
api-gateway/
    ├── .mvn/
        └── wrapper/
            └── maven-wrapper.properties
    ├── src/
        ├── main/
            ├── java/
                └── com/
                    └── example/
                        └── api_gateway/
                            ├── config/
                                ├── CircuitBreakerConfig.java
                                └── GatewayConfig.java
                            ├── fallback/
                                └── FallbackController.java
                            └── ApiGatewayApplication.java
            └── resources/
                └── application.properties
        └── test/
            └── java/
                └── com/
                    └── example/
                        └── api_gateway/
                            └── ApiGatewayApplicationTests.java
    ├── .gitattributes
    ├── .gitignore
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml
E-commerceMiniStore/
    ├── .mvn/
        └── wrapper/
            └── maven-wrapper.properties
    ├── src/
        ├── main/
            ├── java/
                └── com/
                    └── example/
                        └── E_commerceMiniStore/
                            ├── config/
                                └── PasswordConfig.java
                            ├── controller/
                                ├── AuthController.java
                                ├── CartItemController.java
                                ├── OrderController.java
                                ├── ProductController.java
                                └── ViewController.java
                            ├── entity/
                                ├── CartItem.java
                                ├── Order.java
                                ├── Product.java
                                ├── Role.java
                                └── User.java
                            ├── repository/
                                ├── CartItemRepository.java
                                ├── OrderRepository.java
                                ├── ProductRepository.java
                                └── UserRepository.java
                            ├── security/
                                ├── JwtAuthenticationFilter.java
                                ├── JwtService.java
                                └── SecurityConfig.java
                            ├── service/
                                ├── CartItemService.java
                                ├── OrderService.java
                                ├── ProductService.java
                                └── UserService.java
                            └── ECommerceMiniStoreApplication.java
            └── resources/
                ├── META-INF/
                    └── additional-spring-configuration-metadata.json
                ├── static/
                    ├── Login.html
                    ├── navbar.js
                    ├── QR.jpeg
                    └── Register.html
                ├── templates/
                    ├── cart.html
                    ├── dashboard.html
                    ├── inventory.html
                    ├── login.html
                    ├── payment.html
                    ├── products.html
                    └── register.html
                └── application.properties
        └── test/
            └── java/
                └── com/
                    └── example/
                        └── E_commerceMiniStore/
                            └── ECommerceMiniStoreApplicationTests.java
    ├── .gitattributes
    ├── .gitignore
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml
service-discovery/
    ├── .mvn/
        └── wrapper/
            └── maven-wrapper.properties
    ├── src/
        ├── main/
            ├── java/
                └── ServiceDiscoveryApplication.java
            └── resources/
                └── application.properties
        └── test/
            └── java/
                └── com/
                    └── example/
                        └── service_discovery/
                            └── ServiceDiscoveryApplicationTests.java
    ├── .gitattributes
    ├── .gitignore
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml
LICENSE
README.md
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
## 🧭 API USAGE FOR TESTING IN POSTMAN

### Auth
- POST `/api/auth/register` – Register new user
- POST `/api/auth/login` – Login and get JWT

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

## 🌐 API Gateway

- **Routing:** All requests go through the API Gateway before reaching microservices
- **Load Balancing:** Can distribute traffic between service instances
- **Fallbacks:** Resilience4j circuit breakers ensure safe fallback responses if a service is down
  
---

## ⚡ Resilience & Fault Tolerance

- **Resilience4j Circuit Breaker:** Protects services from cascading failures
- **Fallback Mechanisms:** If a microservice fails, the gateway provides default/fallback responses
- **Timeouts & Retry Policies:** Ensures API responsiveness even during service downtime

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
