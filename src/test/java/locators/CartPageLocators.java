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
    
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeProductFromCartBtn;
    
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    
    @FindBy(className = "inventory_item_name")
    public WebElement productName;
    
    @FindBy(className = "inventory_item_desc")
    public WebElement productDesc;
    
    @FindBy(className = "inventory_item_price")
    public WebElement productPrice;
}
