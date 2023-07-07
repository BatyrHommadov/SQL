Feature: Adding employees

  Background:
    Given Login Page is loaded
    When user Enters valid UserName
    And  User Enters valid Password
    And User clicks on the login Button

  @regression
  Scenario: Add one employee
    And User clicks PIM
    And User clicks addEmployee
    And User enters "Pat" in firstName field
    And User enters "Manu" in lastName field
    And user saves the employee id
    And User clicks on the save button
    Then User verifies employee is added

  @regression
  Scenario Outline: Add three employees
    And User clicks PIM
    And User clicks addEmployee
    And User Enters "<firstName>" "<middleName>" "<lastName>"
    And User clicks on the save button
    Then User verifies employee is added
    Examples:
      | firstName | middleName | lastName |
      | Pat       | tat        | Manu     |
      | Bat       | gate       | Batyr    |
      | Usman     | nuksan     | Baig     |

  @regression
  Scenario: User adds multiple employees on the same page
    And User clicks add Multiple Employees and verifies employee is added
      | firstName | middleName | lastName |
      | Pat       | tat        | Manu     |
      | Bat       | gate       | Batyr    |
      | Usman     | nuksan     | Baig     |

  @regression
  Scenario: user adds multiple employees from the excel File
    * user Enters multiple employees from excel


