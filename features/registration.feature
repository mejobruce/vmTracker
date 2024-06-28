
@Registration
Feature: Registration Functionality
  @Registration
  Scenario Outline: Successful registration with valid details
    Given the user is on the registration page
    When the user enters valid registration details "<Name>","<email>","<phoneNumber>","<Possword>"
    And clicks the register button
    Then a "<success message>" should be displayed
    
    Examples: 
      | Name | email      | phoneNumber       |Possword|success message|
      |mejo| mejo1808@gmail.com  |6379854578  | Mejo@06101991 | Succuessfully Registered|
   @Registration
  Scenario Outline: Unsuccessful registration with missing details
    Given the user is on the registration page
    When the user enters incomplete registration details "<Name>","<email>","<phoneNumber>","<Possword>"
    And clicks the register button
    Then an error message should be displayed
      Examples: 
      | Name | email      | phoneNumber       |Possword|
      |      |            |                   |        |