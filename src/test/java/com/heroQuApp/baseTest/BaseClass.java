package com.heroQuApp.baseTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.heroquApp.driverFactory.DriverFactory;
import com.heroquApp.page.Homepage;
import com.heroquApp.utility.ConfigProperties;
import com.heroquApp.utility.ScreenshotUtility;

public class BaseClass {
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	Homepage homepage;
	@BeforeTest
	public void beforeTest() throws IOException {
		df=new DriverFactory();
		driver=df.getDriver();
		prop=ConfigProperties.getProperties("Uat");
		driver.get(prop.getProperty("baseurl"));;
		homepage=new Homepage(driver);
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility.takeScreenshot(driver, result.getMethod().getMethodName());
		}
	}
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

}
