# Spring Boot with Angular Starter

[![Build Status](https://circleci.com/gh/ssherwood/spring-boot-ng/tree/master.svg?style=shield)](https://circleci.com/gh/ssherwood/spring-boot-ng)
[![License](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/MIT)

Sample project using [Spring Boot](https://projects.spring.io/spring-boot/) to
serve an [Angular](https://angular.io/) frontend.

## Overview

This project is a simple starter using Spring Boot with Angular.  The
project relies on a basic [Maven](https://maven.apache.org/) multi module
layout to package both the client and server assets independently (this can
easily be done with Gradle if desired).

The Angular client code was initially generated using the [Angular CLI](https://cli.angular.io/)
and can largely be treated as a standard CLI project when developing locally
(meaning using the CLI).  Running the client via `ng serve` is the expected way
of working when doing any frontend development.

When running the frontend in node, the [proxy.conf.json](client/proxy.conf.json)
configuration is used to route backend calls through to the Spring Boot
application running on [8080](http://localhost:8080) - primarily to avoid any
[CORS](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing) issues.
This practice can also reduce compile "lag" when developing both frontend and
backend together.

To make this work seamlessly, the client pom uses the [frontend maven plugin](https://github.com/eirslett/frontend-maven-plugin)
to attach the Angular build to the overall Maven lifecycle.  In effect, this
lets Maven package the resulting `dist` folder into the client `jar` as static
content.  In addition to the compile, `lint` and `e2e` scripts are attached to the
Maven `compile` and `integration-test` phases respectively.

When the project is packaged, the resulting Spring Boot executable ['fat' JAR](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-build.html#howto-create-an-executable-jar-with-maven)
will contain the Angular bundles and act as if they had been copied into the
`src/main/resources/static` folder.  The client jar may also be used to
transfer and unpack the static bundles to edge cache/CDN (as desired).

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
- Add support for Bootstrap
- Add a sample frontend -> backend call
- Add Spring Data example
- Add Spring Security using OAuth2
- 