package stepdefinitions.WebTesting;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Product;
import utils.HelperClass;

import org.junit.Assert;

import actions.HomePageActions;
import actions.LoginPageActions;
import actions.ProductDetailPageActions;

public class ProductDetailSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    ProductDetailPageActions objProductDetail = new ProductDetailPageActions();

    @When("The user clicks on the product card to view its details")
    public void the_user_clicks_on_the_product_card_to_view_its_details() {
        objProductDetail.clickProductCardLink();
    }

    @Then("The user is navigated to the product detail page")
    public void the_user_is_navigated_to_the_product_detail_page() {
        Assert.assertTrue(objProductDetail.getProductDetail().isDisplayed());
    }

    @Then("There is also an \"Add to Cart\" button to add the product to the cart")
    public void there_is_also_an_add_to_cart_button_to_add_the_product_to_the_cart() {
        Assert.assertTrue(objProductDetail.getAddToCartButton().isDisplayed());
    }

    @Given("The product has not been added to the cart")
    public void the_product_has_not_been_added_to_the_cart() {
        Assert.assertTrue(objProductDetail.getAddToCartButtonOnesie().isDisplayed());
    }

    @When("The user clicks the \"Add to Cart\" button")
    public void the_user_clicks_the_add_to_cart_button() {
        objProductDetail.addOnesieToCart();
    }

    @Then("The user sees the \"Add to Cart\" button change to a red \"Remove\" button")
    public void the_user_sees_the_add_to_cart_button_change_to_a_red_remove_button() {
        Assert.assertTrue(objProductDetail.getRemoveButtonOnesie().isDisplayed());
    }

    @Then("The cart\\/trolley icon shows an incremented item count with a red background")
    public void the_cart_trolley_icon_shows_an_incremented_item_count_with_a_red_background() {
        Assert.assertTrue(objProductDetail.getItemCartCountBadge().isDisplayed());
    }

    @Given("The product has been added to the cart")
    public void the_product_has_been_added_to_the_cart() {
        objProductDetail.addOnesieToCart();
        Assert.assertTrue(objProductDetail.getRemoveButtonOnesie().isDisplayed());
    }

    @When("The user clicks the red \"Remove\" button")
    public void the_user_clicks_the_red_remove_button() {
        objProductDetail.removeOnesieToCart();
    }

    @Then("The user sees the \"Remove\" button change to an \"Add to Cart\" button")
    public void the_user_sees_the_remove_button_change_to_an_add_to_cart_button() {
        Assert.assertTrue(objProductDetail.getAddToCartButtonOnesie().isDisplayed());
    }

    @Then("The cart\\/trolley icon shows a decremented item count with a red background")
    public void the_cart_trolley_icon_shows_a_decremented_item_count_with_a_red_background() {
        Assert.assertTrue(objProductDetail.isCartCountBadgeDisplayed() == false);
    }

}
