Feature: Different payment methods return confirmation

  Background: I am logged in and have items in my cart
    Given I am logged in as a user
    And I have 2 items in my cart

  Scenario: Paying by bank wire will return me a confirmation page
    Given I am at selecting payment method
    When I select pay by bank wire
    And I confirm the order
    Then I am shown an order confirmation

  Scenario: Paying by bank wire will empty the cart
    Given I am at selecting payment method
    When I select pay by bank wire
    And I confirm the order
    Then My cart is empty

  Scenario: Paying by bank wire will record the correct payment method
    Given I am at selecting payment method
    When I select pay by bank wire
    And I confirm the order
    Then My order should be logged with payment method "Bank wire"

  Scenario: Paying by check will return me a confirmation page
    Given I am at selecting payment method
    When I select pay by check
    And I confirm the order
    Then I am shown an order confirmation

  Scenario: Paying by check will  empty the cart
    Given I am at selecting payment method
    When I select pay by check
    And I confirm the order
    Then My cart is empty

  Scenario: Paying by check will record the correct payment method
    Given I am at selecting payment method
    When I select pay by check
    And I confirm the order
    Then My order should be logged with payment method "Payment by check"
