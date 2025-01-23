# Kata - Spring Boot with MySQL Project

### The kata is a Spring Boot application integrated with MySQL for database operations. The MySQL database is hosted in a Docker container, and the application is built using Java 21.

## Prerequisites
Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 21
- Apache Maven 3.6.x or higher
- Docker and Docker Compose
- IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code)

## Setup

``` bash
git clone git@github.com:mouhsine-hamarrass/kata.git
cd kata
```

### Build the application
``` bash
mvn clean install
```
### Start the application
   You can start the application alongside with the database with one docker command:

``` bash
docker-compose up -d
```

This will start a MySQL container named db and expose it on port 3306 and the application exposed in 8080.

### How to use the application 
``` bash
curl -X POST http://localhost:8080/api/delivery \
-H "Content-Type: application/json" \
-d '{
"deliveryMode": "DELIVERY",
"slotStart": "2025-01-22T10:30:00",
"slotEnd": "2025-01-22T12:30:00"
}'
```
