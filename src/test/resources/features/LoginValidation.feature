Feature: Login Validation

  Background:
   # Given user is able to navigate and access to HRMS page

@Smoke @Regression @Login
  Scenario: Login with empty username field
    When user enters valid password
    And user click on login button
    Then user gets an error message: Username cannot be empty.
    And user can enter both username and password again

  @Smoke @Regression @Login
  Scenario: Login with empty password field
      When user enters valid username
      And user click on login button
      Then user gets an error message: Password is empty.
      And user can enter both username and password again

  @Smoke @Regression @Login
  Scenario: Login with incorrect credentials (username)
    When user enters invalid username
    And user enters valid password
    And user click on login button
    Then user gets an error message: Invalid credentials.
    And user can enter both username and password again

  @Smoke @Regression @Login
  Scenario: Login with incorrect credentials (password)
    When user enters valid username
    And user enters invalid password
    And user click on login button
    Then user gets an error message: Invalid credentials.
    And user can enter both username and password again
