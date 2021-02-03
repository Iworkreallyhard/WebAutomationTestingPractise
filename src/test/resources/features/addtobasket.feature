# new feature
# Tags: optional

Feature: Adding and removing from basket

  Scenario: I add a product to basket
    Given the basket is empty
    When  I add 1 product
    Then success message is shown
    And 1 more product is in the basket

  Scenario: I add a product to basket containing products
    Given the basket is not empty
    When I add 1 product
    Then success message is shown
    And 1 more product is in the basket

  Scenario: I add multiple of the same product to the basket
    Given the basket is empty
    When I add 5 items of a product
    Then success message is shown
    And 5 more items are in the basket

  Scenario: I continue shopping after adding to the basket
    Given I have 1 item in the basket
    When I click continue shopping button
    Then success message is closed

  Scenario: I proceed to checkout after adding to the basket
    Given I have 1 item in the basket
    When I click proceed to checkout button
    Then I go to checkout

  Scenario: I remove a product from cart
    Given the basket is not empty
    When I click the remove button
    Then the product is removed from the cart

  Scenario: I add item of product in checkout
    Given the basket is not empty
    When I click add
    Then product quantity is increased by 1

  Scenario: I remove item of product in checkout
    Given the basket is not empty
    When I click decrease
    Then product quantity is decreased by 1

  Scenario: I delete product in checkout
    Given the basket is not empty
    When I click delete
    Then product is removed from the cart

  Scenario: I see basket when hovering over basket icon
    Given the basket is not empty
    When I hover over cart icon
    Then I see contents of basket

  Scenario: I see shopping cart is empty when I remove all products
    Given the basket is not empty
    And there is 1 item in basket
    When I click decrease
    Then I see shopping cart is empty message

  Scenario: I see same shopping cart after closing browser
    Given the basket is not empty
    When I close the browser
    And open the browser
    Then I see items has not changed

