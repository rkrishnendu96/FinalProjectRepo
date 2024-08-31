package orh.automationcore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;

public class Base {
	public WebDriver driver;
	public FileInputStream file;
	public Properties property;

	public void initializeBrowser(String browser) {
		property = new Properties();
		try {
			file = new FileInputStream(Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid Browser");
		}
	//	driver.get("https://qalegend.com/billing/public/login");
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));
	}

	@BeforeMethod
	public void setBrowser() {
		initializeBrowser("Chrome");
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenshot(result);
		}
		//driver.quit();
	}

	public void takeScreenshot(ITestResult result) throws IOException {
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File screenshot = takesscreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshot/" + result.getName() + ".png"));

	}

}
