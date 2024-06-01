package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locators.LoginPageLocators;
import utils.HelperClass;


public class LoginPageActions {

  LoginPageLocators loginPageLocators = null;

  public LoginPageActions() {
    this.loginPageLocators = new LoginPageLocators();
    PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
  }

  public void loginStep(String username, String password) {
    loginPageLocators.username.sendKeys(username);
    loginPageLocators.password.sendKeys(password);
    loginPageLocators.loginButton.click();
  }

  //action to get error message when invalid credential
  public String getErrorMessage() {
    return(loginPageLocators.errorMessage.getText());
  }
}