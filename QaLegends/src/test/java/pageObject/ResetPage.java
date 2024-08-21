package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;

	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement emailAddressField;
	@FindBy(xpath = "//strong[text()=\"We can't find a user with that e-mail address.\"]")
	WebElement errormsg;
	@FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
	WebElement setPwResetButton;
	@FindBy(xpath = "//div[@class=\"alert alert-success\"]")
	WebElement validMessage;

	public void enterEmailAddress(String emailAddress) {
		emailAddressField.sendKeys(emailAddress);
	}

	public String getResetErrorMsg() {
		String resetError = errormsg.getText();
		return resetError;
	}

	public void clickOnPwResetButton() {
		setPwResetButton.click();
	}

	public String getResetValidMsg() {
		String resetValidMssg = validMessage.getText();
		return resetValidMssg;

	}
}
