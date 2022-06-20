Feature: Delete an actor from table
  As a user I would like to delete an actor from the actor table

  Scenario: I successfully delete an actors information from the actor table
    Given I have the actor id that I would like to delete
    When I input the ID for the actor I would like to delete
    Then I get the response shown for deleting actor