Feature: Cart

  Background:
    Given User is on Swag Labs Cart page

  @NavigateToTheProductPage(ContinueShopping) @TC04
  Scenario: Navigate to the product page (Continue Shopping)
    When User clicks the Continue Shopping button
    Then The user will be redirected to the dashboard page with the title Products