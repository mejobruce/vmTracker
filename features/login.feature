@Login
Feature: Login Functionality

   @Login
  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters invalid "<Username>" and "<password>"
    And clicks the login button
    Then the user should be logged in successfully and an "<Succuessfully message>" should be displayed

    Examples: 
      | Username | password      | Succuessfully message       |
      | mejo1808@gmail.com     | Mejo@06101991 | Succuessfully LoggedIn |

  @Login
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters invalid "<Username>" and "<password>"
    And clicks the login button
    Then an "<error message>" should be displayed

    Examples: 
      | Username | password      | error message            |
      | @mejo1808@gmail.com| Mejo@06101991 |Please Enter Valid Email|
    