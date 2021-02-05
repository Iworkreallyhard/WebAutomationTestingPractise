Feature: Dealing with address on checkout

  Scenario: Updating address
    Given I have logged in and checking out with a product
    When I click update address
    Then I should be redirected to update address page

  Scenario: Switch address
    Given I have logged in and checking out with a product
    When I choose a different address
    Then my address should change

  Scenario: Having different addresses for delivery and billing
    Given I have logged in and checking out with a product
    When I uncheck using same delivery address checkbox
    Then I should have different delivery and billing addresses

  Scenario: I have correct addresses and would like to proceed with checkout
    Given I have logged in and checking out with a product
    When I click proceed to checkout
    Then I should be redirected to Shipping