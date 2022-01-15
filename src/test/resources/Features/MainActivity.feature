Feature: Testing the main activity functionality

  Background: 
    Given app is open
    And the app is on the Main Activity
    When user selects the country shop
    And selects a gender

  Scenario: Positive Main activity Flow - successfully login
    And enters a name
    And clicks on Lets Shop
    Then the user navigated to Product Activity

  Scenario: False Main activity Flow - failed login
    And leaves the name field empty
    And clicks on Lets Shop
    Then the user has not navigated to Product Activity
    And please enter your name error message appears.

  Scenario: Enter wrong input at the name field - failed login #suppose to failed
    And types numbers at the name field
    And clicks on Lets Shop
    Then the user has not navigated to Product Activity
    And please enter your name error message appears.