Feature: Order Functionality Feature

  In order to ensure Order Functionality works,
  I want to run the cucumber test to verify it is working

  @order @positive @all
  Scenario: Add an empty order
    When I add an empty order
    Then I should see an error message "Warning: Products marked with *** are not available in the desired quantity or not in stock!"

  @order @positive @all
  Scenario: Edit an order
    When I edit an order
    Then I should see an error message "Warning: Order could not be found!"

  @order @positive @all
  Scenario: Delete an order
    When I delete an order
    Then I should see an error message "Warning: Order could not be found!"

  @order @positive @all
  Scenario: Get info about the order
    When I get info about the order
    Then I should see an error message "Warning: Order could not be found!"

  @order @positive @all
  Scenario: Get order history
    When I get history about the order
    Then I should see an error message "Warning: Order could not be found!"
