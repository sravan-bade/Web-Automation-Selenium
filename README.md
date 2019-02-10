# Web-Automation-Selenium
> UI Automation using Cucumber, Java and Selenium

We all know that selenium test executions sometimes fails some tests intermittently. When you try to fix the issue and try to debug the same scenario, it works perfectly fine. Most of the time it happens because of delay in element loading. Means Selenium is try to perform any action on the element but it is not yet rendered in the DOM.

I know you must be thinking that, then in this case Selenium already has a feature which is called as Implicit-wait, which always wait for element to load and wait for specified time. Then why do we have such problems in Selenium execution. The answer is because of Ajax Calls or JQuery. 

 
## What is Ajax?
AJAX is a technique to do an XMLHttpRequest (out of band Http request) from a web page to the server and send/retrieve data to be used on the web page. AJAX stands for Asynchronous Javascript And XML.

Means: Ajax is way for the client-side browser to communicate with the server (for example: retrieve data from a database) without having to perform a page refresh.

## What is JQuery?
JQuery (website) is a javascript framework that makes working with the DOM easier by building lots of high level functionality that can be used to search and interact with the DOM. Part of the functionality of jQuery implements a high-level interface to do AJAX requests. 

JQuery is a lightweight client side scripting library while AJAX is a combination of technologies used to provide asynchronous data transfer
JQuery and AJAX are often used in conjunction with each other
JQuery is primarily used to modify data on the screen dynamically and it uses AJAX to retrieve data that it needs without changing the current state of the displayed page
 

## How to check Ajax/JQuery on the Web Page?
This is very important to check that what is actually working on the application for which the tests are written. One easy way is to talk to UI Developers and understand the technology used for developing the web pages. It will always give you an fair idea what you will be dealing with on automation. Second way is to go and find by your self.

In the below example, I will use Chrome Browser and  shop.demo.com website to demonstrate the Ajax calls. To do the same on your end, please follow the steps below.

1. Go to the website shop.demoqa.com, add any product to basket/bag and reach to checkout page or the final page where you enter personal details and payment details.

2. Press F12 to open developer mode in chrome and select Console tab from the menu.

3. Now type jQuery.active in the console editor and press Enter.  

Note: You would see that it has returned the value 0. Zero means that at present no ajax or jquery is running on the page.

4. Lets see if any Ajax actually works on the page or not. Scroll to at the bottom of the page where there is a radio button SHIP TO A DIFFERENT ADDRESS?.

5. Select Network tab in the Chrome Developer window and click on the last drop down from the right to select the speed of the connection. Select Slow 3G.

Note: Select Slow 3G would reduce the connection speed and gives you enough time to check things on the page. Because sometimes Ajax calls happen at the speed of the flash.

6. Come back to Console tab and type jQuery.active, but do not press Enter. Now the next steps is to be done very swiftly, as you wont get much time to do it. You need to click on the check box and immediately come back to Console editor and hit Enter to jQuery.active statement. 

Note: You would notice value 1 this time. One means the ajax is still active on the page.

Yeah cool, isn’t it a nice way to find things. Good, now we move forward to catch Ajax calls using JavaScriptExecutor.


## Handle Ajax call Using JavaScriptExecutor in Selenium?
Our test will fail tentatively due to these situations. Hence its always wise idea to wait for Ajax call to complete. This can be done using our JavaScriptExecutor interface. The idea is simple, if all the JQuery executions are completed, then it will return jQuery.active == 0 which we can use in our Wait.Until method to wait till the script return as true.

