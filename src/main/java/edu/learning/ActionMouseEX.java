package edu.learning;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ActionMouseEX {

			public void driver () {
			WebDriverManager.chromedriver().setup();
			RemoteWebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://oceanacademy.in/");
			
			Actions actinObj = new Actions(driver);
		
			WebElement courses = driver.findElementById("cour");
			actinObj.moveToElement(courses).perform();
			WebElement SpecificCourse = driver.findElementByXPath("//ul[@id='dview']/li[3]/a");
			actinObj.moveToElement(SpecificCourse).click().build().perform();
				
		}
		
		@Test
		public void alertsDemo() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			RemoteWebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://oceanacademy.in/");
			

			driver.findElementByXPath("(//i[contains(@class,'fa fa-phone')])[1]/..").click();
			
			Thread.sleep(5000);
					
			WebElement submitBUtton = driver.findElementByXPath("//button[text()='submit']");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//for click
			jse.executeScript("arguments[0].click();", submitBUtton);
			
			//for page scroll-down
			jse.executeScript("arguments[0]. scrollIntoView(true);", submitBUtton);
				
			System.out.println(driver.switchTo().alert().getText());
			
			driver.switchTo().alert().accept();
			
			
			
		}
		
@Test
		public void alertdemo2() throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/delete_customer.php");

			driver.switchTo().alert().dismiss();

			
			driver.findElementByName("cusid").sendKeys("asdasd213");
			driver.findElementByName("submit").click();
			
			driver.switchTo().alert().dismiss();
			
			Thread.sleep(5000);

			driver.findElementByName("submit").click();
			driver.switchTo().alert().accept();
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}
			

		
}
