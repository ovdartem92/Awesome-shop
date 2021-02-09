# Awesome-Shop AT-Lab 2020

## Setup Awesome-Shop framework

### Launch auto tests using Selenium Grid

Before running tests should run Selenium Grid with Docker with command:

```
docker-compose -f docker-compose.yml up -d
```

To run **testNG** tests using Selenium Grid from command line:

```
mvn -Dsurefire.suiteXmlFiles=testng.xml -Dgrid=true clean test
```

To run **Cucumber** tests using Selenium Grid from command line:

```
mvn -Dsurefire.suiteXmlFiles=cucumber.xml -Dcucumber.filter.tags="@ui and @${cucumber.filter.tags}" -Ddataproviderthreadcount=${threadcount} -Dgrid=true clean test
```

### Launch auto tests in parallel (without Selenium Grid)

To run **testNG** tests in parallel from command line:

```
mvn -Dsurefire.suiteXmlFiles=testng.xml clean test
```

To run **Cucumber** tests in parallel from command line:

```
mvn -Dsurefire.suiteXmlFiles=cucumber.xml -Dcucumber.filter.tags="@ui and @${cucumber.filter.tags}" -Ddataproviderthreadcount=${threadcount} clean test
```

**Api** tests should run in one thread:
```
mvn -Dsurefire.suiteXmlFiles=cucumber.xml -Dcucumber.filter.tags="@api and @${cucumber.filter.tags}" -Ddataproviderthreadcount=1 clean test
```

## Default values:

Command line pattern:

* **testNG**

```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire.suiteXmlFiles} -Dgrid=${grid} clean test
```

* **cucumber**

```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire.suiteXmlFiles} 
-Dcucumber.filter.tags=@${cucumber.filter.tags} -Ddataproviderthreadcount=${threadcount} -Dgrid=${grid} clean test
```

### Every first parameter in the list is the default parameter:

* browser
  - chrome
  - firefox
* surefire.suiteXmlFiles
  - testng.xml
  - cucumber.xml
* grid
  - false
  - true
* cucumber.filter.tags (Cucumber only)
  - all
  - cart
  - login
  - registration
  - search
* dataproviderthreadcount (Cucumber only)
  - 10
  