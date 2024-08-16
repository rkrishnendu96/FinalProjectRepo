package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.DataProviders;
import orh.automationcore.Base;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test
	public void verifyValidUsercredential() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, "LoginPage");

		WebElement username = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		username.sendKeys(usernameExcel);
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys(passwordExcel);
		WebElement rememberMeBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
		boolean isSelectedRememberMeBox = rememberMeBox.isSelected();
		Assert.assertFalse(isSelectedRememberMeBox, "rememberMe box is selected");
		rememberMeBox.click();
		isSelectedRememberMeBox = rememberMeBox.isSelected();
		Assert.assertTrue(isSelectedRememberMeBox, "rememberMe box is not selected");
		WebElement loginButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		loginButton.click();
		WebElement loginName = driver.findElement(By.xpath("//span[text()=\"Admin \"]"));
		String actualLoginName = loginName.getText();
		String expectedLoginName = ExcelUtility.getStringData(0, 0, "LoginPage");
		Assert.assertEquals(actualLoginName, expectedLoginName,"invalid login");

	}

	@Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWithInvalidCredentials(String usernameData, String passwordData) {
		WebElement username = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		username.sendKeys(usernameData);
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys(passwordData);
		WebElement rememberMeBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
		boolean isSelectedRememberMeBox = rememberMeBox.isSelected();
		Assert.assertFalse(isSelectedRememberMeBox, "rememberMe box is selected");
		rememberMeBox.click();
		isSelectedRememberMeBox = rememberMeBox.isSelected();
		Assert.assertTrue(isSelectedRememberMeBox, "rememberMe box is not selected");
		WebElement loginButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		loginButton.click();

		WebElement actualError = driver
				.findElement(By.xpath("//strong[text()=\"These credentials do not match our records.\"]"));
		String actualErrorMessage = actualError.getText();
		String expectedErrorMessage = ExcelUtility.getStringData(1, 0, "LoginPage");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "valid login");
		driver.close();

	}

}
