Feature: User want to log in account

  @smoke
  Scenario: User must log in account with valid credentials

    Given user open LoginPage
    When user type valid email
    When user type valid password
    And user click login button
    Then text "My Account" is displayed