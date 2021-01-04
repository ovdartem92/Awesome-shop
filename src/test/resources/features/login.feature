Feature: login

  Background:
    Given login page is opened

  @login @positive @all
  Scenario: login with valid credentials
    When login with valid credentials
    Then My Account label is appeared

  @login @positive @all
  Scenario: logout after successful login
    When login with valid credentials
    And click logout button
    Then Logout page is opened and breadcrumble has Logout text

  @login @negative @all
  Scenario Outline: login with invalid credentials
    When login with invalid credentials <User>
    Then Error message with text "Warning: No match for E-Mail Address and/or Password." is appeared
    Examples:
      | User                    |
      | userWithInvalidPassword |
      | userWithInvalidEmail    |
