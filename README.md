# TodoSpringRest
A Simple Backend for a Todo App using MySql

## How to Run

Clone the repository, create a schema in MySQL

```sql
CREATE SCHEMA `todocrud` ;
```

Create an application.properties file in /src/main/resources

```
spring.application.name=RestfulAPI

spring.datasource.url=jdbc:mysql://localhost:3306/todocrud?useSSL=false
spring.datasource.username=YOURMYSQLUSERNAME
spring.datasource.password=YOUMYSQLPASSWORD
spring.jpa.hibernate.ddl-auto=update
```
## Test

In Postman, Thunder Client or your Rest API Client generate the requests

### Get all

```
http://localhost:8080/api/tasks/
```
### Get

```
http://localhost:8080/api/tasks/{id}
```
Ex:
```
http://localhost:8080/api/tasks/5
```
### Post
```
http://localhost:8080/api/tasks/
```
- Body

```json
{
  "title": "Test de la API",
  "description": "Check",
  "status": false
}
```

### Put

```
http://localhost:8080/api/tasks/{id}
```
Ex:
```
http://localhost:8080/api/tasks/5
```
- Body

```json
{
  "title": "Test de la API",
  "description": "Check",
  "status": false
}
```
### Delete

```
http://localhost:8080/api/tasks/2
```
