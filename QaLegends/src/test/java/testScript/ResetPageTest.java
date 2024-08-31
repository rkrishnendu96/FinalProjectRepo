package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import constants.Messages;
import orh.automationcore.Base;
import pageObject.LoginPage;
import pageObject.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {

	@Test
	public void verifyPasswordResetWithValidMailId() {

		String validEmailExcel = ExcelUtility.getStringData(2, 0, Constants.RESET_PAGE);
		String expectedMessage = ExcelUtility.getStringData(3, 0, Constants.RESET_PAGE);

		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.forgotYourPwClick();
		reset.enterEmailAddress(validEmailExcel);
		reset.clickOnPwResetButton();
		String actualMsg = reset.getResetValidMsg();
		Assert.assertEquals(actualMsg, expectedMessage, Messages.UNSUCCESSFULL_PASSWORD_RESET);
	}

	@Test
	public void verifyPasswordResetWithInvalidMailId() {
		String invalidEmailExcel = ExcelUtility.getStringData(0, 0, Constants.RESET_PAGE);
		String expectedErrorMessage = ExcelUtility.getStringData(1, 0, Constants.RESET_PAGE);

		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.forgotYourPwClick();
		reset.enterEmailAddress(invalidEmailExcel);
		reset.clickOnPwResetButton();
		String actualErrorMsg = reset.getResetErrorMsg();
		Assert.assertEquals(actualErrorMsg, expectedErrorMessage, Messages.SUCCESSFULL_PASSWORD_RESET);
	}

}
