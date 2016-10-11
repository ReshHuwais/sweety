Feature: Level Reports page
  Three data points should be displayed on the Report
  Dail and Monthly Reports can be accessed

  Background: Report page
    Given I am on Report Page

  @Report
  Scenario Outline: Report table on Report page
    When I click on "<Links>" Link
    Then I should see "<Links>" header
    And I should see three levels on "<Links>" table
      | Date    |
      | Entries |
      | Level   |
      | Min     |
      | Max     |
      | Avg     |
    And I should see entries for each levels in "<Links>" table

    Examples: 
      | Links   |
      | Daily   |
      | Monthly |
