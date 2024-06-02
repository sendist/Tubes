Feature: Dashboard

  Background:
    Given User is on Swag Labs Dashboard page

  @AddOneProductfromCatalogToCart @TC02
  Scenario: Add One Product from Catalog to Cart
    When The user clicks the Add to Cart button for a product
    Then The user sees the Add to Cart button change to a red Remove button
    And A notification shows one item in the cart icon

  @RemoveOneProductFromCart @TC04
  Scenario: Remove One Product from Cart
    Given The user has at least one product in the cart
    When The user clicks the Remove button for a product
    Then The user sees the Remove button change to an Add to Cart button

  @NavigateToProductDetailPageByClickingProductName @TC07
  Scenario: Navigate to Product Detail Page by Clicking Product Name
    When The user clicks a product name in the catalog
    Then The user is navigated to the Product Detail page