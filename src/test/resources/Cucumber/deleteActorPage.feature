Feature: Delete actor from database using front end interface
  As a User, I am able to delete an actor from the database through the webpage

  Scenario: Check that actors are deleted
    Given The user is on the delete actor webpage
    When Input is added to the delete actor input bar
    And The delete button is pressed
    Then The result of the delete actor submission is shown on screen