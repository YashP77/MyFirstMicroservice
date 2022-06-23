Feature: Display all matches written into film search bar
  As a User, as soon as I type letters into the search bar, the results will change based on what is typed

  Scenario: Check search bar is functioning correctly
    Given The user is on the film search webpage
    When Input is added to the film search bar
    Then The related films results are shown on the page
