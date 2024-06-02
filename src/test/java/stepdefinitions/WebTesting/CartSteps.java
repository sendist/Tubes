package stepdefinitions.WebTesting;

import io.cucumber.java.en.*;
import utils.HelperClass;

import org.junit.Assert;

import actions.CartPageActions;
import actions.HomePageActions;
import actions.LoginPageActions;
import actions.ProductDetailPageActions;

public class CartSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    CartPageActions objCart = new CartPageActions();
    ProductDetailPageActions objProductDetail = new ProductDetailPageActions();
    
    String url = "https://www.saucedemo.com/";
	@Given("User is on Swag Labs Cart page")
	public void user_is_on_swag_lab_cart_page() {
		//navigate to url website
		HelperClass.openPage(url);
        objLogin.loginStep("standard_user", "secret_sauce");
        objCart.goToCartStep();
	}

    @When("User clicks the Continue Shopping button")
	public void user_clicks_the_continue_shopping_button() {
		objCart.goToContinueShoppingStep();
	}

    @Then("The user will be redirected to the dashboard page with the title Products")
	public void the_user_will_be_redirected_to_the_dashboard_page_with_the_title_products() {
		Assert.assertTrue(objHome.getDashboard().isDisplayed());
	}

    @Given("There is at least one product in the cart")
	public void there_is_at_least_one_product_in_the_cart() {
		this.user_clicks_the_continue_shopping_button();
        objHome.addToCartStep();
	}

    @When("The user clicks the Remove button on the product which wants to remove from the cart")
	public void the_user_clicks_the_remove_button_on_the_product_which_wants_to_remove_from_the_cart() {
		objCart.removeProductFromCartStep();
	}

    @Then("User should not be able to see deleted products anymore")
	public void user_should_not_be_able_to_see_deleted_products_anymore() {
		objProductDetail.getCartLink().click();
        Assert.assertTrue(objProductDetail.getCartListCount() <= 2);
	}

    @When("User clicks on the cart icon")
	public void user_clicks_on_the_cart_icon() {
        objCart.goToCartStep();
	}

    @Then("User will be navigated to the cart page")
	public void user_will_be_navigated_to_the_cart_page() {
		Assert.assertTrue(objCart.getCart().isDisplayed());
	}

    @Then("User will see information product in the cart")
	public void user_will_see_information_product_in_the_cart() {
		Assert.assertTrue(objCart.getProductName().isDisplayed());
		Assert.assertTrue(objCart.getProductDesc().isDisplayed());
		Assert.assertTrue(objCart.getProductPrice().isDisplayed());
	}
}
