Feature: Menu

  Background:
    Given User is on the dashboard page

    @MenuPageVerification @TC01
    Scenario: Menu page verification
        When The user click the three-striped pad icon
        Then User shold be able to see a sidebar menu

    @NavigateToTheAboutPage @TC02
    Scenario: Navigate to the about page
        When The user click the three-striped pad icon
        And The user click the “About” menu on the sidebar
        Then User will be navigated to the saucelabs website
    
    @CloseSidebarMenu @TC02
    Scenario: Close Sidebar Menu
        When The user click the three-striped pad icon
        And The user click close button on the sidebar
        Then User should not be able to see the sidebar menu
        And User will still in the current page