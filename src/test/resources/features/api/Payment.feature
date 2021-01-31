Feature: Payment

  In order to ensure Payment API Functionality works,
  I want to run the cucumber test to verify it is working

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @api @payment @positive @all
  Scenario: add payment address
    When I perform request to add payment address
      | First Name | Artem    |
      | Last Name  | Ovd      |
      | Address    | Gagarina |
      | City       | Gomel    |
      | Country    | Bel      |
      | Zone_Id    | EU       |
    Then I should get status code 200
    And I should get success message "Success: Payment address has been set!"

  @api @payment @positive @all
  Scenario: set payment method
    When I perform request to set payment method
      | Payment Method | free_checkout |
    Then I should get status code 200
    And I should get success message "Success: Payment method has been set"

  @api @payment @positive @all
  Scenario: get payments methods
    When I perform request to get payment method
    Then I should get status code 200
    And I should get error message "Warning: Payment address required!"
