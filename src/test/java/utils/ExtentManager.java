package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static ExtentReports getExtent() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest extentTest = getExtent().createTest(testName);
		test.set(extentTest);
		return extentTest;
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void flush() {
		extent.flush();
	}
}
