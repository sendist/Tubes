package stepdefinitions.WebTesting;

import io.cucumber.java.en.*;
import utils.HelperClass;

import org.junit.Assert;

import actions.CartPageActions;
import actions.HomePageActions;
import actions.LoginPageActions;

public class EndSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    CartPageActions objCart = new CartPageActions();

    @When("User clicks on the Checkout Button")
    public void user_clicks_on_the_checkout_button() {
        objCart.checkoutStep();
    }

    String checkoutInfoUrl = "https://www.saucedemo.com/checkout-step-one.html";

    @Then("User navigated to Checkout Information Page")
    public void User_navigated_to_checkout_information_page() throws InterruptedException {
        // User logout successfully and navigated
        String currentUrl = HelperClass.getCurrentUrl();
        Assert.assertEquals(checkoutInfoUrl, currentUrl);
        Thread.sleep(2000);
    }
}
