Feature: Add a new Actor
  As a user I would like to add a new actor to my table

  Scenario: I successfully added an actor to the table
    Given I have the actors information
    When I input data into the database
    Then I get the saved returned string

#  Scenario: I do not have enough info
#    Given I have an actors first name
#    And I dont have their last name
#    When I try to add them into the database
#    Then I get an error message