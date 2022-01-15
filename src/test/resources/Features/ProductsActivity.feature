Feature: Testing the Products activity functionality

  Background: 
    Given app is open
    And the app is on the Main Activity
    When user selects the country shop
    And selects a gender
    And enters a name
    And clicks on Lets Shop
    Then the user navigated to Product Activity

  Scenario: Check add product functionality
    When user adds product to cart
    Then the number on the cart icon should increase by one
    And the ADDED TO CART button appears

  Scenario: Check remove product functionality
    When user adds product to cart
    And user removes product from cart
    Then the number on the cart icon should decrease by one
    And the Add to cart button appears

  Scenario: Check empty cart functionality
    When there is no number on the cart icon
    And user clicks on the cart icon
    Then the user has not navigated to Cart Activity
    And please add some products at first message appears

  Scenario: Check add and remove multiple products functionality
    When user adds products to cart
    Then the number on the cart icon increase by products amount
    When user removes products
    Then the number on the cart icon decrease by products amount
