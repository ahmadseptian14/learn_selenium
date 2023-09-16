@All
Feature: Repository

  @Github @Positive @CreateRepository
  Scenario Outline: Create Repository
    Given User is on the Github login page
    When User add <username> and <password>
    And User click login button
    Then User should be on the Github dashboard
    When User click profile menu
    And User click Repository menu
    Then User is in list Repository page
    When User click new Repository button
    Then User is in create a new Repository page
    When User fill <repository_name> and <description>
    And User choose private
    And User check add Readme file
    And User click create Repository button
    Then User is in Repository detail page

    Examples:
    | username | password | repository_name | description |
    | ahmadseptian14 | septian140900 | test | test        |
