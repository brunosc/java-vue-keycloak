# java-vue-keycloak

It is a testing VueJS application consuming an API in Java (Spring Boot or Quarkus) protected by Keycloak

## Frontend

Go to the frontend folder, install the dependencies for the first time and run the development server

```bash
cd frontend
npm install
npm run serve
```

## Backend

You can choose between Spring Boot and Quarkus. Both are running on 8001.

### Spring Boot

```bash
cd spring-boot-api
./mvnw spring-boot:run
```

### Quarkus

```bash
cd quarkus-api
./mvnw compile quarkus:dev
```

## Keycloak

There is an existing Keycloak setup in the `keycloak-realm.json` with these configurations:

```
Admin:
    username=keycloak
    password=keycloak

Realm:
    Name=java-vue-keycloak
    User Registration=true
    Email as username=true
    
Clients:
    frontend
        rootUrl=http://localhost:8080
        accessType=public
        webOrigins=+
    backend
        rootUrl=http://localhost:8001
        accessType=bearer-only

Roles:
    user (it's default for new users)
    admin
```

How to run

```bash
docker-compose up -d
```