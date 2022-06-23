Feature: Add actor into database using front end interface
  As a User, I am able to add an actor into the database through the webpage

  Scenario: Check that actors are added
    Given The user is on the add actor webpage
    When Input is added to the actor input bar
    And The submit button is pressed
    Then The result of the add actor submission is shown on screen
