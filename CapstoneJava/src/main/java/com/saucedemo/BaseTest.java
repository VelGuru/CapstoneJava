package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.utills.ExtentReportManager;

public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    @Parameters({"url"})
    public void setUpSuite(String url) {
    	extent=ExtentReportManager.getInstance();
        WebDriverManager.chromedriver().setup();
        baseUrl = url;
    }
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
