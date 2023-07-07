Feature: HomePage Verification

  Background:
    Given Login Page is loaded
    When user Enters valid UserName
    And  User Enters valid Password
    And User clicks on the login Button

  @regression
  Scenario: User verifies the tabs on HomePage
    Then User verifies all Tabs are available
      | Admin | PIM | Leave | Time | Recruitment | My Info | Performance | Dashboard | Directory | Maintenance | Buzz |