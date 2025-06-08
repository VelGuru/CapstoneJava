package com.sauce.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sauce.base.BaseTest;
import com.sauce.pages.CartPage;
import com.sauce.pages.ProductCatalogue;

import io.appium.java_client.AppiumBy;

public class ValidationTest extends BaseTest {
    
	@Test
    public void FillForm_ErrorValidation() 
    {
    	driver.hideKeyboard();
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMessage,"Please your name");
    }
    
	@Test
	public void FillForm_PositiveFlow() throws InterruptedException	
	{
		formPage.setNameField("Vel");
		driver.hideKeyboard();
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();
		AssertJUnit.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);		
	}
	
}
