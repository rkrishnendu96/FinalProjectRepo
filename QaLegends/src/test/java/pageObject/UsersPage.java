package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"btn btn-block btn-primary\"]")
	WebElement addButton;
	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement searchButton;
	@FindBy(xpath = "//i[@class=\"fa fa-dashboard\"]")
	WebElement homeButton;
	@FindBy(xpath = "//table[@id='users_table']//tr//td[4]")
	WebElement emailText;
	@FindBy(xpath = "//button[@class=\"btn btn-xs btn-danger delete_user_button\"]")
	WebElement deleteButton;
	@FindBy(xpath = "//button[@class=\"swal-button swal-button--confirm swal-button--danger\"]")
	WebElement okButton;
	@FindBy(xpath = "//div[text()=\"User deleted successfully\"]")
	WebElement deleteMessage;
	@FindBy(xpath = "//table[@id=\"users_table\"]//td[@class=\"dataTables_empty\"]")
	WebElement norecordsMessage;

	public CreatePage addButtonClick() {
		addButton.click();
		return new CreatePage(driver);
	}

	public void enterSearch(String search) {
		searchButton.clear();
		searchButton.sendKeys(search);
	}

	public String getEmailText() {
		String textEmail = emailText.getText();
		return textEmail;
	}

	public HomePage clickOnHomeButton() {
		homeButton.click();
		return new HomePage(driver);
	}

	public void clickOnDeleteButton() {
		WaitUtility.waitForAnElementToBeClickable(driver, deleteButton);
		deleteButton.click();
	}

	public void clickOnokButton() {
		okButton.click();
	}

	public String noRecordsGetText() {
		String getTextNoRecords = norecordsMessage.getText();
		return getTextNoRecords;
	}

}
