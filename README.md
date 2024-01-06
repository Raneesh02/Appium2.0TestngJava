

## New to Git ?

Install Git : https://git-scm.com/book/en/v2/Getting-Started-Installing-Git

```sh
git clone git@github.com:Raneesh02/Appium2.0TestngJava.git
```


## Use Intellij or Eclipse ?

Directly import the project as a maven project

## Download Maven

Download Maven https://maven.apache.org/download.cgi

```sh
mvn compile
```

If above command is successful then only go forward otherwise do it again

## Execution

After appium setup is done and emulator / simulator is up and running then run


```sh
mvn clean test
```

the tests mentioned in src/test/resources/testngxmls/testsuite.xml will run

Note: Above steps assumes you have watched the course setup sections 