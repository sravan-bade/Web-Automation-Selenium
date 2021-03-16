# Web-Automation-Selenium

> UI Automation using Cucumber, Java and Selenium

Cucumber Automation Framework

## Chapter 1 : End 2 End Selenium Test

The first step in the journey of Selenium Cucumber Framework is to decide one End 2 End Scenario to automate and start
building up framework components on top of that. In this article we’ll show you how to get the various parts and pieces,
plus write and run one End 2 End test of our Demo Application.

## Chapter 2 : Convert Selenium Test to Cucumber

In this chapter we will use Cucumber BDD Framework to execute test. But to achieve that we need to Convert Selenium Test
into Cucumber BDD Style test and Cucumber understands Gherkin language, read Feature files and execute code written in
Step Definition files with the help of Cucumber Options specified in TestRunner.

## Chapter 3 : Page Object Pattern using Selenium Page Factory

In this chapter we will learn more about Page Object Model Framework which is also known as Page Object Design Pattern
or Page Objects. The main advantage of Page Object Model is that if the UI or any HTML object changes for any page, the
test does not need any fix. Only the code within the page objects will be impacted but it does not have any impact to
the test.

## Chapter 4 : Page Object Manager

This chapter is again based on Page Objects. But in this chapter we will design a Page Object Manager. Duty of the Page
Object Manger is to create the page’s object and also to make sure that the same object should not be created again and
again. But to use single object for all the step definition files.

## Chapter 5 : Config File Reader

This chapter is all about How to Read Configurations from Property File in Selenium Cucumber Framework or in any
framework. It is dangerous to store hard coded values in the project, also it is against the coding principles. And so
far we have been using a lot of hard coded values in our code. With the help of properties file, we will be eliminating
these hard coded value one by one.

## Chapter 6 : File Reader Manager

This chapter is about File Reader Manager as Singleton Design Pattern. Sometimes it’s appropriate to have exactly one
instance of a class. These are accessed by disparate objects throughout a software system, and therefore require a
global point of access. In our case, we have ConfigReaderFile, which should be accessed globally. But later on in this
Selenium Cucumber Framework series we will be having many more file readers. So it is better to have a File Reader
Manager above all the File Readers. And it is better to make the manager class as singleton.

## Chapter 7 : WebDriver Manager

Till now we have been creating driver with in the Step file and we kind of explicitly tell our script to start Chrome
Driver. Which means later if we need to change Chrome to Firefox, we have to go into every test script to change the
same. Which is like bhrrhhhhhhh. On top of it our test is handling the logic of creating WebDriver . This chapter will
focus on creating WebDriver Manager to handle driver creation for the test.

## Chapter 8 : Sharing Test Context with PicoContainer

Scenario in Cucumber is a series of steps which gets executed one after one. Each step in scenario may have some state
which can be required by other step in the scenario. Cucumber supports several Dependency Injection (DI) Containers – it
simply tells a DI container to instantiate your step definition classes and wire them up correctly. One of the supported
DI containers is PicoContainer, which helps in sharing context between steps.

## Chapter 9 : Before and After Hooks

Cucumber supports hooks, which are blocks of code that run before or after each scenario. You can define them anywhere
in your project or step definition layers, using the methods @Before and @After. Cucumber Hooks allows us to better
manage the code workflow and helps us to reduce the code redundancy. We can say that it is an unseen step, which allows
us to perform our scenarios or tests.

## Chapter 10 : JSON Data Reader

The simplest explanation of data-driven testing is this: data that is external to your functional tests is loaded and
used to extend your automated test cases. To be sure that the application works as expected you can alter the test to
accept variables, entering those variables into the data fields. Data driven can be done using Excel, XML, JSON etc but
in this series of Cucumber Automation Framework, we will use JSON to pass data to tests.

## Chapter 11 : Wait Utility for Ajax Wait

We all know that selenium test executions sometimes fails some tests intermittently. When you try to fix the issue and
try to debug the same scenario, it works perfectly fine. Most of the time it happens because of delay in element
loading. In this chapter, we will work towards to get better test results from Selenium test execution. If you want to
build a successful test automation solution all you really need is make it reliable and make it fast.

## Chapter 12 : Sharing Scenario Context

Scenario Context is a class which holds the test data information specifically. It actually use the Test Context to
travel the information between various steps. With in this ScenarioContext class, you can create any number of fields to
store any form of data. It stores the information in the key value pair and again, value can be of any type. It can
store String, Boolean, Integer or may be a Class.

## Chapter 13 : Cucumber Report Plugins

As we know that Cucumber is a BDD framework, it does not have a fancy reporting mechanism. In order to achieve this,
Cucumber itself has provided nice feature to generate reports. These are very basic reports, but using the output of
these reports anybody can build more detailed HTML reports, which is covered in the next chapter of Selenium Cucumber
Framework series. In this chapter, we will be working with Cucumber Options to generate simple reports provided by
Cucumber itself.

## Chapter 14 : Extend Reports with Screenshots

Last chapter of Cucumber Reports we got to know about the Plugins which are provided by Cucumber itself to generate
various kind of reports like HTML, JSON, XML etc. Although those reports are enough to give you the overall execution
results with detailed time logs and other things. But there are many third party plugins also available in market, which
helps you to produce awesome reports which has much more capability to produce test logs and better visual graphics.
This chapter focus on Extent Report plugin to create beautiful and meaningful Cucumber Test’s report.

## Chapter 15 : Run Test from Command Line

For successful implementation of any testing framework, it is mandatory that test cases can be run in multiple ways so
that people with different competency levels can use it how they need to. Because running any test framework from the
Terminal has its own advantages, such as overriding the run configurations mentioned in the code. So, this chapter
focuses on various ways to run the Cucumber tests.
