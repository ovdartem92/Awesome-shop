Feature: Currency

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @api @currency @positive
  Scenario: change currency
    When I send valid request for changing currency "EUR"
    Then I should get currency status code 200
    And I should get currency success message "Success: Your currency has been changed!"

  @api @currency @positive @api
  Scenario: change currency
    When I send invalid request for changing currency "BLR"
    Then I should get currency status code 200
    And I should get currency error message "Warning: Currency code is invalid!"
