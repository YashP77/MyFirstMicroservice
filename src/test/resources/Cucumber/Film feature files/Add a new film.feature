Feature: Add a new film
  As a user I would like to add a new film into the film table

  Scenario: I successfully add a film into my table
    Given I have the film information I would like to input
    When I input the data into the database for adding a film
    Then I get the film information that I have added returned