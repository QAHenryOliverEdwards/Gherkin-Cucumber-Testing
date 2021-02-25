Feature: Searching

  Scenario: Searching for a dress

    Given I'm on the home page
    When I search for a dress
    Then Dresses show up in the results