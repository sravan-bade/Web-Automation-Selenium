# Web-Automation-Selenium
> UI Automation using Cucumber, Java and Selenium

## Data Driven Testing using Json with Cucumber

What is Data Driven Testing?
The simplest explanation of data-driven testing is this: data that is external to your functional tests is loaded and used to extend your automated test cases. One of the best examples is that of a customer order form. To use data-driven testing in this scenario, you might record a single automated test, entering values into the various fields. After you have recorded the automated test, it only contains values that you entered during the recording. Most likely, data you have specified does not cause errors in the application, but other data may cause them. To be sure that the application works as expected you can alter the test to accept variables, entering those variables into the data fields. Thus, data-driven testing allows you to run this test each time you want to add an order record, passing in a new set of data each time.

## Why JSON over Excel?
In most of our tutorials on Data Driven Testing, we have used Excel – Apache POI. But there are other medium as well to store data in to files such as csv, xml, json, text file etc. Excel is good to manage data and to use but it comes with its own limitations. Like MS Office needs to be installed on the system where the tests are being executed. This is a big limitation on its own, as the test servers has never bound to have have such dependencies. If test are meant to run on Mac, then again there is different problem. 

