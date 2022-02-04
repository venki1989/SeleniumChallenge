package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.base;

public class CartPage extends base {
 
	

	private By username=By.xpath("//input[@id='user-name']");
	private By password=By.xpath("//input[@id='password']");
	private By login=By.xpath("//input[@id='login-button']");
	private By maxItemList =By.xpath("//div[@class='pricebar']/div");

	public CartPage(WebDriver driver) //Creating Constructor for the class with driver arguments
	{
		this.driver=driver; // making class variable "driver" as constructor driver
	}

	public void doLogin(String user, String pass)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
	}
	public void selectItem()
	{
		List<WebElement> valueList=driver.findElements(maxItemList);
		ArrayList<Double> value = new ArrayList<Double>();
		Iterator<WebElement> it = valueList.iterator();
		while(it.hasNext())
		{

			value.add(Double.parseDouble(it.next().getText().replace("$","")));

		}
		System.out.println(Collections.max(value));
		driver.findElement(By.xpath("//div[.='$"+Collections.max(value)+"']/../button")).click();
	}
}
