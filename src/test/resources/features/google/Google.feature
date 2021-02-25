Feature: Google

  Scenario: Google Kitten

    Given I navigate to google
    When I search for kittens
    And I click the images tab
    Then I can see images of kittens