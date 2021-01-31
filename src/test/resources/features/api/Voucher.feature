Feature: Voucher

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @api @voucher @positive
  Scenario: apply existing voucher
    When I send request for applying existing voucher "VOU-1000"
    Then I should get applying voucher status code 200
    And I should get applying voucher error message "Warning: Gift Voucher is either invalid or the balance has been used up!"

  @api @voucher @positive @api
  Scenario: add new voucher
    When I send request for adding new voucher
      | from_name  | MyOpenCart Admin     |
      | from_email | admin@example.com    |
      | to_name    | Dear Customer        |
      | to_email   | customer@example.com |
      | amount     | 1000                 |
      | code       | VOU-7177             |
    Then I should get add voucher status code 200
    And I should get add voucher success message "Success: You have modified your shopping cart!"
