package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageLocators {
    @FindBy(id = "first-name")
    public WebElement firstname;

    @FindBy(id = "last-name")
    public WebElement lastname;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(className = "cart_list")
    public WebElement overviewItems;

    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(className = "complete-header")
    public WebElement messageThx;

    @FindBy(id = "back-to-products")
    public WebElement backToProductBtn;
    
}
