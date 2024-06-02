package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageLocators { 
    @FindBy(id = "cart_contents_container")
    public WebElement Cart;
    
    @FindBy(className = "shopping_cart_link")
    public WebElement cartBtn;
    
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
}
