package actions;

import locators.CartPageLocators;
import locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class CartPageActions {
    HomePageLocators homePageLocators = null;
    CartPageLocators cartPageLocators = null;

    public CartPageActions() {
        this.cartPageLocators = new CartPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),cartPageLocators);
    }

    public WebElement getCart() {
        return(cartPageLocators.Cart);
    }

    public void goToCartStep() {
        cartPageLocators.cartBtn.click();
    }
}