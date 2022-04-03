# Sample General Store App - Automation Project
 



In this project, I took a sample general store app, created a test case matrix, and applied it to automation tests.
I used Java Selenium framework-based JUnit for Test Runner and Cucumber for building scenarios and test case steps.
I also build a sample REST API server to store the JSON test results files in MongoDB database using Express web framework for Node.js.


## Tech

For this project, I used the following maven packages:

- [Junit](https://junit.org/) - Testing framework for Java
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) - Selenium automates browsers
- [Cucumber](https://cucumber.io/) - BDD Testing
- [Appium](https://appium.io/) - an open source test automation framework for use with native, hybrid and mobile web apps.
- [REST Assured](https://rest-assured.io/) - Testing and validating REST services in Java

For the REST API server, I used the following npm package:
- [Express](https://www.npmjs.com/package/express) - web framework for Node.js
- [MongoDB](https://www.npmjs.com/package/mongodb) - MongoDB driver for Node.js.
## Installation

-To run this project:
You will need to install maven project and appium:

https://github.com/appium/appium-desktop/releases/tag/v1.22.0

https://maven.apache.org/install.html

-To run the server:
You will need to install node js and npm:
https://nodejs.org/en/
After that, navigate to the "server" folder and run the command:
```sh
npm start
```
## Running Tests

First, run appium and after that, navigate to the main project folder and run the command:
```sh
mvn test
```

## Attached resources
You can find the test case matrix in the main project folder, The app apk file in the "test\resources\apk" folder, and the JSON tests files result in the "src/test/resources/JSONTestResults" folder.
