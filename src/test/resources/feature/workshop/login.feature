@screen
Feature: Login

  Scenario: Login successfully
    Given I access the login page.
    And I insert valid credentials.
    When I click on login button.
    Then I check if the user was logged in.

  Scenario: Login with wrong credentials
    Given I access the login page.
    And I insert invalid credentials.
    When I click on login button.
    Then I expect invalid credentials message.

  Scenario: Login with no password
    Given I access the login page.
    When I enter "eu@fast.com"/"" credentials.
    And I click on login button.
    Then I expect "Please enter your password!" error message.

  Scenario: Login with no user
    Given I access the login page.
    When I enter ""/"eu.pass" credentials.
    And I click on login button.
    Then I expect "Please enter your email!" error message.

  Scenario: Login with no user and no password
    Given I access the login page.
    When I enter ""/"" credentials.
    And I click on login button.
    Then I expect "Please enter your email!" error message.

  Scenario Outline: Failed login
    Given I access the login page.
    When I enter "<email>"/"<password>" credentials.
    And I click on login button.
    Then I expect "<message>" error message.
    Examples:
      | email       | password | message                     |
      | aa@fast.com |          | Please enter your password! |
      |             | aaa.pass | Please enter your email!    |
      |             |          | Please enter your email!    |
      | aa@fast.com | aaa.pas  | Invalid user or password!   |

  Scenario: Logout success
    Given I successfully login.

