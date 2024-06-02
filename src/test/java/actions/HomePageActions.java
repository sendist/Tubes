package actions;


import locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class HomePageActions {
    HomePageLocators homePageLocators = null;

    public HomePageActions() {
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(HelperClass.getDriver(),homePageLocators);
    }

    public WebElement getDashboard() {
        return(homePageLocators.Dashboard);
    }

    public WebElement getSideBarButton() {
        return(homePageLocators.sideBarButton);
    }

    public WebElement getLogoutButton() {
        return(homePageLocators.logoutButton);
    }

    public void addToCartStep() {
        homePageLocators.addToCartBtn.click();
    }

    public WebElement getNotification() {
        return(homePageLocators.notification);
    }

    public void removeProductStep() {
        homePageLocators.removeBtn.click();
    }

    public WebElement getAddToCartBtn() {
        return(homePageLocators.addToCartBtn);
    }

    public void clickProductNameInCatalogStep() {
        homePageLocators.productName.click();
    }

    public WebElement getProductDetail() {
        return(homePageLocators.ProductDetail);
    }

    public WebElement getSidebarMenu() {
        return (homePageLocators.Menu);
    }

    public WebElement getAbout() {
        return (homePageLocators.AboutBtn);
    }

    public WebElement getCloseBtn() {
        return (homePageLocators.CloseBtn);
    }
}
