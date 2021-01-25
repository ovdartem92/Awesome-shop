Feature: coupon

  Background:
    Given I have had a token

  @coupon @negative @all
  Scenario Outline: use coupon
    When I use wrong coupon <couponNumber>
    Then I see message error "Warning: Coupon is either invalid, expired or reached it's usage limit!"
    Examples:
      | couponNumber |
      | 22222        |
      | 1108         |
