package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import orh.automationcore.Base;
import pageObject.CreatePage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UsersPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
	@Test
	public void VerifyRegisterPage() {

		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String prefixExcel = ExcelUtility.getStringData(0, 0, Constants.REGISTER_PAGE);
		String firstNameFake = RandomDataUtility.getFirstName(); // using faker
		String lastaNameFake = RandomDataUtility.getLastName();
		String emailFake = firstNameFake + Constants.DOT_SIGN + lastaNameFake + Constants.AT_SIGN
				+ Constants.MAIL_EXTENSION;
		String roleExcel = ExcelUtility.getStringData(6, 1, Constants.REGISTER_PAGE);
		String userNameRegisterFake = firstNameFake + Constants.USERNAME_DIGIT;
		String passwordRegisterFake = firstNameFake + Constants.DOT_SIGN + lastaNameFake;
		String salesCommissionExcel = ExcelUtility.getIntegerData(5, 1, Constants.REGISTER_PAGE);
		String contactsExcel = ExcelUtility.getIntegerData(7, 1, Constants.REGISTER_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		home.userManagmentclick();
		UsersPage users = home.usersClick();
		CreatePage create = users.addButtonClick();
		create.enterPrifix(prefixExcel);
		create.enterFirstName(firstNameFake);
		create.enterLastName(lastaNameFake);
		create.enterEmail(emailFake);
		create.clickOnRole();
		PageUtility.selectOption(create.getRoleLists(), roleExcel);
		create.enterUsername(userNameRegisterFake);
		create.enterPassword(passwordRegisterFake);
		create.enterConfirmPassword(passwordRegisterFake);
		create.enterSalesCommission(salesCommissionExcel);
		PageUtility.selectOption(create.selectContactList(), contactsExcel);
		users = create.clickOnSaveButton();
		users.enterSearch(firstNameFake);
	}

	@Test
	public void verifyUserLoginWithNewlyAddedUser() {

		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String prefixExcel = ExcelUtility.getStringData(0, 0, Constants.REGISTER_PAGE);
		String firstNameFake = RandomDataUtility.getFirstName(); // using faker
		String lastaNameFake = RandomDataUtility.getLastName();
		String emailFake = firstNameFake + "." + lastaNameFake + "@" + "gmail.com";
		String userNameRegisterFake = firstNameFake + "2001";
		String passwordRegisterFake = firstNameFake + "." + lastaNameFake;
		String salesCommissionExcel = ExcelUtility.getIntegerData(5, 1, Constants.REGISTER_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
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
		users = create.clickOnSaveButton();
		users.enterSearch(firstNameFake);
		home = users.clickOnHomeButton();
		home.clickOnAdminButton();
		login = home.clickOnSignOutButton();
		login.enterUsername(userNameRegisterFake);
		login.enterPassword(passwordRegisterFake);
		HomePage home2 = login.clickOnLoginButton();
		String actualUserName = home2.getUserNameText();
		String expectedUserName = firstNameFake + " " + lastaNameFake;
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
 * roleDropdown.click();
 * 
 * 
 * List<WebElement> roleDropdownList
 * =driver.findElements(By.xpath("//li[@class=\"select2-results__option\"]"));
 * for (int i = 0; i < roleDropdownList.size(); i++) { if
 * (roleDropdownList.get(i).getText().equals(roleExcel)) {
 * roleDropdownList.get(i).click(); break; } }
 * 
 * 
 * WebElement userNameRegister =
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

/*
 * report code
 * 
 * 
 * 
 * public static ExtentReports extent; public static Platform platform; private
 * static final String reportFileName = "Extent.html"; private static final
 * String macPath = System.getProperty("user.dir") + "/TestReport"; private
 * static final String windowsPath = System.getProperty("user.dir") +
 * "\\TestReport"; private static final String macReportFileLoc = macPath + "/"
 * + reportFileName; private static final String winReportFileLoc = windowsPath
 * + "\\" + reportFileName;
 * 
 * public static ExtentReports getInstance() { if (extent == null)
 * createInstance(); return extent; }
 * 
 * //Create an extent report instance public static ExtentReports
 * createInstance() { platform = getCurrentPlatform(); String fileName =
 * getReportFileLocation(platform); ExtentHtmlReporter htmlReporter = new
 * ExtentHtmlReporter(fileName);
 * htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
 * htmlReporter.config().setChartVisibilityOnOpen(true);
 * htmlReporter.config().setTheme(Theme.DARK);
 * htmlReporter.config().setDocumentTitle(fileName);
 * htmlReporter.config().setEncoding("utf-8");
 * htmlReporter.config().setReportName(fileName);
 * 
 * extent = new ExtentReports(); extent.attachReporter(htmlReporter);
 * 
 * return extent; }
 * 
 * //Select the extent report file location based on platform private static
 * String getReportFileLocation(Platform platform) { String reportFileLocation =
 * null; switch (platform) { case MAC: reportFileLocation = macReportFileLoc;
 * createReportPath(macPath); System.out.println("ExtentReport Path for MAC: " +
 * macPath + "\n"); break; case WINDOWS: reportFileLocation = winReportFileLoc;
 * createReportPath(windowsPath);
 * System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
 * break; default: System.out.
 * println("ExtentReport path has not been set! There is a problem!\n"); break;
 * } return reportFileLocation; }
 * 
 * //Create the report path if it does not exist private static void
 * createReportPath(String path) { File testDirectory = new File(path); if
 * (!testDirectory.exists()) { if (testDirectory.mkdir()) {
 * System.out.println("Directory: " + path + " is created!"); } else {
 * System.out.println("Failed to create directory: " + path); } } else {
 * System.out.println("Directory already exists: " + path); } }
 * 
 * //Get current platform private static Platform getCurrentPlatform() { if
 * (platform == null) { String operSys =
 * System.getProperty("os.name").toLowerCase(); if (operSys.contains("win")) {
 * platform = Platform.WINDOWS; } else if (operSys.contains("nix") ||
 * operSys.contains("nux") || operSys.contains("aix")) { platform =
 * Platform.LINUX; } else if (operSys.contains("mac")) { platform =
 * Platform.MAC; } } return platform; }
 * 
 * 
 */