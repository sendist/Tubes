Feature: Dashboard

  Background:
    Given User is on Swag Labs Dashboard page

  @AddOneProductfromCatalogToCart @TC01
  Scenario: Add One Product from Catalog to Cart
    When The user clicks the Add to Cart button for a product
    Then The user sees the Add to Cart button change to a red Remove button
    And A notification shows one item in the cart icon

  @RemoveOneProductFromCart @TC01
  Scenario: Remove One Product from Cart
    Given The user has at least one product in the cart
    When The user clicks the Remove button for a product
    Then The user sees the Add to Cart button change to a red Remove button
    And A notification shows one item in the cart icon