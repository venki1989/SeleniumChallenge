package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver; //Define as global variable, so that we eliminate for creating object every step, static since we should not change the variable
	public Properties properties; //Define as global variable, so that we eliminate for creating object every step
	public FileInputStream file;

	public WebDriver initializeDriver() throws IOException
	{
		properties= new Properties();
		file= new FileInputStream(System.getProperty("user.dir")+"\\SeleniumResources\\data.properties");
		properties.load(file);
		String BrowserName=properties.getProperty("Browser");

		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\SeleniumResources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\SeleniumResources\\chromedriver.exe");
			driver=new FirefoxDriver();

		}
		else if(BrowserName.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
		return driver; // Return so that any class can use this methods/objects


	}



}

