package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement usernameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement loginButton;
	@FindBy(xpath = "//strong[text()=\"These credentials do not match our records.\"]")
	WebElement invalidMessage;
	@FindBy(xpath = "//a[@class=\"btn btn-link\"]")
	WebElement forgotYourPw;

	public void enterUsername(String userName) {
		usernameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}

	public String getActualErrorMessageText() {
		String errorMsgText = invalidMessage.getText();
		return errorMsgText;
	}

	public ResetPage forgotYourPwClick() {
		forgotYourPw.click();
		return new ResetPage(driver);
	}
	

}
