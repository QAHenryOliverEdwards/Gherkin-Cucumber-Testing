Feature: Risers and Fallers

  Background: On the main site
    Given I am on the FTSE site

  Scenario: Risers
    Given I have navigated to the risers tab
    Then I can see the largest riser

  Scenario: Fallers
    Given I have navigated to the fallers tab
    Then I can see the largest faller
