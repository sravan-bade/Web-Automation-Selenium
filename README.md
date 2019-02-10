# Web-Automation-Selenium
> UI Automation using Cucumber, Java and Selenium

## File Reader Manager as Singleton Design Pattern

Sometimes it’s appropriate to have exactly one instance of a class. These are accessed by disparate objects throughout a software system, and therefore require a global point of access. In our case, we have ConfigReaderFile, which should be accessed globally. But later on in this Selenium Cucumber Framework series we will be having many more file readers. So it is better to have a File Reader Manager above all the File Readers. And it is better to make the manager class as singleton.  

 
### What is Singleton Design Patter?
The Singleton’s purpose is to control object creation, limiting the number of objects to only one. Since there is only one Singleton instance, any instance fields of a Singleton will occur only once per class, just like static fields.

 
### How to implement Singleton Pattern?
To implement Singleton pattern, we have different approaches but all of them have following common concepts.

Private constructor to restrict instantiation of the class from other classes.
Private static variable of the same class that is the only instance of the class.
Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.