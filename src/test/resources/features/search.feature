Feature: search

  Background:
    Given home page is opened

  @search @positive @all
  Scenario: check search result by product description
    When enter "Classic iPod" data to search
    And set description checkbox
    Then Product "iPod Classic" was found

  @search @positive @all
  Scenario: check search result by product category
    When enter "iMac" data to search
    And set iMac category
    Then Product "iMac" was found

  @search @positive @all
  Scenario: check search result by pressing the enter key
    When enter "iPod Classic" without click to search
    And press key Enter
    Then Product "iPod Classic" was found

  @search @positive @all
  Scenario: check search by positive data
    When enter "Classic iPod" data to search
    Then Product "iPod Classic" was found

  @search @positive @all
  Scenario: check search by positive data
    When enter "iPo" data to search
    Then Product "iPod Classic" was found

  @search @positive @all
  Scenario: check search by positive data
    When enter "IPOD" data to search
    Then Product "iPod Classic" was found

  @search @positive @all
  Scenario: check search by positive data
    When enter "iPod Classic" data to search
    Then Product "iPod Classic" was found

  @search @negative @all
  Scenario: check search by negative data
    When enter "alert('I hacked this!')" data to search
    Then Incorrect message is appeared

  @search @negative @all
  Scenario: check search by negative data
    When enter "Mercedes GLE-Coupe" data to search
    Then Incorrect message is appeared

  @search @negative @all
  Scenario: check search by negative data
    When enter "" data to search
    Then Incorrect message is appeared

  @search @negative @all
  Scenario: check search by negative data
    When enter " " data to search
    Then Incorrect message is appeared