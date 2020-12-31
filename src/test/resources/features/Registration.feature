Feature: Registration test scenarios

  Background: open registration page
    Given the user open the registration page

  @test @registration @positive
  Scenario: User registration with empty parameters
    Given the User with "emptyUser" parameters
    When the User tries to register

  @test @registration @negative
  Scenario Outline: Registering a user with one invalid parameter
    Given the User with "<invalidUser>" parameters
    When the User tries to register
    Then throw a registration error with information about invalid fields
    Examples:
      | invalidUser              |
      | userWithInvalidFirstName |
      | userWithInvalidLastName  |

  @test @registration @positive @smoke
  Scenario: Registering a user with valid parameters
    Given the User with "validUser" parameters
    When the User tries to register

  @test @registration @positive
  Scenario: Registering a user with an already registered email
    Given the User with "registeredUser" parameters
    When the User tries to register
    Then throw a registration error with message "Warning: E-Mail Address is already registered!"

  @test @registration @positive
  Scenario: User registration without consent to the license agreement
    Given the User with "validUser" parameters
    When the user tries to register without clicking on the checkbox of the Privacy Policy
    Then throw a registration error with message "Warning: You must agree to the Privacy Policy!"

  @test @registration @positive
  Scenario: Opening the license agreement window with the corresponding title
    When the user clicks on a link with user agreement
    Then the user should get a window with a title "Privacy Policy"
