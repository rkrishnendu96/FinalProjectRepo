package testScript;
import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constants;
import constants.Messages;
import orh.automationcore.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ImportProductPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ProductsImportTest extends Base {
	@Test
	public void verifyImportWithoutUploadingFile() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
	//	String expectedError = ExcelUtility.getStringData(11, 0, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		home.clickOnProductsButton();
		ImportProductPage importProductPage = home.clickOnImportPdt();
		importProductPage.enterChooseFileButtonForWrongFile();
		importProductPage.clickOnSubmitButton();
	//	String actualError = importProductPage.getErrorMessage();
	//	Assert.assertEquals(actualError, expectedError, Messages.PRODUCT_IMPORT_SUCCESSFUL);
	}

	@Test
	public void verifyImportWithUploadingFile() {
		String usernameExcel = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String passwordExcel = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameExcel);
		login.enterPassword(passwordExcel);
		HomePage home = login.clickOnLoginButton();
		home.endTourClick();
		home.clickOnProductsButton();
		WaitUtility.waitForAnElement(driver);
		ImportProductPage importProductPage = home.clickOnImportPdt();
		importProductPage.enterChooseFileButton();
		importProductPage.clickOnSubmitButton();
	}

}
