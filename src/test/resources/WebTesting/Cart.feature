Feature: Cart

  Background:
    Given User is on Swag Labs Cart page

  @NavigateToTheProductPage(ContinueShopping) @TC04
  Scenario: Navigate to the product page (Continue Shopping)
    When User clicks the Continue Shopping button
    Then The user will be redirected to the dashboard page with the title Products

  @RemovingAProductFromCart @TC06
  Scenario: Removing a product from cart
    Given There is at least one product in the cart
    When The user clicks the Remove button on the product which wants to remove from the cart
    Then User should not be able to see deleted products anymore