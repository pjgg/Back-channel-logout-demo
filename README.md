# Front channel logout demo

## Demo Requirements

- Java 11+
- Keycloak ([download](https://github.com/keycloak/keycloak/releases/download/20.0.0/keycloak-20.0.0.zip))
- Maven 3.8.4
- Quarkus 2.13+
- Git cli 2.38+

## Project Folder structure

[Github project ref](https://github.com/pjgg/Back-channel-logout-demo)

- misc/front-channel-realm.json: realm configuration that you should set up on your Keycloak instance
- misc/pfmninza-keycloak-theme-0.0.1.jar: custom Keycloak login theme that you should set up in `keycloak-20.0.0/providers` folder
- mobile-app-demo: represents a mobile application 
  - start: `mvn quarkus:dev -f mobile-app-demo`
  - endpoints:
    - http://localhost:8280/code-flow/
    - http://localhost:8280/code-flow/logout
- web-app-demo: represents a web application
  - start: `mvn quarkus:dev -f web-app-demo`
  - endpoints:
    - http://localhost:8180/code-flow/
    - http://localhost:8180/code-flow/logout
