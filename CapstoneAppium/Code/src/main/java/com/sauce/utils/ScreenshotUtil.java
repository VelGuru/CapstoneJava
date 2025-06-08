package com.sauce.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;

public class ScreenshotUtil 
{
	public static void takeScreenshot(AndroidDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String destPath = "reports/screenshots/" + testName + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(src, new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
