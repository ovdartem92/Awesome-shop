Feature: search

  In order to ensure Search functionality works,
  I want to run the cucumber test to verify it is working

  Background:
    Given I have opened home page

  @ui @search @positive @all
  Scenario: check search result by product description
    When I perform basic search of "Classic iPod" product
    And I enable search in product descriptions
    And I click advanced search button
    Then "iPod Classic" product should be found

  @ui @search @positive @all
  Scenario: check search result by product category
    When I perform basic search of "iMac" product
    And I select “iMac” category
    And I click advanced search button
    Then "iMac" product should be found

  @ui @search @positive @all
  Scenario: check search result by pressing the enter key
    When I type "iPod Classic" search query
    And I press Enter
    Then "iPod Classic" product should be found

  @ui @search @positive @all
  Scenario Outline: check search by positive data
    When I search for "<product_name>" product
    Then "iPod Classic" product should be found

    Examples:
      | product_name |
      | Classic iPod |
      | iPo          |
      | IPOD         |
      | iPod Classic |

  @ui @search @negative @all
  Scenario Outline: check search by negative data
    When I search for "<search_query>" product
    Then I should see incorrect search message "<message>"

    Examples:
      | search_query            | message                                               |
      | alert('I hacked this!') | There is no product that matches the search criteria. |
      | Mercedes GLE-Coupe      | There is no product that matches the search criteria. |
      | [blank]                 | There is no product that matches the search criteria. |
