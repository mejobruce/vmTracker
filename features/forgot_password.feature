@Forget
Feature: Forgot Password Functionality
 @Forget
  Scenario Outline: Successful password reset with valid email
    Given the user is on the forgot password page
    When the user enters a valid "<email>" address
    And clicks the submit button
    Then a "<success message>" will then be shown.
    Examples:
            |email|success message|
            |mejo1808@gmail.com|Check your email account for reset link!|
@Forget
  Scenario Outline: Unsuccessful password reset with invalid email
    Given the user is on the forgot password page
    When the user enters an invalid "<email>" address
    And clicks the submit button
    Then The user should see an "<error message>".
     Examples:
            |email|error message|
            |@mejo1808@gmail.com|Invalid email|