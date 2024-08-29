package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {

	WebDriver driver;

	public CreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"surname\"]")
	WebElement prifixField;
	@FindBy(xpath = "//input[@id=\"first_name\"]")
	WebElement firstNameField;
	@FindBy(xpath = "//input[@id=\"last_name\"]")
	WebElement lastNameField;
	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement emailField;
	@FindBy(xpath = "//span[@id=\"select2-role-container\"]")
	WebElement roleDropdownField;
	@FindBy(xpath = "//li[@class=\"select2-results__option\"]")
	List<WebElement> roleDropdownList;
	@FindBy(xpath = "//input[@id=\"username\"]")
	WebElement userNameRegisterField;
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordRegisterField;
	@FindBy(xpath = "//input[@id=\"confirm_password\"]")
	WebElement confirmPasswordRegisterField;
	@FindBy(xpath = "//input[@id=\"cmmsn_percent\"]")
	WebElement salesCommissionPercentageField;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/form/div[1]/div/div/div/div[11]/div/div/label/div/ins")
	WebElement allowSelectedContactCheckbox;
	@FindBy(xpath = "//input[@class=\"select2-search__field\"]")
	WebElement selectContactsDropdownField;
	@FindBy(xpath = "//li[@class=\"select2-selection__choice\"]")
	List<WebElement> selectContactsDropdownList;
	@FindBy(xpath = "//button[@id=\"submit_user_button\"]")
	WebElement saveButtonField;

	public void enterPrifix(String prifix) {
		prifixField.sendKeys(prifix);
	}

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void clickOnRole() {
		roleDropdownField.click();
	}

	public List<WebElement> getRoleLists() {
		return roleDropdownList;
	}

	public void enterUsername(String userName) {
		userNameRegisterField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordRegisterField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordRegisterField.sendKeys(confirmPassword);
	}

	public void enterSalesCommission(String salesCommission) {
		salesCommissionPercentageField.sendKeys(salesCommission);
	}
	public void clickOnContacts() {
		selectContactsDropdownField.click();
	}
	public List<WebElement> selectContactList(){
		return selectContactsDropdownList;
	}

	/*
	 * public void clickOnAllowSelectedContact() {
	 * allowSelectedContactCheckbox.click(); }
	 * 
	 * public void clickOnSelectContact() { selectContactsDropdownField.click(); }
	 */
	public UsersPage clickOnSaveButton() {
		saveButtonField.click();
		return new UsersPage(driver);
	}

}