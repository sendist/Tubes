package stepdefinitions.WebTesting;

import io.cucumber.java.en.*;
import utils.HelperClass;

import org.junit.Assert;

import actions.CartPageActions;
import actions.HomePageActions;
import actions.LoginPageActions;

public class CartSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    CartPageActions objCart = new CartPageActions();
    
    String url = "https://www.saucedemo.com/";
	@Given("User is on Swag Labs Cart page")
	public void user_is_on_swag_lab_cart_page() {
		//navigate to url website
		HelperClass.openPage(url);
        objLogin.loginStep("standard_user", "secret_sauce");
        objCart.goToCartStep();
	}

    // @When("User clicks the Continue Shopping button")
	// public void user_clicks_the_continue_shopping_button() {
	// 	objHome.addToCartStep();
	// }
}
