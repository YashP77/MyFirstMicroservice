Feature: Delete a film from table
  As a user I would like to delete a film from the film table

  Scenario: I successfully delete a film's information from the film table
    Given I have the film id that I would like to delete
    When I input the ID for the film I would like to delete
    Then I get the response shown for deleting a film