# ProductInventory
 
 Spring Boot, Spring Data JPA REST CRUD API with Security



## Technologies Used
- Java 17
- Spring Boot
- Spring Data
- PostgreSQL

## Endpoints
<details>
  <summary>List of endpoints:</summary>
<br>
 
GET
/api/products 
Retrieve all products
ROLE=EMPLOYEE

POST
/api/products
Create new product
ROLE=MANAGER

GET
/api/products/{id}
Retrieve product by id
ROLE=EMPLOYEE

PUT
/api/products/{id}
Update product by id
ROLE=MANAGER

DELETE
/api/products/{id}
Delete product by id
ROLE=ADMIN

DELETE
/api/products/
Delete all products!
ROLE=ADMIN

GET
/api/products/available
Retrieve all available products
ROLE=EMPLOYEE

</details>


## Database
![Screenshot of a db er diagram.](/images/db-diagram.png)

## Roles
![Screenshot of a db er diagram.](/images/testroles.png)

## Project Structure
![Screenshot of a project structure.](/images/project-structure.png)
