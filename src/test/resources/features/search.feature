Feature: search

  Background:
    Given I have opened home page

#  @search @positive @all
#  Scenario: check search result by product description
#    When I perform basic search of "Classic iPod" product
#    And I enable search in product descriptions
#    And I click advanced search button
#    Then "iPod Classic" product should be found
#
#  @search @positive @all
#  Scenario: check search result by product category
#    When I perform basic search of "iMac" product
#    And I select “iMac” category
#    And I click advanced search button
#    Then "iMac" product should be found
#
#  @search @positive @all
#  Scenario: check search result by pressing the enter key
#    When I type "iPod Classic" search query
#    And I press Enter
#    Then "iPod Classic" product should be found
#
#  @search @positive @all
#  Scenario Outline: check search by positive data
#    When I perform basic search of "<product_name>" product
#    Then "iPod Classic" product should be found
#
#    Examples:
#      | product_name |
#      | Classic iPod |
#      | iPo          |
#      | IPOD         |
#      | iPod Classic |

  @search @negative @all
  Scenario Outline: check search by negative data
    When I perform basic search of "<search_query>" product
    Then I should see incorrect search message "<message>"

    Examples:
      | search_query            | message                                               |
      | alert('I hacked this!') | There is no product that matches the search criteria. |
      | Mercedes GLE-Coupe      | There is no product that matches the search criteria. |
      |                         | There is no product that matches the search criteria. |
      | [blank]                 | There is no product that matches the search criteria. |
