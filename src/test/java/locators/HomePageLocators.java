package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
    @FindBy(className = "app_logo")
    public WebElement Dashboard;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement sideBarButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBtn;

    @FindBy(className = "shopping_cart_badge")
    public WebElement notification;

    @FindBy(className = "inventory_item_name")
    public WebElement productName;

    @FindBy(className = "inventory_details")
    public WebElement ProductDetail;

    @FindBy(className = "bm-menu")
    public WebElement Menu;

    @FindBy(id = "about_sidebar_link")
    public WebElement AboutBtn;

    @FindBy(className = "bm-cross-button")
    public WebElement CloseBtn;

}
