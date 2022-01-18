package edu.learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MythaLearning {
	@Test
	public void handlesWindow() throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		Thread.sleep(8000);
		driver.findElementByClassName("desktop-searchBar").sendKeys("Sunglass" + Keys.ENTER);
		
		WebElement submitBUtton = driver.findElementByXPath("//input[@value='men,men women']");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// for click
		jse.executeScript("arguments[0].click();", submitBUtton);

		// Search_box
		driver.findElementByClassName("filter-search-filterSearchBox").click();
		driver.findElementByClassName("filter-search-inputBox").sendKeys("Polaroid" + Keys.ENTER);

		WebElement submitBUtton2 = driver.findElementByClassName("brand-num");
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		// for click
		jse2.executeScript("arguments[0].click();", submitBUtton2);

		WebElement imageClick = driver
				.findElementByXPath("//img[@alt='Polaroid Unisex Browline Sunglasses PLD 6039/S/X 807 54M9']");
		JavascriptExecutor sunGlass = (JavascriptExecutor) driver;

		sunGlass.executeScript("arguments[0].click();", imageClick);

		String firstWinTitleName = driver.getTitle();
		System.out.println("Window Title :: " + firstWinTitleName);

		String firsWindowName = driver.getWindowHandle();
		System.out.println("first windowHandle ID :: " + firsWindowName);

		Set<String> windowHandleIds = driver.getWindowHandles();

		for (String individualWinHandle : windowHandleIds) {
			System.out.println(individualWinHandle);
			if (!individualWinHandle.equals(firsWindowName)) {
				driver.switchTo().window(individualWinHandle);
			}
		}

		String printTitle = driver.findElementByXPath("//h1[@class='pdp-title']").getText();
		System.out.println("Moved to 2nd window to print Title: " + printTitle);

		WebElement printTitle1 = driver.findElementByXPath("//h1[@class='pdp-title']");
		JavascriptExecutor sunGlass1 = (JavascriptExecutor) driver;
		sunGlass1.executeScript("arguments[0]. scrollIntoView(true);", printTitle1);
		
		WebElement viewSml = driver.findElementByXPath(
				"//div[@class='image-grid-similarColorsCta product-similarItemCta']//span[@class='image-grid-iconText']");
		
		
		
		JavascriptExecutor viewProd = (JavascriptExecutor) driver;
        //Click
		//viewProd.executeScript("arguments[0].click();", viewSml);
		
	
		//scroll-down
		WebElement scrolDown = driver.findElementByXPath("//div[contains(@class,'desktop-shopLinks')]/p/a");
		viewProd.executeScript("arguments[0]. scrollIntoView(true);", scrolDown);
		/*
		 * driver.findElementByClassName("common-checkboxIndicator").click();
		 * driver.findElementByClassName("common-checkboxIndicator").click();
		 * driver.findElementByClassName("common-checkboxIndicator").click();
		 */

//		Actions().sendKeys(Keys.ESCAPE).build().perform();
//		browser.keys("Escape");

	}

}
