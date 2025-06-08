package com.sauce.base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sauce.pages.FormPage;
import com.sauce.utils.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public FormPage formPage;
 
    @BeforeClass(alwaysRun=true)
    public void setup() throws MalformedURLException, URISyntaxException {
    	UiAutomator2Options Options = new UiAutomator2Options();
    	Options.setDeviceName("Pixel9");
    	Options.setApp("D:\\Workspace\\sauce\\src\\test\\java\\resources\\General-Store.apk");
    	driver=(new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), Options));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage= new FormPage(driver);
    	
    }

    @AfterClass
    public void teardown() {
    	driver.quit();
    }
}
