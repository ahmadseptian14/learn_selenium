@All
  Feature: Para Bank Registration

    @Positive @register
      Scenario: Success Register
        Given  User is on parabank homepage
        When User click register link button
        Then User is in register page
        When User input name
        And User input address detail
        And User fill valid username and password
        And User input password confirmation
        When User click register button
        Then User registration successfully

    @Negative @register
      Scenario: Failed Register - Missmatch Password
      Given User is on parabank homepage
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input invalid password confirmation
      When User click register button
      Then User get error password did not match


