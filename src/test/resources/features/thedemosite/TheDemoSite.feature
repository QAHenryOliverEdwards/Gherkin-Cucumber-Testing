Feature: Registration and login

  Scenario: Registration

    Given I navigate to the add a user page
    When I enter a username
    And I enter a password
    And I hit the submit button
    Then I have created a user

  Scenario: Login

    Given I navigate to the login page
    When I enter my username
    And I enter my password
    And I hit the submit button
    Then I have successfully logged in