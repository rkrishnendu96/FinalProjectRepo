package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"btn btn-block btn-primary\"]")
	WebElement addButton;
	@FindBy(xpath = "//input[@class=\"form-control input-sm\"]")
	WebElement searchButton;
	@FindBy(xpath = "//i[@class=\"fa fa-dashboard\"]")
	WebElement homeButton;
	


	public CreatePage addButtonClick() {
		addButton.click();
		return new CreatePage(driver);
	}
	public void enterSearch(String search) {
		searchButton.sendKeys(search);
	}
	public HomePage clickOnHomeButton() {
		homeButton.click();
		return new HomePage(driver);
	}

}
