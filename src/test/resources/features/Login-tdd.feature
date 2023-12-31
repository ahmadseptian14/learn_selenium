Feature: Login with TDD

  @TDD
    Scenario Outline: Login with TDD
      Given User is on login page
      When User input <username> and <password>
      And User click  login button
      Then User get verify login <result>

      Examples:
      | username | password |result |
      | standard_user| secret_sauce | passed |
      | invalidUsername| secret_sauce | failed |
      | standard_user| invalidPassword | failed |

