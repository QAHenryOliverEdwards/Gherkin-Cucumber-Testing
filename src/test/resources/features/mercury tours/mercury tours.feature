Feature: Account management

  Background:
    Given I am on the mercury tours website

    Scenario: Registration
      Given I navigate to the registration page
      When I enter my details
      And I hit the submit query button
      Then I have successfully registered

      Scenario: Login
        Given I navigate to the sign-on page
        When I enter my user details
        And I hit the submit button
        Then I have successfully signed in
