package stepdefinitions.WebTesting;

import io.cucumber.java.en.*;
import utils.HelperClass;

import org.junit.Assert;

import actions.HomePageActions;
import actions.LoginPageActions;

public class DashboardSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    
    String url = "https://www.saucedemo.com/";
	@Given("User is on Swag Labs Dashboard page")
	public void user_is_on_swag_lab_dashboard_page() {
		//navigate to url website
		HelperClass.openPage(url);
        objLogin.loginStep("standard_user", "secret_sauce");
	}

    @When("The user clicks the Add to Cart button for a product")
	public void the_user_clicks_the_add_to_cart_button_for_a_product() {
		objHome.addToCartStep();
	}

    @Then("The user sees the Add to Cart button change to a red Remove button")
	public void the_user_sees_the_add_to_cart_button_change_to_a_red_remove_button() {
		Assert.assertTrue(objHome.getDashboard().isDisplayed());
	}

    @Then("A notification shows one item in the cart icon")
	public void a_notification_shows_one_item_in_the_cart_icon() {
		Assert.assertTrue(objHome.getNotification().isDisplayed());
	}

}
