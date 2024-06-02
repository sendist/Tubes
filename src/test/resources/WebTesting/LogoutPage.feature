Feature: Logout from Swag Labs Application

  @Logout @TC07
  Scenario: User Logout
    Given User is on Swag Labs Login page
    And User enters username as "standard_user" and password as "secret_sauce"
    And User login successfully and navigated to dashboard page
    When User click hamburger menu
    And User click on logout button
    Then User navigate to login page
