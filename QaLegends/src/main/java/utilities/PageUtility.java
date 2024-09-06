package utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValueFromDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectOption(List<WebElement> roleDropdownList, String option) {
		for (int i = 0; i < roleDropdownList.size(); i++) {
			if (roleDropdownList.get(i).getText().equals(option)) {
				roleDropdownList.get(i).click();
				break;
			}
		}
	}

	public static void selectByTextFromDropdown(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByIndexFromDropdown(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void alertAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void alertDismiss(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,1000)");
	}

	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,-1000)");
	}

	public static void fullyVerticalScroll(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public static void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void dragAndDrop(WebDriver driver, WebElement dragButton, WebElement dropArea) {
		Actions action = new Actions(driver);
		action.moveToElement(dropArea).build().perform();
		action.click(dragButton).build().perform();
		action.dragAndDrop(dragButton, dropArea).build().perform();
	}

}
