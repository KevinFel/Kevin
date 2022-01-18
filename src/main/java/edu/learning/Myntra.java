package edu.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	

	@Test
	public void driver() throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");

		driver.findElementByClassName("desktop-searchBar").sendKeys("Sunglass" + Keys.ENTER);

		// driver.findElementByClassName("common-radioIndicator").click();
		// driver.findElementByXPath("//input[@value='men,men women']");
		// driver.findElementByXPath("//ul[@class='gender-list']/li[1]//input").click();
		// label[contains(@class,'common')]//following::div
		// driver.findElementByXPath("//input[@value='men,men
		// women']//following::div").click();

		// RadioButton.click;

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

		// ViewSmilarProducts
		WebElement viewSml = driver.findElementByXPath(
				"//div[@class='image-grid-similarColorsCta product-similarItemCta']//span[@class='image-grid-iconText']");
		JavascriptExecutor viewProd = (JavascriptExecutor) driver;
        //Click
		viewProd.executeScript("arguments[0].click();", viewSml);
		
		//Print Size
		int count = driver.findElements(By.xpath("//ul[@class='results-base results-similarGrid']/li")).size();
		
		System.out.println("Total Count of the Product: "+ count);
	
		//ScrollDown and Print the list Size of the Product:
	
		WebElement scrolDown = driver.findElementByXPath("//ul[@class='results-base results-similarGrid']/li["+count+"]");
		viewProd.executeScript("arguments[0]. scrollIntoView(true);", scrolDown);
		
		int count2 = driver.findElements(By.xpath("//h4[@class='product-sizes']")).size();
		
		System.out.println("Total Count Size of the Glass: "+count2);
		
		
		
		
	}

	
}