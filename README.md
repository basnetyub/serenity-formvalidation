# QA Test For GetYourLawyer
The project aims to do BDD end to end testing on Calculate the number of trees application.
## Dependency
JDK 17

Maven 3.5.0 or Above
## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```

##Report Generation
The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
The WebDriver configuration is managed entirely from this file, `src/test/resources/serenity.conf`

Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```
$ mvn clean verify -Denvironment=staging
```

