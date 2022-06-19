Feature: View all actors
  As a user I would like to view all actors
  so I can look for my favourite

  Scenario: I can see all actors in the table on the webpage
    Given I have the actors table
    When I request to view all actors
    Then I get the all the actor information on DB