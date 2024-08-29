package testScript;

import org.testng.Assert;

import orh.automationcore.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class HomePageTest extends Base {
	
	public void verifyUserloginDate() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		String homePageDate=home.getLoginDate();
        String currentDate=home.getCurrentDate();
        Assert.assertEquals(homePageDate, currentDate, "Date Mismatch");

	}

}
