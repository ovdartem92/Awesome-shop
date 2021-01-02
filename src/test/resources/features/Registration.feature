Feature: Registration test scenarios

  Background: open registration page
    Given the user open the registration page

  @test @registration @positive
  Scenario: Registration with empty user parameters
    Given the User with "emptyUser" parameters
    When the User tries to register
    Then throw a registration error with message "Registration failed"

  @test @registration @negative
  Scenario Outline: Registration with one invalid user parameter
    Given the User with "<invalidUser>" parameters
    When the User tries to register
    Then throw a registration error with message "Registration failed"
    Examples:
      | invalidUser              |
      | userWithInvalidFirstName |
      | userWithInvalidLastName  |
      | userWithInvalidCity      |
      | userWithInvalidTelephone |

  @test @registration @positive @smoke
  Scenario: Registration with valid user parameters
    Given the User with "validUser" parameters
    When the User tries to register
    Then the User does not receive registration errors

  @test @registration @positive
  Scenario: Registration with an already registered email
    Given the User with "registeredUser" parameters
    When the User tries to register
    Then throw a registration error with message "Warning: E-Mail Address is already registered!"

  @test @registration @positive
  Scenario: Registration without consent to the license agreement
    Given the User with "validUser" parameters
    When the User tries to register without clicking on the checkbox of the Privacy Policy
    Then throw a registration error with message "Warning: You must agree to the Privacy Policy!"

  @test @registration @positive
  Scenario: Open the license agreement window with the corresponding title
    When the User clicks on a link with user agreement
    Then should get a window with a title "Privacy Policy"
