@login
Feature: Logging in and out

  Scenario: I am logging in through sign in button
    Given I am not logged in
    When I am logging in
    Then I should be logged in

  Scenario: I am logging in during the checkout process
    Given I am not logged in
    And I am checking out with 1 items in the basket
    When I am logging in through checkout
    Then I should be in address

  Scenario: I am logging out
    Given I am logged in
    When I am logging out
    Then I should be logged out

  Scenario: I am logging out with products in the basket
    Given I am logged in with 1 item in basket
    When I am logging out
    Then I should have empty cart