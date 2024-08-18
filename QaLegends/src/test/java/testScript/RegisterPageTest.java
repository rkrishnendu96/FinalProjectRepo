package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import orh.automationcore.Base;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
	@Test
	public void VerifyRegisterPage() {
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

///////// register page//////////
		
		WebElement endTourButton = driver.findElement(By.xpath("//button[text()=\"End tour\"]"));
		endTourButton.click();
		WebElement userManagement = driver.findElement(By.xpath("//span[text()=\"User Management\"]"));
		userManagement.click();
		WebElement usersButton = driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/i"));
		usersButton.click();
		WebElement addButton = driver.findElement(By.xpath("//a[@class=\"btn btn-block btn-primary\"]"));
		addButton.click();

		String prefixExcel = ExcelUtility.getStringData(0, 0, "RegisterPage");
		
		String firstNameFake=RandomDataUtility.getFirstName();  // using faker
		String lastaNameFake=RandomDataUtility.getLastName();   
		String emailFake = firstNameFake+"."+lastaNameFake+"@"+"gmail.com";
		String userNameRegisterFake = firstNameFake+"2001";
		String passwordRegisterFake =firstNameFake+"."+lastaNameFake;
		String salesCommissionExcel = ExcelUtility.getIntegerData(5, 1, "RegisterPage");

		WebElement prefix = driver.findElement(By.xpath("//input[@name=\"surname\"]"));
		prefix.sendKeys(prefixExcel);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id=\"first_name\"]"));
		firstName.sendKeys(firstNameFake);
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id=\"last_name\"]"));
		lastName.sendKeys(lastaNameFake);
		
		WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		email.sendKeys(emailFake);
		
		/*
		
		WebElement roleDropdown = driver.findElement(By.xpath("//span[@class=\"select2-search select2-search--dropdown\"]//input[@class=\"select2-search__field\"]"));
		//boolean isRoleDropdownSelected = roleDropdown.isSelected();
		//Assert.assertFalse(isRoleDropdownSelected, "dropdown value selected");
		Select select = new Select(roleDropdown);
		//select.selectByIndex(6);
		//Assert.assertTrue(isRoleDropdownSelected, "dropdown value selected");
		roleDropdown.click();
		List <WebElement>list=select.getOptions();
		String roleExcel=ExcelUtility.getStringData(6, 1, "RegisterPage");
		
		*/
		
		
		WebElement userNameRegister = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		userNameRegister.sendKeys(userNameRegisterFake);
		
		WebElement userPasswordRegister = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		userPasswordRegister.sendKeys(passwordRegisterFake);
		
		WebElement confirmPasswordRegister = driver.findElement(By.xpath("//input[@id=\"confirm_password\"]"));
		confirmPasswordRegister.sendKeys(passwordRegisterFake);
		
		WebElement salesCommissionPercentage = driver.findElement(By.xpath("//input[@id=\"cmmsn_percent\"]"));
		salesCommissionPercentage.sendKeys(salesCommissionExcel);
		
		WebElement allowSelectedContactCheckbox = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[2]/form/div[1]/div/div/div/div[11]/div/div/label/div/ins"));
	//	boolean isallowSelectedContactCheckboxnSelected = allowSelectedContactCheckbox.isSelected();
	//	Assert.assertFalse(isallowSelectedContactCheckboxnSelected, "contact checkbox selected");
		allowSelectedContactCheckbox.click();
	//	isallowSelectedContactCheckboxnSelected = allowSelectedContactCheckbox.isSelected();
	//	Assert.assertTrue(isallowSelectedContactCheckboxnSelected, "contact checkbox not selected");
		
		WebElement selectContactsDropdown = driver
				.findElement(By.xpath("//ul[@class=\"select2-selection__rendered\"]"));
		boolean isSelectContactsDropdownSelected = selectContactsDropdown.isSelected();
		Assert.assertFalse(isSelectContactsDropdownSelected, "contact dropdown value selected");
		Select selectContact = new Select(selectContactsDropdown);
		selectContact.selectByIndex(3);
		WebElement saveButton = driver.findElement(By.xpath("//button[@id=\"submit_user_button\"]"));
		saveButton.click();

		WebElement search = driver.findElement(By.xpath("//input[@class=\"form-control input-sm\"]"));
		search.sendKeys(firstNameFake);

	//	driver.close();
	}
}
