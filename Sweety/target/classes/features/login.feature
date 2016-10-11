Feature: Logging into sweety Application
  
  In order to enter diabetic entries
  and view the reports I should log-in

  Background: 
    Given I go to "sweety" application on "Mozila"
    When I am on "login" page

  @login
  Scenario Outline: Logging in sweety application
    And I enter userName as "<Email>"
    And I enter Password as "<Password>"
    And I click on "loginButton"
    Then I should see "<message>"

    Examples: 
      | Email      | Password        | message      |
      | BlankEmail | BlankPassword   | ErrorMessage |
      | validEmail | inValidPassword | ErrorMessage |
      | validEmail | validPassword   | Welcome      |
