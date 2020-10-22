# SkyScanner lab2020
## Setup SkyScanner framework
To run Framework project from command line:
```
mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\main\resources\testng-smoke.xml -Denvironment=environment_qa -Dtimeout=timeout clean test
```

## Default values:
Command line pattern:
```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${file.xml} -Denvironment=${environment} -Dtimeout=${timeout} clean test
```
### Every first parameter in the list is the default parameter:
* browser
    - chrome 
    - firefox
    - edge
    - opera
* surefire.suiteXmlFiles
    - src\main\resources\testng-smoke.xml 
    - src\main\resources\testng-parallel.xml
    - src\main\resources\testng-all.xml
* environment
    - environment_qa 
* timeout
    - timeout 
    
### Property file values:
* Test data of mail and password for the page login [environment_qa]:
    - testData.email = kebikov1995@mail.ru
    - testData.password= 12344321Qwerty
* Waiting time variables [timeout]:
    - timeout.short = 1 [sec]
    - timeout.long = 15 [sec]
    - timeout.default = 5 [sec]