# Spring Boot with Angular Starter

Sample project using [Spring Boot](https://projects.spring.io/spring-boot/) to
serve an [Angular](https://angular.io/) frontend.

## Overview

This project is a simple starter using Spring Boot and Angular.  The project
relies on a Maven "multi module" layout to package both the client and server
assets independently.

The client code was generated using the [Angular CLI](https://cli.angular.io/)
and can largely be treated as a standard CLI project when developing locally
(meaning using the appropriate CLI and Node tooling).  Running the client via
`ng serve` is expected when doing any frontend development.

When running in this mode, the `proxy.conf.json` configuration is used to route
any backend calls through to the Spring Boot application running on port :8080
to avoid [CORS](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
issues.  This practice also helps reduce "lag" when developing both frontend
and backend together.

Additionally, the client pom uses the [frontend maven plugin](https://github.com/eirslett/frontend-maven-plugin)
to attach the Angular build to the overall Maven lifecycle.  In effect, this
lets Maven package the resulting `dist` folder into the `jar` as static
content.  In addition to compile, `lint` and `e2e` tests are attached to the
Maven `compile` and `integration-test` phases respectively.

Once the project is fully built, the Spring Boot "fat jar" will contain the
Angular static resources and act as if they had been copied into the
`src/main/resources/static` folder.  The resulting client jar may also be used
to deploy the static bundles to edge server cache/CDN as desired.

## Getting Started

- TODO

## Common Problems

### When I run the Spring Boot application in the IDE and visit http://localhost:8080, there is no web content.

When running the application via Spring Boot within the IDE this issue can
occur when there is no `jar` in the client's `target` folder.  The IDE needs
this file in order to add it to the application classpath.  This problem is
frequently the result of a manual `mvn clean`.

To fix this issue, perform a `mvn package` on the client and restart the
application.  NOTE: if you run the frontend via node and use http://localhost:4200
this problem will not occur.

## TODO

- Add UI routing
- Add Spring Data example
- Add Spring Security (OAuth2)
- 