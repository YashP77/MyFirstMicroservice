Feature: Update actor from database using front end interface
  As a User, I am able to update an actor from the database through the webpage

  Scenario: Check that actors are updated
    Given The user is on the update actor webpage
    When Input is added to the update actor input bar
    And The update button is pressed
    Then The result of the update actor submission is shown on screen