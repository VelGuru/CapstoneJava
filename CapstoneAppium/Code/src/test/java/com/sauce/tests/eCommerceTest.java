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

public class eCommerceTest extends BaseTest {
    
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void FillForm(HashMap<String,String> input) throws InterruptedException
	{	
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue = formPage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//TestData//eCommerce.json");
		return new Object[][] { {data.get(0)}};
	}
}
