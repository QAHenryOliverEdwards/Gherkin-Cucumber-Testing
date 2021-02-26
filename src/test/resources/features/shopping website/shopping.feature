Feature: Account and basket

  Scenario: I can create an account

    Given I navigate to the sign-up page
    When I enter my user credentials
    And Hit the submit button
    Then I successfully login

  Scenario: I can add an item to the basket

    Given I have searched for an item
    When I add that item to my basket
    Then The item has been successfully added to my basket