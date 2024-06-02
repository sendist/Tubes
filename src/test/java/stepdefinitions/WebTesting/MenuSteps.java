package stepdefinitions.WebTesting;

import org.junit.Assert;

import actions.HomePageActions;
import actions.LoginPageActions;
import io.cucumber.java.en.*;
import utils.HelperClass;

public class MenuSteps {
    HomePageActions objHome = new HomePageActions();
    LoginPageActions objLogin = new LoginPageActions();
    
    String url = "https://www.saucedemo.com/";
	@Given("User is on the dashboard page")
	public void user_is_on_the_dashboard_page() {
		//navigate to url website
		HelperClass.openPage(url);
        objLogin.loginStep("standard_user", "secret_sauce");
	}

    @When("The user click the three-striped pad icon")
    public void the_user_click_three_striped_pad_icon() throws InterruptedException {
        objHome.getSideBarButton().click();
        Thread.sleep(2000);
    }

    @Then("User shold be able to see a sidebar menu")
	public void user_should_be_able_to_see_a_sidebar_menu() throws InterruptedException  {
		Assert.assertTrue(objHome.getSidebarMenu().isDisplayed());
        Thread.sleep(2000);
	}

    @When("The user click the “About” menu on the sidebar")
    public void the_user_click_the_about_menu_on_the_sidebar() throws InterruptedException {
        objHome.getAbout().click();
        Thread.sleep(2000);
    }

    String swaglabsUrl = "https://saucelabs.com/";
    @Then("User will be navigated to the saucelabs website")
    public void user_will_be_navigated_to_the_saucelabs_website() throws InterruptedException {
        // User logout successfully and navigated
        String currentUrl = HelperClass.getCurrentUrl();
        Assert.assertEquals(swaglabsUrl, currentUrl);
        Thread.sleep(2000);
    }

    @When("The user click close button on the sidebar")
    public void the_user_click_close_button_on_the_sidebar() throws InterruptedException {
        objHome.getCloseBtn().click();
        Thread.sleep(2000);
    }

    @Then("User should not be able to see the sidebar menu")
    public void user_should_not_be_able_to_see_a_sidebar_menu() throws InterruptedException {
        Assert.assertTrue(objHome.getSideBarButton().isDisplayed());
        Thread.sleep(2000);
    }

    String pageUrl = "https://www.saucedemo.com/inventory.html";
    @Then("User will still in the current page")
    public void user_will_still_in_the_current_page() throws InterruptedException {
        // User logout successfully and navigated
        String currentUrl = HelperClass.getCurrentUrl();
        Assert.assertEquals(pageUrl, currentUrl);
        Thread.sleep(2000);
    }
}
