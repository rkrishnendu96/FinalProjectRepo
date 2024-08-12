package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import orh.automationcore.Base;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {
	@Test
	public void verifyPasswordresetWithInvalidMailId() {

		WebElement forgotYourPw = driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]"));
		forgotYourPw.click();
		String invalidEmailExcel = ExcelUtility.getStringData(0, 0, "ResetPage");
		WebElement invalidEmail = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		invalidEmail.sendKeys(invalidEmailExcel);
		WebElement sendPwResetLinkButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		sendPwResetLinkButton.click();
		WebElement errorMessage = driver
				.findElement(By.xpath("//strong[text()=\"We can't find a user with that e-mail address.\"]"));
		String actualErrorMessage = errorMessage.getText();
		String expectedErrorMessage = ExcelUtility.getStringData(1, 0, "ResetPage");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Password reset successful");

	}
	public void verifyPasswordresetWithValidMailId() {

		WebElement forgotYourPw = driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]"));
		forgotYourPw.click();
		String invalidEmailExcel = ExcelUtility.getStringData(0, 0, "ResetPage");
		WebElement invalidEmail = driver.findElement(By.xpath("//input[@id=\"email\"]"));
	/*	invalidEmail.sendKeys(invalidEmailExcel);
		WebElement sendPwResetLinkButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		sendPwResetLinkButton.click();
		WebElement errorMessage = driver
				.findElement(By.xpath("//strong[text()=\"We can't find a user with that e-mail address.\"]"));
		String actualErrorMessage = errorMessage.getText();
		String expectedErrorMessage = ExcelUtility.getStringData(1, 0, "ResetPage");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Password reset successful");   */

	}

	
}
