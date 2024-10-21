Feature: Login Validation

  Background:
   # Given user is able to navigate and access to HRMS page

  @1 @Smoke @Regression
    Scenario Outline: Login with incorrect details
      When user enters "<username>" and "<password>"
      And user click on login button
      Then user gets an "<error message>" according to the type of incorrect data
      And user can enter both username and password again
      Examples:
        | username | password | error message |
        |admin     |321mrhn@muH|Invalid credentials|
        |administr |Hum@nhrm123|Invalid credentials|
        |admin     |           |Password is Empty  |
        |          |Hum@nhrm123|Username cannot be empty|

