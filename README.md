# SkyScanner lab2020
## Setup SkyScanner framework
To run Framework project from command line:
```
mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\main\resources\testng-smoke.xml -Denvironment=environment_qa clean test
```

## Default values:
Command line pattern:
```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${file.xml} -Denvironment=${environment} clean test
```
### Every first parameter in the list is the default parameter:
* browser
    - chrome 
    - firefox
    - edge
    - opera
* surefire.suiteXmlFiles
    - src\main\resources\testng-smoke.xml 
* environment
    - environment_qa 
    
### Property file values:
* Test data of mail and password for the pages.page login [environment_qa]:
    - testData.email = kebikov1995@mail.ru
    - testData.password= 12344321Qwerty