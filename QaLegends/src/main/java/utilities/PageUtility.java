package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValueFromDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByIndexFromDropdown(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByTextFromDropdown(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

}
