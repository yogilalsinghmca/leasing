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

## To run Microservice on Local host
- Make sure docker is installed, up and running

## Run the Microservice as docker containers
- Step 1. Build the jar for Dockerfile  
* `./gradlew clean build`
- Step 2. run containers(App and Database) from project root  
* `docker-compose up`
* 
## Running the Microservice using Gradle spring boot plugin

- Step 1. Build the runnable jar
* `./gradlew clean build`
- Step 2. start the mysql database container from project root
*  `./docker-compose up lease-db`
- Step 2. run  the spring boot service from project root in another terminal
* `./gradlew bootRun`

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