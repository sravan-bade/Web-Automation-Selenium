# Web-Automation-Selenium
> UI Automation using Cucumber, Java and Selenium

## Design WebDriver Manager

Why do we need WebDriver Manager or some called it as WebDriver Factory or Browser Factory?
Till now we have been creating driver with in the Step file and we kind of explicitly tell our script to start Chrome Driver. Which means later if we need to change Chrome to Firefox, we have to go into every test script to change the same. Which is like bhrrhhhhhhh. On top of it our test is handling the logic of creating WebDriver . This is as equal as you visit some restaurant and you are cooking your meal by yourself instead of enjoying eating your meal. Test should not be worried about how to start the driver. Test should just need a driver to execute the script. Like you in restaurant just know what to eat. So lets bring the waiter ops I mean to say WebDriver Manager in between to handle this task for us. 
