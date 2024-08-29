package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
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
	/*
	 * public static void getDropdownvalues(WebElement element) { for (int i = 0; i
	 * < selectContactsDropdownList.size(); i++) { if
	 * (selectContactsDropdownList.get(i).getText().equals(
	 * selectContactsDropdownExcel)) { selectContactsDropdownList.get(i).click();
	 * break; } }
	 * 
	 * }
	 */
}
