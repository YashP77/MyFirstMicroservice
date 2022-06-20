Feature: Update an actors information
  As a user I would like to update an actors information into the actor table

  Scenario: I successfully update an actors information in actor table
    Given I have the actor information and id number of the actor I would like to change
    When I input the data into the database for update
    Then I get the information that I have updated returned