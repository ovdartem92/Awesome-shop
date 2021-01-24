Feature: Cart functionality

  @cart @positive @all
  Scenario: User add product to cart and remove it
    Given I navigate to phones catalog
    When I add phone "iPhone" to cart
    And I navigate to cart
    And I remove product "iPhone" from cart
    Then The empty cart message should be displayed

  @cart @positive @all
  Scenario: User add product to cart and check its value and price
    Given I navigate to phones catalog
    When I add phone "iPhone" to cart
    And I navigate to cart
    Then The product name into cart should be "iPhone"
    And The product price for "iPhone" should be "$121.20"

  @cart @positive @all
  Scenario: User add product to cart and then click continue shopping
    Given I navigate to laptops catalog
    When I add laptop "MacBook" to cart
    And I navigate to cart
    And I click continue shopping
    Then I should be navigated to "Your Store" page

  @cart @positive @all
  Scenario: User make cart is empty and continue button navigate to home page
    Given I navigate to laptops catalog
    When I add laptop "MacBook" to cart
    And I navigate to cart
    And I remove product "MacBook" from cart
    And I click continue
    Then I should be navigated to "Your Store" page

  @cart @positive @all
  Scenario: User try to open empty cart
    Given I navigate to laptops catalog
    When I click cart button
    Then The empty cart message from pupUp should be displayed

  @cart @positive @all
  Scenario: User add product to cart, sets its quantity equals zero
    Given I navigate to laptops catalog
    When I add laptop "MacBook" to cart
    And I navigate to cart
    And I set quantity 0 for product "MacBook"
    Then The empty cart message should be displayed

  @cart @positive @all
  Scenario: User try to buy the product witch quantity more than its upper limit
    Given I navigate to laptops catalog
    When I add laptop "MacBook" to cart
    And I navigate to cart
    And I set quantity 925 for product "MacBook"
    And I click checkout expecting failure
    Then The quantity warning message should be displayed

  @cart @positive @all
  Scenario: User try to buy the product witch quantity less than its upper limit
    Given I navigate to phones catalog
    When I add phone "iPhone" to cart
    And I navigate to cart
    And I set quantity 793 for product "iPhone"
    And I click checkout expecting success
    Then I should be navigated to "Checkout" page

  @cart @positive @all
  Scenario: User change quantity of product into cart
    Given I navigate to phones catalog
    When I add phone "iPhone" to cart
    And I navigate to cart
    And I set quantity 530 for product "iPhone"
    Then The quantity for product "iPhone" should be 530

  @cart @positive @all
  Scenario: User add to cart more than one product
    Given I navigate to phones catalog
    When I add phone "iPhone" to cart
    And I navigate to laptops catalog
    And I add laptop "MacBook" to cart
    And I navigate to cart
    Then The number of products into cart should be more than 1

  @cart @positive @all
  Scenario: User add product to cart
    Given I navigate to phones catalog
    When I add phone "iPhone" to cart
    And I navigate to cart
    Then The product name into cart should be "iPhone"