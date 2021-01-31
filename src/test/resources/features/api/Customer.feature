Feature: Customer Functionality Feature

  In order to ensure Customer Functionality works,
  I want to run the cucumber test to verify it is working

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @api @customer @negative @all
  Scenario: Edit the customer by passing parameters
    When I modify the customer by passing parameters:
      | firstname | [blank] |
      | lastname  | [blank] |
      | email     | [blank] |
      | telephone | [blank] |
    Then I should get status code 400
    And I should see an error with a list of all invalid fields:
      | firstname | First Name must be between 1 and 32 characters! |
      | lastname  | Last Name must be between 1 and 32 characters!  |
      | email     | E-Mail Address does not appear to be valid!     |
      | telephone | Telephone must be between 3 and 32 characters!  |

  @api @customer @positive @all
  Scenario: Edit the customer by passing valid parameters
    When I modify the customer by passing parameters:
      | firstname | Dear                 |
      | lastname  | Customer             |
      | email     | customer@example.com |
      | telephone | +1 879 2548022       |
    Then I should get status code 200
    And I should see a message "You have successfully modified customers"
