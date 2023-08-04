# jwt-authentication-service - Spring Boot REST API service

This service provides Jwt Token Based Authentication of Users.
There are endpoints for login and register of users.
Only registered users logging in can get a access token.
Based on the roles defined, the user can access the resources with granted permission.

There are 5 REST endpoints like Create User, GetAllUsers, GetUserById, UpdateUser, DeleteUser out of which the CreateUser, UpdateUser and DeleteUser can be accessed by ADMIN role User only
while rest of the endpoints are permissible to all by passing the valid access token.

Exception Handling is done through GlobalExceptionHandler class which throws Custom Exceptions defined like 
1)UserNotRegisteredException
2)EmailAlreadyExistsException
3)ResourceNotFoundException
4)UserAPIException
Specific HttpStatusCodes are assigned to each of the above exception.
ErrorDetails class is returned in response to exceptions thrown.

Loggers are written using slf4j library.
Database used is MySQL.
Lombok is configured to remove the boiler plate code.
Swagger is configured to view the documentation of this REST API.

So, this service provides Securing REST APIs (Role Based Access Control) in Spring Security with JWT Authentication Token using SpringBoot
