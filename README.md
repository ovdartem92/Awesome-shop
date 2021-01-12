# Awesome-Shop AT-Lab 2020
## Setup Awesome-Shop framework
Before running tests should run Selenium Grid with Docker with command:
```
docker-compose -f docker-compose.yml up -d
```

To run Framework project using Selenium Grid from command line:
```
mvn -Dsurefire.suiteXmlFiles=testng_docker.xml clean test 
```

To run Framework project from command line:
```
mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=testng-smoke.xml clean test
```

## Default values:
Command line pattern:
```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire.suiteXmlFiles} clean test
```
### Every first parameter in the list is the default parameter:
* browser
  - chrome
  - firefox
* surefire.suiteXmlFiles
  - testng-smoke.xml
  - testng-all.xml 