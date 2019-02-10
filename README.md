# Web-Automation-Selenium
> UI Automation using Cucumber, Java and Selenium

##Read Configurations from Property File
It is dangerous to store hard coded values in the project, also it is against the coding principles. And so far we have been using a lot of hard coded values in our code. With the help of properties file, we will be eliminating these hard coded value one by one.

 
###What is a Property file in Java
.properties files are mainly used in Java programs to maintain project configuration data, database config or project settings etc. Each parameter in properties file are stored as a pair of strings, in key-value pair format, where each key is on one line. You can easily read properties from some file using object of type Properties. This is a utility provided by Java itself.

java.util.Properties;


###Advantages of Property file in Java
If any information is changed from the properties file, you don’t need to recompile the java class. In other words, the advantage of using properties file is we can configure things which are prone to change over a period of time without need of changing anything in code.

For E.g. We keep application Url in property file, so in case you want to run test from on other test environment, just change the Url in property file and that’s it. You do not require to build the whole project again.