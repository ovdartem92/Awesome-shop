Feature: Cart functionality

  @cart
  Scenario: User add product to cart and remove it
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    And user remove product "iPhone" from cart
    Then user check that empty cart message is appeared

  @cart
  Scenario: User add product to cart and check its value and price
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    Then user check that product name is "iPhone" and price is "$121.20"

  @cart
  Scenario: User add product to cart and then click continue shopping
    Given user navigate to laptops catalog
    When user add laptop "MacBook" to cart
    And user navigate to cart
    And  user click continue shopping
    Then user check that was navigated to "Your Store" page

  @cart
  Scenario: User make cart is empty and continue button navigate to home page
    Given user navigate to laptops catalog
    When user add laptop "MacBook" to cart
    And user navigate to cart
    And user remove product "MacBook" from cart
    And  user click continue
    Then user check that was navigated to "Your Store" page

  @cart
  Scenario: User try to open empty cart
    Given user navigate to home page
    When user click cart button
    Then user check that empty cart message from pupUp is appeared

  @cart
  Scenario: User add product to cart, sets its quantity equals zero
    Given user navigate to laptops catalog
    When user add laptop "MacBook" to cart
    And user navigate to cart
    And user set quantity 0 for product "MacBook"
    Then user check that empty cart message is appeared

  @cart
  Scenario: User try to buy the product witch quantity more than its upper limit
    Given user navigate to laptops catalog
    When user add laptop "MacBook" to cart
    And user navigate to cart
    And user set quantity 925 for product "MacBook"
    And user click checkout expecting failure
    Then user check that quantity warning message is appeared

  @cart
  Scenario: User try to buy the product witch quantity less than its upper limit
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    And user set quantity 793 for product "iPhone"
    And user click checkout expecting success
    Then user check that was navigated to "Checkout" page

  @cart
  Scenario: User change quantity of product into cart
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    And user set quantity 530 for product "iPhone"
    Then user check that quantity for product "iPhone" the same as 530

  @cart
  Scenario: User add to cart more than one product
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to laptops catalog
    And user add laptop "MacBook" to cart
    And user navigate to cart
    Then user check that products number is more than 1

  @cart
  Scenario: User add product to cart
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    Then user check that product name into cart the same as phone "iPhone"



