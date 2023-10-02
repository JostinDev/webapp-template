# Modern enterprise web application with identity management

## Features

- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway) used to proxy the Frontend and the Backend. Single entry point of the application.
- Highly modular [Auth0](https://auth0.com/) authentication system. Login with credentials, socials or password less solutions.
- Interchangeable Frontend. The template uses [NextJS](https://nextjs.org/), feel free to use your favorite framework. There is no special configuration required.
- Frontend live reload while being proxied by the Gateway.
- Frontend ready to be styled with [Tailwind CSS](https://tailwindcss.com/).
- Interchangeable Backend. The template uses [Spring Boot](https://spring.io/), feel free to use your favorite framework. Some configuration is required.
- No JWT exchange between the Frontend and the Gateway. The authentication is managed by the Gateway.
- Interchangeable Database. The template uses [MySQL](https://www.mysql.com/).
- Login and Logout
- Create a user in the Database on his first login.

## Run the Application
Steps and configurations needed to start the application :

### Create an Auth0 account
Create a free [Auth0](https://auth0.com/) account and configure your desired authentication factors.
You'll need to get the following data : 
- client-id
- client-secret
- audience
- issuer-uri


### Gateway
Configure the following environment variables
- AUTH0_CLIENT_ID 
- AUTH0_CLIENT_SECRET
- AUTH0_AUDIENCE - ex : https://your-app.eu.auth0.com/api/v2/
- AUTH0_ISSUER_URI - ex : https://your-app.eu.auth0.com/


**Run the Gateway** :
- Create a Spring Boot configuration in your favorite IDE
- Or right click and run AppGatewayApplication


### Backend
Configure the following environment variables
- AUTH0_ISSUER_URI : https://your-app.eu.auth0.com/
- DB_HOST - ex : localhost:3306
- DB_NAME

**Run the Backend** :

- Create a Spring Boot configuration in your favorite IDE
- Or right click and run AppBackendApplication


### Frontend
Install the dependencies : 
`npm install`

Run the Frontend : 
`npm run dev`

### Open the app
Finally, open [http://localhost:8080](http://localhost:8081) with your browser to see the result.
