@SYMU-1706
Feature: Symund app logout feature

  User Story:
  As a user, I should be able to log out.

  Background: Assuming user is on dashboard page
    Given user is on the dashboardpage

    @SYMU-1704
    Scenario: User can log out and ends up in login page
    When user clicks on the log out button
    Then user should land on the log in page

   @SYMU-1705
   Scenario: User cannot go to home page again by clicking step back button after successfully logged out
    When user clicks on the log out button
    And user should land on the log in page
    Then user cannot go back by clicking log out

