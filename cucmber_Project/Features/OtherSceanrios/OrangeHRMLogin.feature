
@tag
Feature: Check login functionality
  

  @tag1
  Scenario: Check login functionality with valid credentials
  
    Given User is on login page
    When User enters valid username and password
    And Click on login button
    Then User is navigated to the home page
    

