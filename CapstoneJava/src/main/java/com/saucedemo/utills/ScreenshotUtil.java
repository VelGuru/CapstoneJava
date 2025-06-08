package com.saucedemo.utills;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String fileName) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);

	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String path = "screenshots/" + fileName + "_" + timestamp + ".png";

	    try {
	        FileUtils.copyFile(src, new File(path));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return path;
	}

}
