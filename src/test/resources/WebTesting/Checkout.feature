Feature: Checkout

  Background:
    Given User has an item in the cart

    @FillingCheckoutInformationFormWithValidData @TC01
    Scenario: Filling Checkout Information form with valid data
        Given User has clicked the Checkout button on the Cart page
        When User enters firstname as "Lebron", lastname as "James", and postalCode as "40121"
        Then User should be redirected to the Shipping Information page
        And User should see an overview of the items purchased

    @CompletingCheckoutProcessByClickingFinishButton @TC01
    Scenario: Completing checkout process by clicking Finish button
        Given User has clicked the Checkout button on the Cart page
        And User has filled out the form on the Checkout Information page with valid data
        When User click the Finish button
        Then Application should display the Checkout Complete page
        And User should see "Thank you for your order!" message on the Checkout Complete page
        And There should be a "Back To Home" button on the Checkout Complete page

    @ClickingBackToHomeButtonOnCheckoutCompletePage @TC01
    Scenario: Clicking "Back To Home" button on Checkout Complete page
        Given User has clicked the Checkout button on the Cart page
        And User has filled out the form on the Checkout Information page with valid data
        And Current page is the Checkout Complete page
        When User click the Back To Home button
        Then User should be redirected to the Dashboard