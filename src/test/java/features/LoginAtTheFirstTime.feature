Feature: Login

  @Android
  Scenario Outline: Login successfully with valid username and password - account 1 - unsaved selection
    Given I open the application
    When I click I have an account already
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    And Unsaved account seletion
    Then The home page is open
    Examples:
      | username   | password |
      | 0988903111 | test1234 |


  @Android
  Scenario Outline: Login failed and error message is displayed correctly - account 1
    Given I open the application
    When I click I have an account already
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    Then The error message "<error>" is displayed
    Examples:
      | username   | password      | error         |
      | 0988903111 | wrongpassword | error message |
      | 2222222222 | wrongpassword | error message |
      | 2222222222 | test1234      | error message |

  @Android
  Scenario Outline: Login successfully with valid username and password - account 1 - saved selection
    Given I open the application
    When I click I have an account already
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    And Saved account seletion
    Then The home page is open
    Examples:
      | username   | password |
      | 0988903111 | test1234 |

  @Android
  Scenario Outline: Login successfully with valid username and password - account 2 - unsaved selection
    When I click login with different account
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    And Unsaved account seletion
    Then The home page is open
    Examples:
      | username   | password |
      | 0988903450 | test1234 |

  @Android
  Scenario Outline: Login failed and error message is displayed correctly - account 2
    When I click I have an account already
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    Then The error message "<error>" is displayed
    Examples:
      | username   | password      | error         |
      | 0988903111 | wrongpassword | error message |
      | 2222222222 | wrongpassword | error message |
      | 2222222222 | test1234      | error message |


  @Android
  Scenario Outline: Login successfully with valid username and password - account 1 - saved selection
    Given I open the application
    When I click I have an account already
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    And Saved account seletion
    Then The home page is open
    Examples:
      | username   | password |
      | 0988903450 | test1234 |

  @Android
  Scenario Outline: Login successfully with valid username and password - account 2 - saved selection
    When I click to the avatar
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    And Saved account seletion
    Then The home page is open
    Examples:
      | username   | password |
      | 0988903450 | test1234 |

  @Android
  Scenario Outline: Login successfully with valid username and password - account 3 - different account
    When I click login with other account
    And I input username as "<username>"
    And I input password as "<password>"
    And I click login button
    Then The home page is open
    Examples:
      | username   | password |
      | 0988903450 | test1234 |

#  @appium
#  Scenario: Login successfully via Facebook account - account 1
#    Given I open the application
#    When I click txtHaveAnAccount
#    And I click login via Facebook account
#    And I select a Facebook Account
#    Then The home page is open



