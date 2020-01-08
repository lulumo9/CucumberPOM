Feature: Login functionality on the onlineShop with an already registered user

  Scenario: User login successful with a valid username and password

    Given user is already on the login page
    When title of the page is Welcome to SportsBet!
    And enters a valid username and password
    And click on login button
    Then account page should be displayed

  Scenario: Error message is displayed when user tries to login with an invalid password

    Given user is already on the login page
    When title of the page is Welcome to SportsBet!
    And enters and invalid password
    And click on login button
    Then error message is displayed