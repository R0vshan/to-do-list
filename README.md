# To-Do List CRUD Application

## Description
A Spring Boot application with PostgreSQL, Redis caching, and notifications via Telegram. Supports JWT-based authentication and role-based access control.

## Features
- User management with role-based access control.
- To-Do task management with CRUD operations.
- Time slot scheduling to avoid collisions.
- Redis caching for improved performance.
- Notifications via Telegram API.
- JWT-based authentication with access and refresh tokens.
- Dockerized for easy deployment.

## Technologies Used
- Spring Boot
- PostgreSQL
- Redis
- Telegram API
- JWT
- Docker

## Setup Instructions

1. **Clone the Repository:**
    ```sh
    git clone <repository_url>
    ```

2. **Navigate to Project Directory:**
    ```sh
    cd to-do-list-crud
    ```

3. **Build and Run the Application with Docker:**
    ```sh
    docker-compose up --build
    ```

4. **Access the Application:**
    - API Documentation: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    - PostgreSQL: [http://localhost:5432](http://localhost:5432)
    - Redis: [http://localhost:6379](http://localhost:6379)

## API Endpoints

### User Management:
- **POST** `/api/users/register`
- **POST** `/api/users/login`
- **POST** `/api/users/logout`
- **POST** `/api/users/token/refresh`
- **GET** `/api/users/profile`
- **PUT** `/api/users/profile`

### To-Do Task Management:
- **POST** `/api/todos`
- **GET** `/api/todos`
- **GET** `/api/todos/{id}`
- **PUT** `/api/todos/{id}`
- **DELETE** `/api/todos/{id}`

## Testing

- Run unit tests with the following command:
    ```sh
    ./mvnw test
    ```
