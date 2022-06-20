Feature: Add a new actor
  As a user I would like to add a new actor into the actor table

  Scenario: I successfully add an actor into my table
    Given I have the actor information I would like to input
    When I input the data into the database for adding an actor
    Then I get the information that I have added returned