Feature: Product Detail

    Background:
        Given User is on Swag Labs Dashboard page

    @VerifyProductDetailPage @TC01
    Scenario: Verify Product Detail page
        When The user clicks on the product card to view its details
        Then The user is navigated to the product detail page
        And There is also an "Add to Cart" button to add the product to the cart

    @AddProducttoCartbyClicking"AddtoCart"onProductDetailPage @TC02
    Scenario: Add Product to Cart by Clicking "Add to Cart" on Product Detail Page
        Given The product has not been added to the cart
        When The user clicks the "Add to Cart" button
        Then The user sees the "Add to Cart" button change to a red "Remove" button
        And The cart/trolley icon shows an incremented item count with a red background

    @RemoveProductfromCartbyClicking"Remove"onProductDetailPage @TC06
    Scenario: Remove Product from Cart by Clicking "Remove" on Product Detail Page
        Given The product has been added to the cart
        When The user clicks the red "Remove" button
        Then The user sees the "Remove" button change to an "Add to Cart" button
        And The cart/trolley icon shows a decremented item count with a red background