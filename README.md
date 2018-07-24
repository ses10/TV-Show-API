# Running the API

After cloning the project, you can start the service by running the jar inside the target/ folder. Project runs with Java 8

Port will be 8080

# Endpoints
GET: localhost:8080/shows\
GET: localhost:8080/shows?page=1&size=2

POST: localhost:8080/shows
\{
    "title": "a show",
    "description": "a show about to be created",
    "duration": 30,
    "originalAirDate": "1/1/2018",
    "rating": 3,
    "keywords": "test,word,something"
}

PUT: localhost:8080/shows/{id}
\{
    "title": "a show",
    "description": "a show being updated",
    "duration": 30,
    "originalAirDate": "1/1/2018",
    "rating": 3,
    "keywords": "test,word,something"
}

# Checking the database
localhost:8080/h2-console

On the login enter the following:
\JDBC URL: jdbc:h2:mem:showdb
\User Name: test
\Password: test

All other settings can be left as is.