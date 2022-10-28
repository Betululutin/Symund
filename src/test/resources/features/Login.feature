@SYMU-1616
Feature: Symund app login feature

  User Story:
  As a user, I should be able to login.

  Background: Assuming user is in login page
     Given user is on the login page

  @SYMU-1609
  Scenario: User should be able to login with valid credentials
    When user enters valid username
    And user enters valid password
    And user clicks on login Button
    Then user should land on the dashboard page

  @SYMU-1610
  Scenario: User can not Login with invalid credentials
    When user enters invalid username
    And user enters invalid password
    And user clicks on login Button
    Then Wrong username or password should be displayed for invalid credentials

  @SYMU-1611
  Scenario: Login with empty credentials
    When username input box left blank
    And user clicks on login Button
    Then "Please fill out this field" message should be displayed if the password or username is empty

   @SYMU-1612
  Scenario: User can see the password in form of dots by default
    When user enters valid password
    Then User can see the password in form of dots

   @SYMU-1613
  Scenario: User can see the password explicitly if needed
    When user enters valid username
    And user enters valid password
    Then User can see the password explicitly

    @SYMU-1614
  Scenario:User can see the Forgot password link on the login page and can see the "Reset password" button on the next page after clicking on forget password link
    When user clicks on the Forgot password link
    Then user can see the Reset password button on the next page after clicking on forget password link

   @SYMU-1615
  Scenario: User can see valid placeholders on Username and Password fields
    Then User is able to see valid placeholders on Username and Password fields















