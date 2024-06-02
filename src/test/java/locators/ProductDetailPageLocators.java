package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPageLocators {
    @FindBy(id= "item_4_title_link")
    public WebElement productCardLink;

    @FindBy(className = "inventory_details")
    public WebElement productDetailCard;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement addToCartButtonOnesie;

    @FindBy(id = "remove-sauce-labs-onesie")
    public WebElement removeButtonOnesie;

    @FindBy(className = "shopping_cart_badge")
    public WebElement itemCartCountBadge;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartLink;

    @FindBy(className = "inventory_item_name")
    public WebElement inventoryItemName;

    @FindBy(className = "cart_list")
    public WebElement cartList;
}
