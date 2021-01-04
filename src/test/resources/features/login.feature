Feature: login

  Background:
    Given I have opened login page

#  @login @positive @all
#  Scenario: login with valid credentials
#    When I login with valid credentials
#    Then I should see My Account account name
#
#  @login @positive @all
#  Scenario: logout after successful login
#    When I login with valid credentials
#    And I click logout button
#    Then Logout page with title Account Logout should be opened
#    And  I should see that breadcrumb contains Logout text

  @login @negative @all
  Scenario Outline: login with invalid credentials
    When I login with <email> email and <password> password
    Then I should see authentication error message Warning: No match for E-Mail Address and/or Password.
    Examples:
      | email             | password     |
      | nivanis@yandex.ru | 12345678     |
      | test123@epam.com  | testPassword |
