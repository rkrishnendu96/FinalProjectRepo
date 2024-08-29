package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

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
	@FindBy(xpath = "//i[@class=\"fa fa-briefcase\"]")
	WebElement role;
	@FindBy(xpath = "//div[@class=\"m-8 pull-left mt-15 hidden-xs\"]")
	WebElement loginDateField;

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

	public EditRolesPage clickOnRole() {
		role.click();
		return new EditRolesPage(driver);
	}

	public String getLoginDate() {
		return loginDateField.getText();
	}

	public String getCurrentDate() {
		return DateUtility.getUserLoginDate("dd-MM-YYYY");
	}

}
