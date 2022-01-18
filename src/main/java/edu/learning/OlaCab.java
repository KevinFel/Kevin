package edu.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlaCab {

	@Test
	public void olaPickup() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.olacabs.com/");

		Actions aObj = new Actions(driver);

//Moving to OutStation
		WebElement station = driver.findElementByXPath("//a[text()='Outstation']");
		aObj.moveToElement(station).click().build().perform();
//Current Location
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='Current location']").click();
		Thread.sleep(2000);

		driver.findElementById("addressInput").sendKeys("Chennai");
		Thread.sleep(2000);

		WebElement firstpickuplocation = driver
				.findElementByXPath("(//div[@class='results-row']//div[@class='name'])[1]");
		aObj.moveToElement(firstpickuplocation).click().build().perform();

		driver.findElementByXPath("(//div[contains(@class,'widget-location-input card bg-dark no-border')])[2]")
				.click();
		Thread.sleep(2000);
		driver.findElementById("addressInput").sendKeys("Bangalore");
		Thread.sleep(2000);

		WebElement secondpickuplocation = driver
				.findElementByXPath("(//div[contains(@class,'middle text')]//div[@class='name'])[1]");
		aObj.moveToElement(secondpickuplocation).click().build().perform();

		WebElement searchSub = driver
				.findElementByXPath("//button[contains(@class,'ow-button ow-button--secondary')]/span");
		Thread.sleep(2000);

	/*	String firstWinTitleName = driver.getTitle();
		System.out.println("Window Title :: " + firstWinTitleName);*/

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// for click
		jse.executeScript("arguments[0].click();", searchSub);

		Thread.sleep(2000);

		
		  String firsWindowName = driver.getWindowHandle();
		  
		  System.out.println("first windowHandle ID :: "+firsWindowName);
		  Set<String> windowHandleIds = driver.getWindowHandles();
		  
		  for (String individualWinHandle : windowHandleIds) {
		 System.out.println(individualWinHandle);
		  if(!individualWinHandle.equals(firsWindowName)) {
		  driver.switchTo().window(individualWinHandle); }
		 

		/*
		 * Set<String> windowHandles= driver.getWindowHandles(); List<String> list=new
		 * ArrayList<String>(windowHandles); driver.switchTo().window(list.get(1));
		 */

		/*
		 * ChromeOptions option = new ChromeOptions();
		 * option.addArguments("--disable-notifications");
		 */

		driver.switchTo().alert().dismiss();

		String secondWin = driver.findElementById("logo").getText();
		System.out.println("2nd window" + secondWin);

	}

	// nc.dismiss();

	// driver.close();

//	

}
