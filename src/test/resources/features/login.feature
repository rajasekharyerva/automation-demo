@Login
Feature: Login

  Scenario Outline: Login with valid credentials
    Given user is on the home page
    When clicks on the Sign In link
    And enters Email "<email>", Password "<password>"
    And clicks on the signIn button
    Then user should see a welcome user message "<first_name> <last_name>"
    And user clicks sign out
    Examples:
      | email               | password  | first_name | last_name |
      | sekharan7@gmail.com | Password1 | Rajasekhar | Yerva     |


  Scenario Outline: Login with invalid credentials
    Given user is on the home page
    When clicks on the Sign In link
    And enters Email "<email>", Password "<password>"
    And clicks on the signIn button
    Then user should see a login error message "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."
    Examples:
      | email                | password  |
      | john.doe@example.com | Password1 |