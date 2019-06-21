# Spring Boot Axon CQRS Docker Example
This is a simple example how the Axon Framework can be used with Spring Boot to implement CQRS and Event Sourcing.
It's about peanuts!

## Run it
Just run Docker Compose to build and start the containers.
```
docker-compose up --build
```

## Test it
The scenario is simple: place a bowl on a table, fill it with some peanuts and don't let them go bad.

The command service runs on `http://localhost:8081`, the query service in `http://localhost:8082`.

To put a new bowl on the table just do 
```
POST http://localhost:8081/bowl
```

The result contains a UUID which identifies the bowl for further actions.
Let's fill the bowl with some peanuts  
```
PUT http://localhost:8081/bowl/<uuid>/peanuts {"amount" : "100"}
```

The bowl should contain 100 peanuts now, let's check this
```
GET http://localhost:8082/bowl/<uuid>/peanuts
```

Yummy! We should be able to take some peanuts out of the bowl now
```
DELETE http://localhost:8081/bowl/<uuid>/peanuts {"amount" : "10"}
```

Let's see how many peanuts are left
```
GET http://localhost:8082/bowl/<uuid>/peanuts
```
Oh, only 90...

Enjoy your meal!
 
