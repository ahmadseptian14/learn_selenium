@All
Feature: Login

  @Github @Positive @Login
  Scenario: Login with valid credential
    Given User is on github homepage
    When User click Sign in link button
    Then User is in Login page
    When User fill field username and password
    And User click Sign in button
    Then User is in Dashboard page