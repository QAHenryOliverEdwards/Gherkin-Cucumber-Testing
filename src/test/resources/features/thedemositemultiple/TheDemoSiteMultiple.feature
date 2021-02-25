Feature: Testing lots of users

  Scenario Outline: Lots Of Users Validation

    Given I'm on thedemosite
    When I navigate to the add a user page
    And I enter a <username> and a <password>
    Then I have created a user

    When I navigate to the login page
    And I enter my <username> and <password>
    Then I have successfully logged in

    Examples:
      | username   | password   |
      | "root"     | "root"     |
      | "cucumber" | "cucumber" |
      | "guest"    | "guest"    |
      | "admin"    | "password" |
      | "1234"     | "5678"     |