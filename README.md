# Awesome-Shop AT-Lab 2020
## Setup Awesome-Shop framework
Before running tests should run Selenium Grid with Docker with command:
```
docker-compose -f docker-compose.yml up -d
```

To run testNG tests using Selenium Grid from command line:
```
mvn -Dsurefire.suiteXmlFiles=testng_selenium_grid.xml -Dgrid=true clean test
```

To run Cucumber tests using Selenium Grid from command line:
```
mvn -Dsurefire.suiteXmlFiles=cucumber.xml -Dcucumber.filter.tags=@${cucumber.filter.tags} -Dgrid=true clean test
```

## Default values:
Command line pattern:
```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire.suiteXmlFiles} 
-Dcucumber.filter.tags=@${cucumber.filter.tags} -Dgrid=${grid} clean test
```
### Every first parameter in the list is the default parameter:
* browser
  - chrome
  - firefox
* surefire.suiteXmlFiles
  - testng-smoke.xml
  - testng-all.xml
* cucumber.filter.tags
  - cart
  - login
  - registration
  - search
* grid
  - true
  - false
  