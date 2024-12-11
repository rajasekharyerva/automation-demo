Feature: Registration

  Scenario Outline: Successful registration
    Given user is on the home page
    When clicks on the CreateAnAccount link
    And enters First Name "<first_name>", Last Name "<last_name>", Email "<email>", Password "<password>", Confirm Password"<confirm_password>"
    And clicks on the register button
    Then user should see a welcome message "Thank you for registering with Main Website Store."
    And user clicks sign out
    Examples:
      | first_name | last_name | email                | password  | confirm_password |
      | John       | Doe       | john.doe@example.com | Password1 | Password1        |

  @ignore
  Scenario Outline: Unsuccessful registration with an already existing email
    Given user is on the home page
    When clicks on the CreateAnAccount link
    And enters First Name "<first_name>", Last Name "<last_name>"
    And enters Email "<email>"
    And enters Password "<password>", Confirm Password"<confirm_password>"
    And clicks on the register button
    Then user should see a registration error message "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."
    Examples:
      | first_name | last_name | email                | password  | confirm_password |
      | John       | Doe       | john.doe@example.com | Password1 | Password1        |

  Scenario: Login with valid credentials
    Given user is on the home page
    When clicks on the Sign In link
    And enters static Email "", static Password ""
    And clicks on the signIn button
    Then user should see a welcome static user message ""
    And user clicks sign out


  @ignore
  Scenario Outline: Login with invalid credentials
    Given user is on the home page
    When clicks on the Sign In link
    And enters Email "<email>", Password "<password>"
    And clicks on the signIn button
    Then user should see a login error message "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."
    Examples:
      | email                | password  |
      | john.doe@example.com | Password1 |