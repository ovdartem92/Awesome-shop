Feature: Payment

  In order to ensure Payment API Functionality works,
  I want to run the cucumber test to verify it is working

  Background:
    Given I have had a token

  @payment @positive @api
  Scenario: add payment address
    When I perform request to add payment address
      | First Name | <Artem>    |
      | Last Name  | <Ovd>      |
      | Address    | <Gagarina> |
      | City       | <Gomel>    |
      | Country    | <Bel>      |
      | Zone_Id    | <EU>       |
    Then I get status cod 200
    Then I get message: "Success: Payment address has been set!"

  @payment @positive @api
  Scenario: set payment method
    When I perform request to set payment method
      | Payment Method | <free_checkout> |
    Then I get status cod 200
    Then I get message: "Success: Payment method has been set"

  @payment @positive @api
  Scenario: get payments methods
    When I perform request to get payment method
    Then I get status cod 200
    Then I get message: "Warning: No Payment options are available!"
