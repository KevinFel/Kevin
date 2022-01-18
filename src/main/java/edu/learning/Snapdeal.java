package edu.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	
	WebDriver driver;

	@Test
	public void Spdeal() {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
	

		Actions actinObj = new Actions(driver);
//Moving to AllOffer 
		WebElement allOffer = driver.findElementByClassName("catText");
		actinObj.moveToElement(allOffer).perform();
//Moving to fastTsk
		WebElement fastTsk = driver.findElementByXPath("//span[text()='Fastrack']");
		actinObj.moveToElement(fastTsk).click().build().perform();
//clicking womWatch
		WebElement womWatch = driver.findElementByXPath("//div[text()='Watches For Women']");
		actinObj.moveToElement(womWatch).click().build().perform();
		driver.findElementByXPath("//input[@placeholder='Search by Brand']").click();
//Search Brand click
		WebElement search = driver.findElementByXPath("//i[@class='sd-icon sd-icon-search-under-catagory adv-search-icon']");
		actinObj.moveToElement(search).sendKeys("Redux").build().perform();
//Selecting Brand Name
		driver.findElementByXPath("//label[@for='Brand-Redux']").click();
//Apply		
		WebElement applyButton = driver.findElementByXPath("//div[@class='btn applyFilters lfloat']");
		applyButton.click();
		this.driver = driver;
//LikeButton
		WebElement likeButton = driver.findElementByXPath("//span[@data-pog='637816293819']");
		JavascriptExecutor featuredWatch = (JavascriptExecutor) driver;
        //Click
		featuredWatch.executeScript("arguments[0].click();", likeButton);
//Close_loginPage		
		
        WebElement loginClose = driver.findElementByXPath("//div[@id='close-pop']");
        loginClose.click();
        //featuredWatch.executeScript("arguments[0].click();", loginClose);
        this.driver = driver;

		
		
		
		}
	
	@AfterTest
	public void windowquit () throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();	}
	
	
}
