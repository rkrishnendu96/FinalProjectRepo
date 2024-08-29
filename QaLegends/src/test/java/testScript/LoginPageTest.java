package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constants;
import dataprovider.DataProviders;
import orh.automationcore.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test
	public void verifyValidUsercredential() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String expectedLoginName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		String actualText = home.getLoginText();
		Assert.assertEquals(actualText, expectedLoginName, "invalid login");
	}

	@Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWithInvalidCredentials(String usernameData, String passwordData) {

		String expectedErrorMessage = ExcelUtility.getStringData(1, 0, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameData);
		login.enterPassword(passwordData);
		login.clickOnLoginButton();
		String actualErrorText = login.getActualErrorMessageText();
		Assert.assertEquals(actualErrorText, expectedErrorMessage, "valid login");

	}

}







/*
 * WebElement forgotYourPw =
 * driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]"));
 * forgotYourPw.click(); String invalidEmailExcel =
 * ExcelUtility.getStringData(0, 0, "ResetPage"); WebElement invalidEmail =
 * driver.findElement(By.xpath("//input[@id=\"email\"]"));
 * invalidEmail.sendKeys(invalidEmailExcel); WebElement sendPwResetLinkButton =
 * driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
 * sendPwResetLinkButton.click(); WebElement errorMessage = driver
 * .findElement(By.
 * xpath("//strong[text()=\"We can't find a user with that e-mail address.\"]"))
 * ; String actualErrorMessage = errorMessage.getText(); String
 * expectedErrorMessage = ExcelUtility.getStringData(1, 0, "ResetPage");
 * Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
 * "Password reset successful");
 * 
 * } public void verifyPasswordresetWithValidMailId() {
 * 
 * WebElement forgotYourPw =
 * driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]"));
 * forgotYourPw.click(); String invalidEmailExcel =
 * ExcelUtility.getStringData(0, 0, "ResetPage"); WebElement invalidEmail =
 * driver.findElement(By.xpath("//input[@id=\"email\"]")); /*
 * invalidEmail.sendKeys(invalidEmailExcel); WebElement sendPwResetLinkButton =
 * driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
 * sendPwResetLinkButton.click(); WebElement errorMessage = driver
 * .findElement(By.
 * xpath("//strong[text()=\"We can't find a user with that e-mail address.\"]"))
 * ; String actualErrorMessage = errorMessage.getText(); String
 * expectedErrorMessage = ExcelUtility.getStringData(1, 0, "ResetPage");
 * Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
 * "Password reset successful");
 * 
 */
