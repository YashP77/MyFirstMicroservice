Feature: Display the correct pages using navigation links
  As a User I would like to be on the correct page once I have clicked on the corresponding link

  Scenario Outline: Check links sending user to the right page
    Given The website is running
    When  The navigation "<button>" button is clicked
    Then  The correct "<page>" page is displayed

    Examples:
      | button     | page      |
      | actorSearch|           |
      | addActor   | add       |
      | updateActor| update    |
      | deleteActor| delete    |
      | filmSearch | filmSearch|
