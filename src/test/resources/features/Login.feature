@login
Feature: Gmail Login

  Background:
    Given user should be on the gmail sign in page


  Scenario: Login Successfully
    When user enters valid username
    And clicks forward button
    When user enters valid password
    And clicks forward button
    Then user should be able to login


  Scenario: Login Fail
    When user enters invalid username
    And clicks forward button
    Then user should see the "Oturumunuz açılamadı" message


  Scenario: Login Fail With Wrong Username
    When user enters wrong username
    And clicks forward button
    Then user should see the Your Google Account was not found message


  Scenario: Login Fail With Wrong Password
    When user enters valid username
    And clicks forward button
    When user enters invalid password
    And clicks forward button
    Then user should not be able to login


  Scenario: Empty Username
    When clicks forward button
    Then user should see the empty warning message for username


  Scenario: Empty Password
    When user enters valid username
    And clicks forward button
    And waits for password screen to load
    And clicks forward button
    Then user should see the empty warning message for password

