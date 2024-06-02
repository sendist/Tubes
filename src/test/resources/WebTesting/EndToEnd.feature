Feature: End to End

  Background:
    Given User is on Swag Labs Login page

  @ValidAccount @TC01
  Scenario: End to End Swablabs 
    When User enters username as "standard_user" and password as "secret_sauce"
    Then User should be redirected to the Dashboard
    When The user clicks the Add to Cart button for a product
    Then The user sees the Add to Cart button change to a red Remove button
    When User clicks on the cart icon
    Then User will be navigated to the cart page
    When User clicks on the Checkout Button
    Then User navigated to Checkout Information Page
    When User enters firstname as "Lebron", lastname as "James", and postalCode as "40121"
    Then User should be redirected to the Shipping Information page
    When User click the Finish button
    Then Application should display the Checkout Complete page
    And User should see "Thank you for your order!" message on the Checkout Complete page
    And There should be a "Back To Home" button on the Checkout Complete page
    When User click the Back To Home button
    Then User should be redirected to the Dashboard
