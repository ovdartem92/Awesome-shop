Feature: Login Functionality

  @smoke
  Scenario: Login Functionality

    Given user open LoginPage
    When user type valid email
    When user type valid password
    And user click login button
    Then text "My Account" is displayed