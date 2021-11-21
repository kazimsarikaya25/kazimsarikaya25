@TRN-1078
Feature:All user types should logout

  Background:
    Given the user should be in the login page
  @TRN-1075
  Scenario Outline:  Verify that all users can log out by using log out button inside profile info and ends up in login page.
    When  the user should log in with "<username>" and "<password>"
    Then the user should log out after clicking the log out button
    And the user should land on the "Login" page
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | Salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |
  @TRN-1076
  Scenario Outline:  Verify that all users can not go to the home page again clicking the back button after successfully logged out.
    When  the user should log in with "<username>" and "<password>"
    Then the user should log out after clicking the log out button
    And the user should land on the "Login" page
    And the user should click the back button
    And verify the user is on the "Login" page
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | Salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |
  @TRN-1077
  Scenario Outline:  Verify that all user types can not log in after close the page
    When  the user should log in with "<username>" and "<password>"
    Then the user should close the page
    Given the user should be in the login page
    And the user should land on the "Login" page
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | Salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |