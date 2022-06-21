Feature: Update a film's information
  As a user I would like to update a film's information in the film table

  Scenario: I successfully updated a film's information in the film table
    Given I have the film information and id number of the film I would like to update
    When I input the ID number and the data into the update method
    Then I get the film information that I have updated returned