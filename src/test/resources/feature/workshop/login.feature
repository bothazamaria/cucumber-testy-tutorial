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