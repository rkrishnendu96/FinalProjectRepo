package testScript;

import org.testng.annotations.Test;

import orh.automationcore.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RolePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RolesPageTest extends Base {
	@Test
	public void verifyRoleEdit() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, "RolesPage");
		String passwordExcel = ExcelUtility.getIntegerData(1, 0, "RolesPage");
		
		LoginPage login= new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home=login.clickOnLoginButton();
		home.endTourClick();
		home.userManagmentclick();
		
	}
	

}
