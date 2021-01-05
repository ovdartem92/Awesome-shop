Feature: Registration Functionality Feature

  In order to ensure Registration Functionality works,
  I want to run the cucumber test to verify it is working

  Background: open registration page
    Given I have opened the registration page

  @test @registration @positive
  Scenario: Registration with empty user parameters
    When I register with data:
      | Email   | Password |
      | [blank] | [blank]  |
    Then I should see registration error message "Registration failed"

  @test @registration @negative
  Scenario Outline: Registration with one invalid user parameter
    When I register with data:
      | First Name   | Last Name   | City   | Telephone   |
      | <first_name> | <last_name> | <city> | <telephone> |
    Then I should see registration error message "Registration failed"

    Examples:
      | first_name | last_name | city    | telephone    |
      | Joe#       | Dow       | London  | +1234567890  |
      | Joe        | Dow$      | London  | +1234567890  |
      | Joe        | Dow       | L@ondon | +1234567890  |
      | Joe        | Dow       | London  | +"1234567890 |

  @test @registration @positive @smoke
  Scenario: Registration as a valid user
    When I am registering as a user with the consent to the license agreement is "true"
    Then I should see home page

  @test @registration @positive
  Scenario: Registration with an already registered email
    When I register with data:
      | Email                    | Password    |
      | alexandr_ladygin@mail.ru | qwerty12345 |
    Then I should see registration error message "Registration failed"

  @test @registration @positive
  Scenario: Registration without consent to the license agreement
    When I am registering as a user with the consent to the license agreement is "false"
    Then I should see registration error message "You must agree to the Privacy Policy!"

  @test @registration @positive
  Scenario: Open the license agreement window with the corresponding title
    When I click privacy policy link
    Then I should see "Privacy Policy" pop up window
