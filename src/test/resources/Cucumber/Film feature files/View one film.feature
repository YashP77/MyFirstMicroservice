Feature: View one film
  As a user I would like to view a specific film's information from the database

  Scenario: I successfully view a film from the database
    Given I have the film id number
    When I input the film id into the search
    Then I get the string with the film's information