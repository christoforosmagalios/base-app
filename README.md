# base-app

![Travis (.org)](https://img.shields.io/travis/christoforosmagalios/base-app?logo=travis)

## About
This is a boilerplate/template project of an application with Spring Boot and Angular.
It demonstrates a basic User CRUD functionality.

## Screens
(1) Users list
![1](https://user-images.githubusercontent.com/8016969/95678980-a2606580-0bd8-11eb-807b-a1d0d61037a4.png)
(2) Create/Update User
![2](https://user-images.githubusercontent.com/8016969/95678996-bc9a4380-0bd8-11eb-973e-bbfe8c94f444.png)

## Tech
![Untitled-1](https://user-images.githubusercontent.com/8016969/95660929-c1f18280-0b33-11eb-857f-1121feb37277.png)

## Prerequisites
- Java 11
- Maven 3.5.3
- Node v12.16.0
- npm 6.13.4
- Angular-cli 9.0.0
- Docker / Docker Compose

## Development environment setup

##### Database
In order to boot up a MariaDB database server for development, go to the root folder and execute:
```
docker-compose -f docker-compose-dev.yml build && docker-compose -f docker-compose-dev.yml up -d
```
A MariaDB container will be created with username/password `root/root` and port 3307.

##### Frontend
In order to start the frontend application go to the root folder of `base-app-ui` and execute:
```
ng serve
```

##### Backend
In order to start the backend application go to the root folder of `base-app-server` and execute:
```
mvn spring-boot:run
```

##### Browser
Open http://localhost:4200 in a browser.

## Production environment setup
To bootstrap your production environment, go to the root folder and execute:
```
docker-compose build && docker-compose up
```
Open http://localhost in a browser.

## Code Quality
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=alert_status)](https://sonarcloud.io/dashboard?id=Base-App) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=Base-App) [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=Base-App)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=bugs)](https://sonarcloud.io/dashboard?id=Base-App) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=code_smells)](https://sonarcloud.io/dashboard?id=Base-App) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=Base-App) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=Base-App) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Base-App&metric=coverage)](https://sonarcloud.io/dashboard?id=Base-App)

