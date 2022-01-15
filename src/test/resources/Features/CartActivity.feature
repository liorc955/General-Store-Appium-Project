Feature: Testing the cart activity app functionality

  Background: 
    Given app is open
    And the app is on the Main Activity
    When user selects the country shop
    And selects a gender
    And enters a name
    And clicks on Lets Shop
    Then the user navigated to Product Activity

  Scenario: Check Added products in cart functionality
    When user adds products to cart
    And user clicks on the cart icon
    Then the app is on the Cart Activity
    And the products appear in the cart including title and price
    And the total purchase amount should be calculated correctly

  Scenario: Check Remove products from cart functionality
    When user adds products to cart
    And user clicks on the cart icon
    Then the app is on the Cart Activity
    When user clicks on the back button
    And the user navigated to Product Activity
    And user removes product from cart
    And user clicks on the cart icon
    Then the product does not appear in the cart

  Scenario: Check checkout functionality
    When user adds product to cart
    And user clicks on the cart icon
    Then the app is on the Cart Activity
    When user clicks on send me discounts check box
    Then the check box checked
    When user clicks on Visit to the website to complete purchase button
    Then the user navigated to the web store

  Scenario: Check terms and conditions button functionality # suppose to failed
    When user adds product to cart
    And user clicks on the cart icon
    Then the app is on the Cart Activity
    When user clicks on Please read out terms of conditions button
    Then popup with terms and conditions should appear