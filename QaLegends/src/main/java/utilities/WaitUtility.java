package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static final long IMPLICITLYWAIT = 10; // final method
	public static final long EXPLICITLYWAIT = 10;
	public static final long FLUENTWAITWITHTIMEOUT = 10;
	public static final long FLUENTWAITPOLLINGEVERY = 2;

	public static void waitForAnElement(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLYWAIT));
	}

	public static void waitForAnElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLYWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForAnElementAndCheckFrequentlyAlertPresent(WebDriver driver) {
		FluentWait fluentwait = new FluentWait(driver);
		fluentwait.withTimeout(Duration.ofSeconds(FLUENTWAITWITHTIMEOUT));
		fluentwait.pollingEvery(Duration.ofSeconds(FLUENTWAITPOLLINGEVERY));
		fluentwait.ignoring(NoSuchElementException.class);
		fluentwait.until(ExpectedConditions.alertIsPresent());
	}

}
