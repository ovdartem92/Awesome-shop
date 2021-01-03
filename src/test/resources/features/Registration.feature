Feature: Registration Functionality Feature

  In order to ensure Registration Functionality works,
  I want to run the cucumber test to verify it is working

  Background: open registration page
    Given user open the registration page

  @test @registration @positive
  Scenario: Registration with empty user parameters

    Given user with "emptyUser" parameters
    When user tries to register
    Then registration error should be thrown with message "Registration failed"

  @test @registration @negative
  Scenario Outline: Registration with one invalid user parameter

    Given user with "<invalidUser>" parameters
    When user tries to register
    Then registration error should be thrown with message "Registration failed"
    Examples:
      | invalidUser              |
      | userWithInvalidFirstName |
      | userWithInvalidLastName  |
      | userWithInvalidCity      |
      | userWithInvalidTelephone |

  @test @registration @positive @smoke
  Scenario: Registration with valid user parameters

    Given user with "validUser" parameters
    When user tries to register
    Then registration should be successful

  @test @registration @positive
  Scenario: Registration with an already registered email

    Given user with "registeredUser" parameters
    When user tries to register
    Then registration error should be thrown with message "Warning: E-Mail Address is already registered!"

  @test @registration @positive
  Scenario: Registration without consent to the license agreement

    Given user with "validUser" parameters
    When user tries to register without clicking on the checkbox of the Privacy Policy
    Then registration error should be thrown with message "Warning: You must agree to the Privacy Policy!"

  @test @registration @positive
  Scenario: Open the license agreement window with the corresponding title

    When user clicks on a link with user agreement
    Then should get a window with a title "Privacy Policy"
