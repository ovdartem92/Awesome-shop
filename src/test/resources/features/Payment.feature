Feature: Payment

  @payment @positive @api
  Scenario: add payment address
    When I perform request to add payment address
    Then I get status cod 200
    Then I get success message

  @payment @positive @api
  Scenario: set payment method
    When I perform request to set payment method
    Then I get status cod 200
    Then I get error message

  @payment @positive @api
  Scenario: get payments methods
    When I perform request to get payment method
    Then I get status cod 200
    Then I get error message