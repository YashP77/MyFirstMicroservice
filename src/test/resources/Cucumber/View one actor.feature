Feature: View one actor
  As a user I would like to view an actors information from the database

  Scenario: I successfully view an actor from the database
    Given I have the actors id number
    When I input the id into the search
    Then I get the string with the actors information