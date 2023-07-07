Feature: Searching candidates based on different criteria

  Background:
    Given Login Page is loaded
    When user Enters valid UserName
    And  User Enters valid Password
    And User clicks on the login Button
  @regression @smoke
  Scenario: User should be able to search the candidates based on job title
    * user clicks on recruitment tab
    * user clicks on job title drop down and selects "artificial intelligence"
    * user clicks on the search button
    * verifies the candidate