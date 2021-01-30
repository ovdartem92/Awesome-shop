Feature: coupon

  Background:
    Given I have had a token

  @coupon @negative @all
  Scenario Outline: use coupon
    When I use wrong coupon <couponNumber>
    Then I should see response status code 200
    And I should see message error "Warning: Coupon is either invalid, expired or reached it's usage limit!"
    Examples:
      | couponNumber |
      | 22222        |
      | 1108         |
