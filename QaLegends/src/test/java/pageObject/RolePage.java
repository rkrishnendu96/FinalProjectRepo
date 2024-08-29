package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolePage {
	WebDriver driver;

	public RolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"username\"]")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
	WebElement loginbutton;

	public void enterUserName(String userName) {
		usernameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public HomePage loginClick() {
		loginbutton.click();
		return new HomePage(driver);
	}

}
