# Spring Boot Testing Demo

A hands-on project built specifically to practice and understand unit testing 
in Spring Boot — covering the service, controller, and repository layers.

## What this project covers

- Unit testing the service layer with JUnit 5 + Mockito
- Mocking dependencies with @Mock and @InjectMocks
- Verifying method calls with verify()
- Testing exception scenarios with assertThrows
- Controller testing with @WebMvcTest and MockMvc (in progress)
- Repository slice testing with @DataJpaTest (in progress)

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 (in-memory database)
- JUnit 5
- Mockito
- Lombok


## What I learned

Writing tests before I fully understood the code forced me to actually 
understand what each layer does and why dependencies need to be mocked. 
The biggest insight — unit tests don't touch the database at all.

## How to run tests

mvn test
