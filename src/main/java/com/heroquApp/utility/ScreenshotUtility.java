package com.heroquApp.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenshotUtility {
	public static void takesScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"Screenshots"+File.separator+screenshotName+" .jpg";
		File destfile=new File(fullpath);
		TakesScreenshot screenshot=(TakesScreenshot)driver;
	try {
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, destfile);
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
