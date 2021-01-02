Feature: Cart functionality

  @cart
    Scenario: User can't open empty cart
    Given user navigate to home page
    When user click cart button
    Then user check that empty cart message from pupUp is appeared

  @cart
    Scenario: user can't buy zero items
    Given user navigate to laptops catalog
    When user add laptop "MacBook" to cart
    And user navigate to cart
    And user set quantity 0 for product "MacBook"
    Then user check that empty cart message is appeared

  @cart
  Scenario: User can't buy the laptops witch quantity more than it's upper limit
    Given user navigate to laptops catalog
    When user add laptop "MacBook" to cart
    And user navigate to cart
    And user set quantity 925 for product "MacBook"
    And user click checkout expecting failure
    Then user check that quantity warning message is appeared

  @cart
  Scenario: User can buy the phones witch quantity less than it's upper limit
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    And user set quantity 793 for product "iPhone"
    And user click checkout expecting success
    Then user check that was navigated to "Checkout" page

  @cart
    Scenario: User can change quantity of product into cart
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    And user set quantity 530 for product "iPhone"
    Then user check that product quantity for phone "iPhone" the same as 530

  @cart
  Scenario: User can add to cart more than one product
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to laptops catalog
    And user add laptop "MacBook" to cart
    And user navigate to cart
    Then user check that products number is more than 1

  @cart
  Scenario: The product into cart after adding
    Given user navigate to phones catalog
    When user add phone "iPhone" to cart
    And user navigate to cart
    Then user check that product name into cart the same as phone "iPhone"



