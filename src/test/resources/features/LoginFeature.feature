Feature: Orange HRMS Login Features

  Background:
    * Login Page is loaded

  @regression
  Scenario: Login with valid userName and password
    When user Enters valid UserName
    And  User Enters valid Password
    And User clicks on the login Button
    Then verify User is logged in

  @regression
  Scenario: Login with invalid userName and valid password
    When user Enters invalid UserName
    And  User Enters valid Password
    And User clicks on the login Button
    Then verify User Gets the error msg

  @regression
  Scenario: Login with valid userName and invalid password
    When user Enters valid UserName
    And  User Enters invalid Password
    And User clicks on the login Button
    Then verify User Gets empty Password error msg

  @regression
  Scenario Outline: Login page scenarios
    * User enters username "<userName>"
    * user enters password "<password>"
    * User clicks on the login Button
    * user will see "<errMsg>"
    Examples:
      | userName | password    | errMsg                   |
      |          |             | Username cannot be empty |
      | Admin    |             | Password cannot be empty |
      |          | Qedge123!@# | Username cannot be empty |
      | Test     | Test        | Invalid credentials      |





