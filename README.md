# ** car leasing Microservice
This is Leasing car Spring boot microservice that allows basic management of a leasing a car and contract.
it provides a REST API that CRUD operations related to leasing a car.

## Technologies Used
* Spring boot
* Spring Data JPA
* mysql Database and H2 for quick setup and run 
* Docker
* Lombok
* Java 17
* Gradle

## Running the Microservice using Maven spring boot plugin

``` mvn spring-boot:run ```

## Running the Microservice as docker container
- Step 1. Build the runnable jar  
  ``` ./gradlew build ```
- Step 2. run docker container from project root  
  ```  docker-compose up ```

## Testing the Microservice using POSTMAN
postman collection added in root directory to perform testing API  
``Postman collection file to test and try API xyz``
## API Reference
The following endpoints are available in this microservice:

```POST v1/api/customers``` Add a new customer.  
Example request
```json
{
  "firstName": "Yogi",
  "lastName": "Singh",
  "birthDate": "2023-05-03"
}
```  
Example response
```json
{
  "id": 1,
  "firstName": "Yogi",
  "lastName": "Singh",
  "birthDate": "2023-05-03"
}
```

```GET v1/api/customers/{id}```
Get the customer with id
```DELETE v1/api/customers/{id}```
Delete the customer for given id
```PUT v1/api/customers/{id}```
update the customer for given id
```PUT v1/api/customers/{id}```
update the customer for given id