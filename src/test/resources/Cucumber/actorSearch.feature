Feature: Display all matches written into search bar
  As a User, as soon as I type letters into the search bar, the results will change based on what is typed

  Scenario Outline: Check search bar is functioning correctly
    Given The user is on the actor search webpage
    When Input "<input>" is added to the actor search bar
    Then The related actor results are shown on the page

    Examples:
      | input  |
      | u      |
      | um     |
      | uma    |