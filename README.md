# Vitals Management

Simple Spring Boot service for managing people and their vitals using Axon Framework (CQRS/event sourcing) and MySQL for read models.

## Features
- Create people
- Create vitals for a person
- Axon aggregates for command handling and events
- JPA entities and repositories for projections

## Tech Stack
- Java 21
- Spring Boot
- Axon Framework
- Spring Data JPA (MySQL)
- Maven

## Prerequisites
- Java 21
- MySQL 8+

## Configuration
Defaults are in `src/main/resources/application.properties`:
- MySQL: `jdbc:mysql://localhost:3306/vitals_management` (user/password `nyasha`)
- Axon Server: disabled by default (`axon.axonserver.enabled=false`)

Update these values to match your environment.

## Running Locally
From the project root:
```bash
./mvnw spring-boot:run
```

## API

### Create person
`POST /person`

Request body:
```json
{
  "name": "Jane Doe",
  "gender": "female",
  "dateOfBirth": "1995-05-15"
}
```

Response: `UUID` of the created person.

### Create vital
`POST /{personId}/vital`

Request body:
```json
{
  "personId": "c0a801b2-1234-5678-9abc-0123456789ab",
  "bloodPressure": "120/80",
  "temperature": 37,
  "oxygenSaturation": 98,
  "respiratoryRate": 16,
  "pulse": 72,
  "heartRate": 72,
  "date": "2024-01-01"
}
```

Response: `String` vital id.

Note: the `personId` path segment is currently not read by the controller, so the request body field is what is used.

## Axon Server (optional)
`docker-compose.yml` includes a commented example for running Axon Server and MySQL. If you want to use Axon Server, enable it in `application.properties` and provide a running server.

## Project Layout
- `src/main/java/com/nyasha/vitals_management/aggregate` — Axon aggregates
- `src/main/java/com/nyasha/vitals_management/commands` — Commands
- `src/main/java/com/nyasha/vitals_management/events` — Events
- `src/main/java/com/nyasha/vitals_management/projection` — Projections
- `src/main/java/com/nyasha/vitals_management/entity` — JPA entities
- `src/main/java/com/nyasha/vitals_management/controller` — REST controllers

## Notes
This project uses event sourcing for command-side logic and JPA for query-side persistence.
