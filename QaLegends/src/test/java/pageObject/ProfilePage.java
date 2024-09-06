package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class ProfilePage {
	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Email\"]")
	WebElement emailEditButton;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement updateButton;
	@FindBy(xpath="//div[@class=\"toast-message\"]")
	WebElement profileUpdateMessage;

	public void enterMailId(String emailUpdate) {
		emailEditButton.clear();
		emailEditButton.sendKeys(emailUpdate);
	}

	public HomePage clickOnUpdateButton() {
		updateButton.click();
		return new HomePage(driver);
	}
	public String getUpdatedEmailText() {
		return emailEditButton.getText();
	}
	public boolean isProfileUpdateMsgDisplayed() {
		return WebElementUtility.isElementDisplayed(profileUpdateMessage);
	}

}
