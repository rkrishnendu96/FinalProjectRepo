package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import orh.automationcore.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class HomePageTest extends Base {
	@Test
	public void verifyHomePageTitle() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String expectedHomePageTitle = ExcelUtility.getStringData(8, 0, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		String actualHomePageTitle = driver.getTitle();
		System.out.println(actualHomePageTitle);
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Pagetitle mismatch");
	}

	@Test
	public void verifyUserloginDate() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		String homePageDate = home.getLoginDate();
		String currentDate = home.getCurrentDate();
		Assert.assertEquals(homePageDate, currentDate, "Date Mismatch");

	}

}
