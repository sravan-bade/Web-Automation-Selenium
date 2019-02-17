Feature: Feature Test1
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario: Scenario from Feature Test 1
    Given user is on Home Page
    When he search for "dress"

  #And choose to buy the first item
  #And moves to checkout from mini cart
  #And enter personal details on checkout page
  #And select same delivery address
  #And select payment method as "check" payment
  #And place the order
  Scenario: Validate the download functionality
    Given user is on Sample videos page
    When he download the file
    Then file should be downloaded

  Scenario: Validate the alert functionality
    Given user is on Demoguru99 delete customer page
    When he tries to delete the customer id "12345"
    And cancel the alert
    And modify the customer id to "123"
    And accept the alert
    Then confirmation alert should be displayed

  Scenario: Validate the popup functionality
    
