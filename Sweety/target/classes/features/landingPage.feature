Feature: Landing Page validation

  @LandingPage
  Scenario: Display user credential on Landing page
    Given I am on Home page
    When I verify the home page
    Then I sould see my loginID on home page

  @LandingPage
  Scenario: Entry panel
    Then I sould see Entry panels on home page
      | Date  |
      | Level |

  @LandingPage
  Scenario: Report panel
    Then I sould see Report panels on home page
      | Type   |
      | Access |

  @LandingPage
  Scenario: View on report panel
    When I click on view link
    Then I should land on Level "Reports" page
