Feature: Order Functionality Feature

  In order to ensure Order Functionality works,
  I want to run the cucumber test to verify it is working

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @api @order @positive @all
  Scenario: Add an empty order
    When I add an empty order
    Then I should see response status code 200
    And I should see an error message "Warning: Products marked with *** are not available in the desired quantity or not in stock!"

  @api @order @positive @all
  Scenario: Edit an order
    When I edit an order
    Then I should see response status code 200
    And I should see an error message "Warning: Order could not be found!"

  @api @order @positive @all
  Scenario: Delete an order
    When I delete an order
    Then I should see response status code 200
    And I should see an error message "Warning: Order could not be found!"

  @api @order @positive @all
  Scenario: Get info about the order
    When I get info about the order
    Then I should see response status code 200
    And I should see an error message "Warning: Order could not be found!"

  @api @order @positive @all
  Scenario: Get order history
    When I get history about the order
    Then I should see response status code 200
    And I should see an error message "Warning: Order could not be found!"
