1 Name of Project Muzix Application

2 Objective/Vision This is an online application that helps users manage music

listed on Music Database (https://www.last.fm).
Using this app, a user should be able to search and
manage music.
3 Users of the system All Internet users

4 Functional
Requirements 1. Application should allow all the users to perform the

following activities:

a. Save track information such as trackId,
trackName, comments of the track.
b. Display saved track.
c. Update comments of saved track.
d. Remove track

5 Non-Functional
Requirements

1. App should be accessible from any location with access
to the Internet.
2. App should be responsive to display consistently across
multiple device screens.
3. App should have an intuitive UI that can be operated by
novice expert Internet users.
================================

Tasks to be Done Post Demo
1. Complete all the endpoints for CRUD operations on Muzix
2. Use h2-console to view in-memory data
3. Add an endpoint to search trackByName. Understand @Query and parameter passing to
@Query
4. Generate API documentation using Swagger 2

5. Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a
com.stack....exceptions package. Perform appropriate exception handling and propagation
back.
6. Running Logic on Startup in Spring. Create seed data to pre-fill the database with movie
information whenever the application starts. Use both approaches:
Approach 1: ApplicationListener<ContextRefreshedEvent>
Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)

7.Global exception using Controller advice
8. Remove all hardcoded data from the application code to application.properties
a) by using @Value.
b) by using @PropertySource
c) by using Environment
d) by using @ConfigurationProperties
(https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/
Environment.html)
9. Add @Lombok
(https://drive.google.com/file/d/1QQpEQZbDD9pmW2qrhYsx5N9XYQ5bJ5dM/view)
10. Create another service implementation TrackDummyServiceImpl. Use @Primary and
@Qualifier annotations to specify which implementation to use.
11. Use @Profile to run the application with the existing service implementation, and the new
TrackDummyServiceImpl implementation.

12. Swap in-memory H2 database with MySQL.
13. Create two additional properties file application-dev.properties that contains configuration for
H2 and application-prod.properties that contains configurations for MySQL.