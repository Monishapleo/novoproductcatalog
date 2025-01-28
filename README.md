# novoproductcatalog
# Product Management API

## Description

This is a RESTful API for managing products. The API allows you to perform CRUD operations on products. It is built using **Spring Boot** and **MySQL**. The documentation is generated using **Spring REST Docs**.
## Project Setup

### Prerequisites

- Java 11 or later
- Maven 
- MySQL Database

### Installation

1. Clone the repository: https://github.com/Monishapleo/novoproductcatalog.git
2. Configure your MySQL database and set up the `application.properties` with your credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/productdb
    spring.datasource.username=root
    spring.datasource.password=yourpassword
3. Build the project:
  mvn clean install
4. Run the application:
   mvn spring-boot:run
5.Test Api: post-man

## API Usage

### Endpoints
#####USER Endpoints:
POST users/createUser
KEY          VALUE
name         your name
password     password
role         choose role ADMIN/USER

GET users/getAll


###PRODUCT Endpoints
#### 1. Get All Products
```http
GET /products/getAllProducts


GET /products/getProductById/{id}

POST /products/createProduct
Content-Type: application/json

{
    "name": "Innova ",
    "description": "Series 13",
    "price": 10000.0,
    "createdDate": "2025-01-27T00:00:00.000+00:00"
}


PUT /products/updateProduct/{id}
Content-Type: application/json

{
  "name": "IPHONE ",
    "description": "Series 13",
    "price": 10000.0,
    "createdDate": "2025-01-27T00:00:00.000+00:00"
}

DELETE /products/deleteProduct/{id}

