package testScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import orh.automationcore.Base;
import pageObject.CreatePage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegisterPage;
import pageObject.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
	@Test
	public void VerifyRegisterPage() {

		String usernameExcel = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, "LoginPage");
		String prefixExcel = ExcelUtility.getStringData(0, 0, "RegisterPage");
		String firstNameFake = RandomDataUtility.getFirstName(); // using faker
		String lastaNameFake = RandomDataUtility.getLastName();
		String emailFake = firstNameFake + "." + lastaNameFake + "@" + "gmail.com";
		String userNameRegisterFake = firstNameFake + "2001";
		String passwordRegisterFake = firstNameFake + "." + lastaNameFake;
		String salesCommissionExcel = ExcelUtility.getIntegerData(5, 1, "RegisterPage");

		RegisterPage register = new RegisterPage(driver);
		register.enterUserName(usernameExcel);
		register.enterPassword(passwordExcel);
		HomePage home = register.loginClick();
		home.endTourClick();
		home.userManagmentclick();
		UsersPage users = home.usersClick();
		CreatePage create = users.addButtonClick();
		create.enterPrifix(prefixExcel);
		create.enterFirstName(firstNameFake);
		create.enterLastName(lastaNameFake);
		create.enterEmail(emailFake);
		create.enterUsername(userNameRegisterFake);
		create.enterPassword(passwordRegisterFake);
		create.enterConfirmPassword(passwordRegisterFake);
		create.enterSalesCommission(salesCommissionExcel);
		UsersPage users1 = create.clickOnSaveButton();
		users1.enterSearch(firstNameFake);
	}

	@Test
	public void verifyUserLoginWithNewlyAddedUser() {

		String usernameExcel = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, "LoginPage");
		String prefixExcel = ExcelUtility.getStringData(0, 0, "RegisterPage");
		String firstNameFake = RandomDataUtility.getFirstName(); // using faker
		String lastaNameFake = RandomDataUtility.getLastName();
		String emailFake = firstNameFake + "." + lastaNameFake + "@" + "gmail.com";
		String userNameRegisterFake = firstNameFake + "2001";
		String passwordRegisterFake = firstNameFake + "." + lastaNameFake;
		String salesCommissionExcel = ExcelUtility.getIntegerData(5, 1, "RegisterPage");

		RegisterPage register = new RegisterPage(driver);
		register.enterUserName(usernameExcel);
		register.enterPassword(passwordExcel);
		HomePage home = register.loginClick();
		home.endTourClick();
		home.userManagmentclick();
		UsersPage users = home.usersClick();
		CreatePage create = users.addButtonClick();
		create.enterPrifix(prefixExcel);
		create.enterFirstName(firstNameFake);
		create.enterLastName(lastaNameFake);
		create.enterEmail(emailFake);
		create.enterUsername(userNameRegisterFake);
		create.enterPassword(passwordRegisterFake);
		create.enterConfirmPassword(passwordRegisterFake);
		create.enterSalesCommission(salesCommissionExcel);
		UsersPage users1 = create.clickOnSaveButton();
		users1.enterSearch(firstNameFake);
		HomePage home1 = users1.clickOnHomeButton();
		home1.clickOnAdminButton();
		LoginPage login = home1.clickOnSignOutButton();
		login.enterUsername(userNameRegisterFake);
		login.enterPassword(passwordRegisterFake);
		HomePage home2=	login.clickOnLoginButton();
		String actualUserName=home2.getUserNameText();
		String expectedUserName=firstNameFake+" "+lastaNameFake;
		Assert.assertEquals(actualUserName, expectedUserName, "Username mismatch");

	}
}
























