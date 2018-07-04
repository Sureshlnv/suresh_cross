package com.chiselon.CrossBrowser;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBTest 
{
		WebDriver driver;

		@BeforeTest
		@Parameters("browser")
		public void setup(String browser) throws Exception{
			if (browser.trim().equalsIgnoreCase("chrome")) 
 			{
				System.setProperty("webdriver.chrome.driver","C:\\JaswanthFramework\\CrossBrowser\\target\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browser.trim().equalsIgnoreCase("Firefox")) 
			{
				driver = new FirefoxDriver();
			}
			else if(browser.trim().equalsIgnoreCase("IE")) 
			{
				System.setProperty("webdriver.ie.driver","C:\\JaswanthFramework\\CrossBrowser\\target\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void testParameterWithXML() throws InterruptedException{
			driver.get("http://demo.guru99.com/V4/");
		
			WebElement userName = driver.findElement(By.name("uid"));
		
			userName.sendKeys("guru99");
			
			WebElement password = driver.findElement(By.name("password"));
			
			password.sendKeys("guru99");
		}
	
}
