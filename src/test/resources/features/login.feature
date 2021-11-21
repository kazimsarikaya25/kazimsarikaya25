@TRN-1053
Feature:All user types  should login

  Background:
    Given the user should be in the login page
  @TRN-997
  Scenario Outline: Verify that all user types can log in with the valid credantials
    When  the user should log in with "<username>" and "<password>"
    Then the user should land on the "<page>"
    Examples:
      | username        | password    | page            |
      | user1           | UserUser123 | Quick Launchpad |
      | Salesmanager101 | UserUser123 | Dashboard       |
      | storemanager51  | UserUser123 | Dashboard       |

  @TRN-1046
  Scenario Outline: Verify that all user types can not log in with the invalid credantials
    When  the user should not log in with "<username>" and "<password>"
    Then user verify the allertmessage
    Examples:
      | username        | password    |
      | user1kzm        | UserUser123 |
      | Salesmanager25  | UserUser123 |
      | storekzm77      | UserUser123 |
      | user1           | kzm         |
      | Salesmanager101 | 25          |
      | storemanager51  | 1234        |
  @TRN-1047
  Scenario Outline: All user types can see own name on the page
    When  the user should log in with "<username>" and "<password>"
    Then the user should see "<ownname>" on the page
    Examples:
      | username        | password    | ownname  |
      | user1           | UserUser123 | John Doe |
      | Salesmanager101 | UserUser123 | John Doe |
      | storemanager51  | UserUser123 | John Doe |

  @TRN-1048
  Scenario Outline: Invaid username and password message should displayed after invalid credentials
    When the user should not log in with "<username>" and "<password>"
    Then user can see the "Invalid user name or password." message
    Examples:
      | username        | password    |
      | user1kzm        | UserUser123 |
      | Salesmanager25  | UserUser123 |
      | storekzm77      | UserUser123 |
      | user1           | kzm         |
      | Salesmanager101 | 25          |
      | storemanager51  | 1234        |
  @TRN-1049
  Scenario: User should see the password in bullet signs by default
    When the user should see the bullet sign writing own password
  @TRN-1050
  Scenario:  User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    When user should click the forgot password button
    Then user should land on the "Forgot Password" page
  @TRN-1051
  Scenario:  User can see "Remember me on this computer" link on the login page and it should be clickable
    When user should see the "Remember me on this computer" message
    And remember me checbox should be clickable
    Then remember me message should be clickable
  @TRN-1052
  Scenario Outline: Verify that user can use "Enter" key from their keyboard on the login page
    When the user can click the enter button after write their "<username>"
    Then  the user can click the enter button after write their own "<password>"
    And the user can click the enter button to log in the "<page>"
    Examples:
      | username        | password    | page            |
      | user1           | UserUser123 | Quick Launchpad |
      | Salesmanager101 | UserUser123 | Dashboard       |
      | storemanager51  | UserUser123 | Dashboard       |
