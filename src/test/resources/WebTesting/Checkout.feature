Feature: Checkout

  Background:
    Given User is on the Cart page

    @MenuPageVerification @TC01
    Scenario: Menu page verification
        Given There is an item
        And User has clicked the Checkout button on the Cart page
        And Current page is the Checkout Information page
        When The user click the three-striped pad icon
        Then User shold be able to see a sidebar menu