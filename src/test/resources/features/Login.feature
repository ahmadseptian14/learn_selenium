@All
Feature: Login

  @Test1 @Positive @Login
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User click  login button
    Then User verify login result
    When User click menu sidebar
    And User click logout button

  @Test2 @Negative @Login
  Scenario: Login Invalid
    Given User is on login page
    When User fill invalid username and password
    And User click  login button
    Then User get error message