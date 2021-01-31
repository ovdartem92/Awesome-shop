Feature: coupon

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @api @coupon @negative @all
  Scenario Outline: use coupon
    When I use wrong coupon <couponNumber>
    Then I should get status code 200
    And I should see message error "Warning: Coupon is either invalid, expired or reached it's usage limit!"
    Examples:
      | couponNumber |
      | 22222        |
      | 1108         |
