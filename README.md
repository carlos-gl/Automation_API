## About

* **Technologies**
  * Java
  * Junit
  * RestAssured
  * Maven


## Setup

* Clone the repo:
  * git clone https://gitlab.com/carlos-gl/Automation_API.git
  * Open the project in your preferred IDE
  * Install dependencies and run tests:
      * mvn clean install

## Tests
  * Added tests for each endpoint with failure and success scenarios
  * Bugs
    * Endpoint /auth/login returns http status 200 but expected is 201
    * Endpoint /products/add returns http status 200 but expected is 201
