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

}
