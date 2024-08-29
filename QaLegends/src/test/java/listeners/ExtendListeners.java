
package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extendreport.ExtendManager;
import orh.automationcore.Base;

public class ExtendListeners extends Base implements ITestListener {
	private static final ExtentReports extent = ExtendManager.createInstance();
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal();

	public static ThreadLocal<ExtentTest> getTestInstance() {
		return test;
	}

	public synchronized void onStart(ITestContext context) {
		System.out.println(("Extent Reports Version 3 Test Suite Started!"));
	}

	public synchronized void onfinish(ITestContext context) {
		System.out.println(("Extent Reports Version 3 Test Suite Ending!"));
	}

	public synchronized void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " started!");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " passed!");
		test.get().pass("Test Passed");
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " failed!");
		test.get().fail(result.getThrowable());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " skipped!");
		test.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for" + result.getMethod().getMethodName()));
	}

}
