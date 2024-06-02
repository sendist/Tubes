package actions;

import locators.CheckoutPageLocators;
import utils.HelperClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageActions {
    CheckoutPageLocators checkoutPageLocators = null;

    public CheckoutPageActions() {
        this.checkoutPageLocators = new CheckoutPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),checkoutPageLocators);
    }

    public void checkoutSteps(String firstname, String lastname, String postalCode) {
        checkoutPageLocators.firstname.sendKeys(firstname);
        checkoutPageLocators.lastname.sendKeys(lastname);
        checkoutPageLocators.postalCode.sendKeys(postalCode);
        checkoutPageLocators.continueBtn.click();
    }

    public WebElement getOverviewItems() {
        return (checkoutPageLocators.overviewItems);
    }

    public WebElement getFinishBtn() {
        return (checkoutPageLocators.finishBtn);
    }

    public String getMessageThx() {
        return(checkoutPageLocators.messageThx.getText()); 
    }

    public WebElement getBackToProductBtn() {
        return (checkoutPageLocators.backToProductBtn);
    }

}
