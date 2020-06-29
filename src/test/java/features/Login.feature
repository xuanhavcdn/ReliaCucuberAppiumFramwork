Feature: Login

  @appium
  Scenario Outline: Login successfully
    Given I open the application
    When I click txtHaveAnAccount
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    And Handle save account
    Then The home page is open
    Examples:
      |username|password|
      |0988903111|test1234|


  @appium
  Scenario Outline: Error message is displayed correctly
    Given I open the application
    When I click txtHaveAnAccount
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    Then The error message "<error>" is displayed
    Examples:
      |username|password|error|
      |0988903111|wrongpassword|error message|
      |2222222222|wrongpassword|error message|