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
}