/*
 * ///////////////// admin login////////////////
 * 
 * String usernameExcel = ExcelUtility.getStringData(0, 0, "LoginPage"); String
 * passwordExcel = ExcelUtility.getIntegerData(0, 1, "LoginPage"); WebElement
 * username = driver.findElement(By.xpath("//input[@id=\"username\"]"));
 * username.sendKeys(usernameExcel); WebElement password =
 * driver.findElement(By.xpath("//input[@id=\"password\"]"));
 * password.sendKeys(passwordExcel); WebElement rememberMeBox =
 * driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
 * rememberMeBox.click(); WebElement loginButton =
 * driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
 * loginButton.click();
 * 
 * //////////////////////////register page///////////////////////////////
 * 
 * WebElement endTourButton =
 * driver.findElement(By.xpath("//button[text()=\"End tour\"]"));
 * endTourButton.click(); WebElement userManagement =
 * driver.findElement(By.xpath("//span[text()=\"User Management\"]"));
 * userManagement.click(); WebElement usersButton = driver.findElement(By.xpath(
 * "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/i"));
 * usersButton.click(); WebElement addButton =
 * driver.findElement(By.xpath("//a[@class=\"btn btn-block btn-primary\"]"));
 * addButton.click(); String prefixExcel = ExcelUtility.getStringData(0, 0,
 * "RegisterPage"); String firstNameFake = RandomDataUtility.getFirstName(); //
 * using faker String lastaNameFake = RandomDataUtility.getLastName(); String
 * emailFake = firstNameFake + "." + lastaNameFake + "@" + "gmail.com"; String
 * userNameRegisterFake = firstNameFake + "2001"; String passwordRegisterFake =
 * firstNameFake + "." + lastaNameFake; String salesCommissionExcel =
 * ExcelUtility.getIntegerData(5, 1, "RegisterPage"); WebElement prefix =
 * driver.findElement(By.xpath("//input[@name=\"surname\"]"));
 * prefix.sendKeys(prefixExcel); WebElement firstName =
 * driver.findElement(By.xpath("//input[@id=\"first_name\"]"));
 * firstName.sendKeys(firstNameFake); WebElement lastName =
 * driver.findElement(By.xpath("//input[@id=\"last_name\"]"));
 * lastName.sendKeys(lastaNameFake); WebElement email =
 * driver.findElement(By.xpath("//input[@id=\"email\"]"));
 * email.sendKeys(emailFake); String roleExcel = ExcelUtility.getStringData(6,
 * 1, "RegisterPage"); WebElement roleDropdown =
 * driver.findElement(By.xpath("//span[@id=\"select2-role-container\"]"));
 * roleDropdown.click(); List<WebElement> roleDropdownList =
 * driver.findElements(By.xpath("//li[@class=\"select2-results__option\"]"));
 * for (int i = 0; i < roleDropdownList.size(); i++) { if
 * (roleDropdownList.get(i).getText().equals(roleExcel)) {
 * roleDropdownList.get(i).click(); break; } } WebElement userNameRegister =
 * driver.findElement(By.xpath("//input[@id=\"username\"]"));
 * userNameRegister.sendKeys(userNameRegisterFake); WebElement
 * userPasswordRegister =
 * driver.findElement(By.xpath("//input[@id=\"password\"]"));
 * userPasswordRegister.sendKeys(passwordRegisterFake); WebElement
 * confirmPasswordRegister =
 * driver.findElement(By.xpath("//input[@id=\"confirm_password\"]"));
 * confirmPasswordRegister.sendKeys(passwordRegisterFake); WebElement
 * salesCommissionPercentage =
 * driver.findElement(By.xpath("//input[@id=\"cmmsn_percent\"]"));
 * salesCommissionPercentage.sendKeys(salesCommissionExcel); WebElement
 * allowSelectedContactCheckbox = driver.findElement( By.xpath(
 * "/html/body/div[2]/div[1]/section[2]/form/div[1]/div/div/div/div[11]/div/div/label/div/ins"
 * )); allowSelectedContactCheckbox.click(); String selectContactsDropdownExcel
 * = ExcelUtility.getStringData(7, 1, "RegisterPage"); WebElement
 * selectContactsDropdown =
 * driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
 * selectContactsDropdown.click(); List<WebElement> selectContactsDropdownList =
 * driver .findElements(By.xpath("//li[@class=\"select2-selection__choice\"]"));
 * for (int i = 0; i < selectContactsDropdownList.size(); i++) { if
 * (selectContactsDropdownList.get(i).getText().equals(
 * selectContactsDropdownExcel)) { selectContactsDropdownList.get(i).click();
 * break; } } WebElement saveButton =
 * driver.findElement(By.xpath("//button[@id=\"submit_user_button\"]"));
 * saveButton.click(); WebElement search =
 * driver.findElement(By.xpath("//input[@class=\"form-control input-sm\"]"));
 * search.sendKeys(firstNameFake); //
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); WebElement
 * homePage = driver.findElement(By.xpath("//i[@class=\"fa fa-dashboard\"]"));
 * homePage.click();
 * 
 * 
 * 
 * 
 * /////////////////////// Home page////////////////////
 * 
 * WebElement adminButton = driver
 * .findElement(By.xpath("//a[@class=\"dropdown-toggle\"]"));
 * adminButton.click(); WebElement adminSignout =
 * driver.findElement(By.xpath("//a[text()=\"Sign Out\"]"));
 * adminSignout.click(); WebElement newlyAddedUsername =
 * driver.findElement(By.xpath("//input[@id=\"username\"]"));
 * newlyAddedUsername.sendKeys(userNameRegisterFake); WebElement
 * newlyAddedPassword =
 * driver.findElement(By.xpath("//input[@id=\"password\"]"));
 * newlyAddedPassword.sendKeys(passwordRegisterFake); WebElement
 * newRememberMeBox =
 * driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
 * newRememberMeBox.click(); WebElement newLoginButton =
 * driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
 * newLoginButton.click(); }
 * 
 */
