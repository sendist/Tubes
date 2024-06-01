package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;

import actions.LoginPageActions;
import utils.HelperClass;
import actions.HomePageActions;

public class LoginSteps {
	
	LoginPageActions objLogin = new LoginPageActions();
	HomePageActions objHomePage = new HomePageActions();

	String url = "https://www.saucedemo.com/";
	@Given("User is on Swag Labs Login page")
	public void user_is_on_swag_lab_login_page() {
		//navigate to url website
		HelperClass.openPage(url);
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		// login to application
		objLogin.loginStep(username, password);
	}

	@Then("User should be able to login successfully and navigated to dashboard page")
	public void user_should_be_able_to_login_successfully_and_navigated_to_dashboard_page() {
		// valid login and navigated to dashboard page
		Assert.assertTrue(objHomePage.getDashboard().isDisplayed());
	}

	@Then("User should see an error message {string}")
	public void user_should_be_able_to_see_a_error_message(String errorMessage) {
		System.out.println(objLogin.getErrorMessage());
		Assert.assertEquals(errorMessage, objLogin.getErrorMessage());
	}

}
