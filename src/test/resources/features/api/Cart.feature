Feature: cart

  Background:
    Given I have authenticated as user "Autotest" with key "oTAw3as6gT2Ui7neUT6Ryggb8tttNXg3mG7MPWf3ehVHndYXicoXQxBRcJQYhwuggQvbI8HJs4rMJxdfLL1fgwp6MDRnlaGU5ivIlBopBf0vuFo4gHVnv7EYUfECArc845rMTJ0LzMlMGFAyo4AwnLFKO2nQJ8fSuiv3hF8OYzCFUdE3mpAD4KRVMhtC8aDzSs0N5yrbKRAD17FiJ2DWTxDLgHuOTKntQZYhEGIN4yF0xoakuJYdq1mI7n0SOdv4"

  @cart @positive @all
  Scenario Outline: add item to cart
    When I add item to cart with item id <item_id> and quantity <quantity>
    Then I should see response status code 200
    And I should see message success "Success: You have modified your shopping cart!"
    When I open cart
    And I should see this item in the cart with item id <item_id>
    Then I should see this item in the cart with quantity <quantity>
    Examples:
      | item_id | quantity |
      | 43      | 2        |

  @cart @positive @all
  Scenario Outline: edit item quantity in cart
    When I add item to cart with item id 43 and quantity 2
    And I remember cart id
    And I edit item quantity <quantity> in cart
    Then I should see response status code 200
    And I should see message success "Success: You have modified your shopping cart!"
    When I open cart
    Then I should see this item in the cart with quantity <quantity>
    Examples:
      | quantity |
      | 5        |
      | 10       |

  @cart @positive @all
  Scenario: remove item from cart
    When I add item to cart with item id 43 and quantity 2
    And I remember cart id
    And I remove item from cart
    Then I should see response status code 200
    And I should see message success "Success: You have modified your shopping cart!"
    When I open cart
    Then I should see that cart is empty