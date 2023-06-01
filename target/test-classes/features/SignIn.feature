@Regression
Feature: Sign in/Sign Up Features

  Background: 
    Given User is on retail website
    When User click on Sign in option

  Scenario: Verify user can sign in into Retail Application
    And User enter email 'bn200@gmail.com' and password 'Bahar@123'
    And User click on login button
    Then User should be logged in into Account

  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name | email               | password  | confirmPassword |
      | John | johnN800@gmail.com | John@1234 | John@1234       |
    And User click on SignUp button
    Then User should be logged into account page
