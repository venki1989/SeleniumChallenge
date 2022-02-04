package TestChallenge_01;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import pageObjects.CartPage;

public class LoginAndSelectMaxItem extends base {
	public WebDriver driver;
	CartPage cart;
	
	@Test(dataProvider="getData")
	public void loginDetails(String user, String pass) throws IOException, InterruptedException
	{
		driver=initializeDriver(); // initializeDriver method returns driver from base class
		cart = new CartPage(driver);
		driver.get("https://www.saucedemo.com/");
		cart.doLogin(user,pass);
		cart.selectItem();
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[1][2]; // declared based on number of rows and columns
		data[0][0]="standard_user"; 
		data[0][1]="secret_sauce";
		return data;

	}

	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}



}
