Feature: Login611

  @appium
  Scenario Outline: Login successfully with valid username and password - account 1 - unsaved selection
    When I click next button
    And I click skip intro
    And I input email "<email>"
    And I input password "<password>"
    And I click loginH button

    Examples:
      | email               | password |
      | hnhaplo+1@gmail.com | 12345678 |