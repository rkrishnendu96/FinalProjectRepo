package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;

public class ImportProductPage {
	WebDriver driver;

	public ImportProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"products_csv\"]")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement submitButton;
	@FindBy(xpath = "//button[@type=\"button\" and @aria-hidden=\"true\"]")
	WebElement errorMessage;

	public void enterChooseFileButton() {
		chooseFileButton.sendKeys(Constants.HOME_DIRECTORY + Constants.IMPORT_PRODUCTS_PATH);
	}

	public void clickOnSubmitButton() {
		submitButton.click();
	}
	public void enterChooseFileButtonForWrongFile() {
		chooseFileButton.sendKeys(Constants.HOME_DIRECTORY + Constants.IMPORT_WRONG_PRODUCTS_PATH);
	}
	public String getErrorMessage() {
		String errorAlert = errorMessage.getText();
		return errorAlert;
	}

}
