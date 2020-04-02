## Api tests for Socks Shop

### Set up project for testing:
* https://github.com/microservices-demo/microservices-demo
  
* `Install docker`
* `Install docker compose`
*`git clone https://github.com/microservices-demo/microservices-demo`
* `cd microservices-demo`
* `docker-compose -f deploy/docker-compose/docker-compose.yml up -d`
  
##### You can deploy the application on the local machine or on any cloud provider (base API URL will be IP address)
  
  
### Read API specification:
`https://microservices-demo.github.io/api/index?url=https://raw.githubusercontent.com/microservices-de mo/user/master/apispec/user.json`
  
  
### Write 2 positive and 4 negative tests for this endpoints:
`GET /login`,
`POST /register`

##### Use Java, Rest Assured (or similar), Maven/Gradle, TestNG 

#### Tests

```properties
baseUrl=http://localhost:80
```

To run tests use command: `mvn test`

Allure results will be generated in `target/allure-results`

To generate report run `allure cli command`:

```shell script
allure -c target/allure-results -o public/
```

Report will be generated in folder `public`, in attach will be request and response for each test