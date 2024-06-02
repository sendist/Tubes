package stepdefinitions.WebTesting;

import io.cucumber.java.en.*;
import utils.HelperClass;

import org.junit.Assert;

import actions.CartPageActions;
import actions.HomePageActions;
import actions.LoginPageActions;
import actions.CheckoutPageActions;

public class CheckoutSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    CartPageActions objCart = new CartPageActions();
    CheckoutPageActions objCheckout = new CheckoutPageActions();
    
    String url = "https://www.saucedemo.com/";
	@Given("User has an item in the cart")
	public void user_has_an_item_in_the_cart() throws InterruptedException{
		//navigate to url website
		HelperClass.openPage(url);
        objLogin.loginStep("standard_user", "secret_sauce");
        Thread.sleep(2000);
        objHome.addToCartStep();
        Thread.sleep(2000);
        objCart.goToCartStep();
        Thread.sleep(2000);
	}

    @Given("User has clicked the Checkout button on the Cart page")
    public void user_has_clicked_the_checkout_button_on_the_cart_page() {;
        objCart.getCheckoutBtn();
    }

    @Given("User has filled out the form on the Checkout Information page with valid data")
    public void user_has_filled_out_the_form_on_the_checkout_information_page_with_valid_data() 
            throws InterruptedException {
        objCheckout.checkoutSteps("Leborn", "James", "40121");
        Thread.sleep(2000);
    }
    
    @When("User enters firstname as {string}, lastname as {string}, and postalCode as {string}")
    public void user_enters_username_as_and_password_as(String firstname, String lastname, String postalCode) 
            throws InterruptedException{
        // login to application
        objCheckout.checkoutSteps(firstname, lastname, postalCode);
        Thread.sleep(2000);
    }

    @Given("Current page is the Checkout Complete page")
    public void current_page_is_the_checkout_complete_page() {
        objCheckout.getFinishBtn().click();
    }

    String pageUrl = "https://www.saucedemo.com/checkout-step-two.html";

    @Then("User should be redirected to the Shipping Information page")
    public void user_should_be_redirected_to_the_shipping_information_page() throws InterruptedException {
        // User logout successfully and navigated
        String currentUrl = HelperClass.getCurrentUrl();
        Assert.assertEquals(pageUrl, currentUrl);
        Thread.sleep(2000);
    }
    
    @Then("User should see an overview of the items purchased")
    public void user_should_see_an_overview_of_the_items_purchased() {
        Assert.assertTrue(objCheckout.getOverviewItems().isDisplayed());
    }

    @When("User click the Finish button")
    public void user_click_the_finish_button() {
        objCheckout.getFinishBtn().click();
    }

    String completeUrl = "https://www.saucedemo.com/checkout-complete.html";

    @Then("Application should display the Checkout Complete page")
    public void application_should_display_the_checkout_complete_page() throws InterruptedException {
        // User logout successfully and navigated
        String currentUrl = HelperClass.getCurrentUrl();
        Assert.assertEquals(completeUrl, currentUrl);
        Thread.sleep(2000);
    }

    @Then("User should see \"Thank you for your order!\" message on the Checkout Complete page")
    public void user_should_see_thank_you_for_your_order_message_on_the_checkout_complete_page() {
        Assert.assertEquals(objCheckout.getMessageThx(), "Thank you for your order!");
    }

    @Then("There should be a \"Back To Home\" button on the Checkout Complete page")
    public void there_should_be_a_back_to_home_button_on_the_checkout_complete_page() {
        Assert.assertTrue(objCheckout.getBackToProductBtn().isDisplayed());
    }

    @When("User click the Back To Home button")
    public void user_click_the_back_to_home_button() throws InterruptedException {
        objCheckout.getBackToProductBtn().click();
        Thread.sleep(2000);
    }

    String dashboardUrl = "https://www.saucedemo.com/inventory.html";

    @Then("User should be redirected to the Dashboard")
    public void user_should_be_redirected_to_the_dashboard() throws InterruptedException {
        // User logout successfully and navigated
        String currentUrl = HelperClass.getCurrentUrl();
        Assert.assertEquals(dashboardUrl, currentUrl);
        Thread.sleep(2000);
    }

}
