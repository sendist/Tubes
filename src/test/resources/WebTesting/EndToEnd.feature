Feature: End to End

  Background:
    Given User is on Swag Labs Login page

  @ValidAccount @TC01
  Scenario: End to End Swablabs 
    When User enters username as "standard_user" and password as "secret_sauce"
    Then User should be redirected to the Dashboard
    When The user clicks the Add to Cart button for a product
    Then The user sees the Add to Cart button change to a red Remove button
     