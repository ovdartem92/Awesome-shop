Feature: Customer Functionality Feature

  In order to ensure Customer Functionality works,
  I want to run the cucumber test to verify it is working

  @customer @positive @all
  Scenario: Edit the customer by passing empty parameters
    When I modify the customer by passing parameters:
      | firstname | [blank] |
      | lastname  | [blank] |
      | email     | [blank] |
      | telephone | [blank] |
    Then I should see an error with a list of all invalid fields

  @customer @positive @all
  Scenario: Edit the customer by passing valid parameters
    When I modify the customer by passing parameters:
      | firstname | Dear                 |
      | lastname  | Customer             |
      | email     | customer@example.com |
      | telephone | +1 879 2548022       |
    Then I should see a message "You have successfully modified customers"
