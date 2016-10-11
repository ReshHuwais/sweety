Feature: Level Entry page
  In order to view the records of Diabetic patient
  sugar level should be added to the application 4x a day

  @LevelEntry
  Scenario Outline: Level Entry page
    Given I am on Level Entry Page
    When I click on Add butoon
    And I enter my Glucose level "<Times>" a day
    Then My recods should "<Result>" created

    Examples: 
      | Times | Result |
      |     4 | Be     |
      |     5 | Not    |
