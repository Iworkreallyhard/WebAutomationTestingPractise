# new feature
# Tags: optional

Feature: Adding and removing from cart
  #change cart is empty/not empty, say cart has INT items
  @addToCart
  Scenario: I add a product to cart
    Given the cart is empty
    When  I add 1 product
    Then 1 more product is in the cart

  Scenario: I add a product to cart containing products
    Given the cart is not empty
    When I add 1 product
    Then 1 more product is in the cart

  Scenario: I add multiple of the same product to the cart
    Given the cart is empty
    When I add 5 items of a product
    Then 5 more items are in the cart

  Scenario: I continue shopping after adding to the cart
    Given I have an item in the cart
    When I click continue shopping button
    Then I go back to the homepage


  Scenario: I proceed to checkout after adding to the cart
    Given I have an item in the cart
    When I click proceed to checkout button
    Then I go to checkout

  Scenario: I remove a product from cart
    Given the cart is not empty
    When I click the remove button
    Then the product is removed from the cart


  Scenario: I see cart when hovering over cart icon
    Given the cart is not empty
    When I hover over cart icon
    Then I see contents of cart


  Scenario: I see same shopping cart after closing browser
    Given the cart is not empty
    When I close the browser
    And open the browser
    Then I see items has not changed

