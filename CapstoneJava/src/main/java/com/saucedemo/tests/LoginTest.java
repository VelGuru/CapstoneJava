package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucedemo.BaseTest;
import com.saucedemo.utills.ScreenshotUtil;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		test = extent.createTest("Verify Home Page Title");
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		test.info("Page title is: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch");
		test.pass("Title verified successfully");
	}

	@Test(priority = 2)
	@Parameters({ "validUsername", "validPassword" })
	public void loginWithValidCredentials(String username, String password) {
		test = extent.createTest("Login with Valid Credentials");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		String currentURL = driver.getCurrentUrl();
		test.info("Navigated to URL: " + currentURL);

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Swag Labs", "Failed to login with valid credentials");
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "User not navigated to inventory page");

		test.pass("Successfully logged in with valid credentials");

		String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "validLogin");
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Test(priority = 3)
	@Parameters({ "invalidUsername", "invalidPassword" })
	public void loginWithInvalidCredentials(String username, String password) {
		test = extent.createTest("Login with Invalid Credentials");

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
		test.info("Error message displayed: " + errorMessage);

		Assert.assertTrue(errorMessage.contains("Username and password do not match"),
				"Invalid login not handled properly");
		test.pass("Proper error message shown for invalid login");

		Assert.assertTrue(!driver.getCurrentUrl().contains("inventory.html"), "User navigated to inventory page");

		String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "invalidLogin");
		test.addScreenCaptureFromPath(screenshotPath);
	}
}