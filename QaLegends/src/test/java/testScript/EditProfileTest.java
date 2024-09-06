package testScript;

import constants.Constants;
import constants.Messages;

import org.testng.Assert;
import org.testng.annotations.Test;
import orh.automationcore.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class EditProfileTest extends Base {
	@Test
	public void verifyProfileEdit() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String firstNameFake = RandomDataUtility.getFirstName();
		String lastaNameFake = RandomDataUtility.getLastName();
		String expectedEmailFake = firstNameFake + "." + lastaNameFake + "@" + "gmail.com";

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		home.clickOnAdminButton();
		ProfilePage profilePage = home.clickOnProfileButton();
		profilePage.enterMailId(expectedEmailFake);
		profilePage.clickOnUpdateButton();
		Assert.assertTrue(profilePage.isProfileUpdateMsgDisplayed(), Messages.EMAIL_UPDATE_FAILED);
	}

}
