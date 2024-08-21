package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=\"Admin \"]")
	WebElement loginName;
	@FindBy(xpath = "//button[text()=\"End tour\"]")
	WebElement endTourButton;
	@FindBy(xpath = "//span[text()=\"User Management\"]")
	WebElement userManagement;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/i")
	WebElement usersButton;
	@FindBy(xpath = "//a[@class=\"dropdown-toggle\"]")
	WebElement adminButton;
	@FindBy(xpath = "//a[text()=\"Sign Out\"]")
	WebElement signoutButton;

	public String getLoginText() {
		String logNameText = loginName.getText();
		return logNameText;
	}

	public HomePage endTourClick() {
		endTourButton.click();
		return new HomePage(driver);
	}

	public void userManagmentclick() {
		userManagement.click();
	}

	public UsersPage usersClick() {
		usersButton.click();
		return new UsersPage(driver);
	}

	public void clickOnAdminButton() {
		adminButton.click();
	}

	public LoginPage clickOnSignOutButton() {
		signoutButton.click();
		return new LoginPage(driver);
	}

	public String getUserNameText() {
		String userNameText = adminButton.getText();
		return userNameText;
	}

}
