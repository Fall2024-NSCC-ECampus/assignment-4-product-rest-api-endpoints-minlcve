# Spring Boot Product Management API

This is a simple Spring Boot application for managing products. It provides endpoints to create, read, update, and delete products in an inventory.

## Features:
- Create a product
- Get all products
- Get a product by ID
- Update a product by ID
- Delete a product by ID
- Exception handling for non-existent products

## Setup

1. Clone the repository to your local machine:

2. Navigate to the project directory:

4. Open the project in your IDE (IntelliJ IDEA, Eclipse, etc.)

5. Run the application using your IDE or by running the following command:./mvnw spring-boot:run

6. The application will start and will be accessible at:http://localhost:8080


## API Endpoints

1. **GET** `/api/v1/products` - Get all products
2. **GET** `/api/v1/products/{id}` - Get a product by ID
3. **POST** `/api/v1/products` - Create a new product
4. **PUT** `/api/v1/products/{id}` - Update an existing product by ID
5. **DELETE** `/api/v1/products/{id}` - Delete a product by ID

## Error Handling

- If a product is not found, the API will return a `404 Not Found` with a message: "Product with ID {id} not found".
- Any other server errors will return a `500 Internal Server Error` with a generic message.

## Dependencies
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database



