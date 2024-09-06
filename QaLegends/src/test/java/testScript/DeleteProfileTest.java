package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import constants.Messages;
import orh.automationcore.Base;
import pageObject.CreatePage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class DeleteProfileTest extends Base {
	@Test
	public void verifyDeleteNewlyAddedUser() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String prefixExcel = ExcelUtility.getStringData(0, 0, Constants.REGISTER_PAGE);
		String firstNameFake = RandomDataUtility.getFirstName(); // using faker
		String lastaNameFake = RandomDataUtility.getLastName();
		String emailFake = firstNameFake + "." + lastaNameFake + "@" + "gmail.com";
		String userNameRegisterFake = firstNameFake + "2001";
		String passwordRegisterFake = firstNameFake + "." + lastaNameFake;
		String salesCommissionExcel = ExcelUtility.getIntegerData(5, 1, Constants.REGISTER_PAGE);
		String noRecordMsg = ExcelUtility.getStringData(11, 0, Constants.LOGIN_PAGE);
		String fullName = firstNameFake + " " + lastaNameFake;

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
		users.enterSearch(emailFake);
		users.clickOnDeleteButton();
		users.clickOnokButton();
		users.enterSearch(fullName);
		Assert.assertEquals(users.noRecordsGetText(), noRecordMsg, Messages.DELETE_MESSAGE_UNSUCCESSFULL);
	}

}
