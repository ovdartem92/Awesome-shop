Feature: login

  Background:
    Given I have had a token

  @cart @positive @all
  Scenario Outline: add item to cart
    When I add item to cart with item id <item_id> and quantity <quantity>
    Then I see message success "Success: You have modified your shopping cart!"
    Then I see this item in the cart with item id <item_id> and quantity <quantity>
    Examples:
      | item_id | quantity |
      | 43      | 2        |

  @cart @positive @all
  Scenario Outline: edit item quantity in cart
    When I add item to cart with item id 43 and quantity 2
    And I have cart id
    And I edit item quantity <quantity> in cart
    Then I see message success "Success: You have modified your shopping cart!"
    And I see this item in the cart with quantity <quantity>
    Examples:
      | quantity |
      | 5        |
      | 3        |

  @cart @positive @all
  Scenario: remove item from cart
    When I add item to cart with item id 43 and quantity 2
    And I have cart id
    And I remove item from cart
    Then I see message success "Success: You have modified your shopping cart!"
    And I see that cart is empty

