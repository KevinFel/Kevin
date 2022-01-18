package edu.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zomato {

	@Test
	public void mato() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.zomato.com/chennai");

		Actions aMos = new Actions(driver);
		driver.findElementByXPath("//input[contains(@placeholder,'Search for restaurant, cuisine or a dish')]/..")
				.click();
		driver.findElementByXPath("//input[contains(@placeholder,'Search for restaurant, cuisine or a dish')]")
				.sendKeys("A2B" + Keys.ENTER);
		driver.findElementByXPath("//p[text()='A2B - Adyar Ananda Bhavan']").click();

		String hotel = driver.findElementByXPath("//span[contains(@class,'sc-lhVmIH iYoYyT')]/..").getText();
		System.out.println("This Hotel is " + hotel);

		WebElement online = driver.findElementByXPath("//a[text()='Order Online']/..");
		aMos.moveToElement(online).click().perform();

		int count = driver.findElementsByXPath("//div[text()='MUST TRY']").size();
		System.out.println("Number of Must try items are " + count);

		
		 WebElement sweet = driver. findElementByXPath("(//*[contains(text(),'Sweets (')])[1]");
		 aMos.moveToElement(sweet).click().perform();
		 
		
		List<WebElement> myList= driver.findElementsByXPath("//div[contains(@class,'sc-17hyc2s-3 jOoliK sc-1s0saks-8 gYkxGN')]");
	    //To store all web elements into list

	    List<String> all_elements_text= new ArrayList<String>();
	    //If you want to get all elements text into array list

	    for(int i=0; i<myList.size(); i++){

	        all_elements_text.add(myList.get(i).getText());
	        //loading text of each element in to array all_elements_text
	        System.out.println(myList.get(i).getText());
	    }

	    Object obj = Collections.max(all_elements_text);
	    Arrays.sort((int[]) obj);
	 
	    System.out.println(obj);
	    
	    
		int count1 = driver.findElementsByXPath("//div[contains(@class,'sc-17hyc2s-3 jOoliK sc-1s0saks-8 gYkxGN')]")
				.size();
		System.out.println("Number of items costest price is " + count1);

		/*
		 * int sum = x[i]; int x[] = new int[count1]; for (int i = 0; i < x.length; i++) {
		 * sum += 0; } System.out.println(sum); Arrays.sort(x);
		 * System.out.println("Minium price is " + x[0]); int max = x.length - 1;
		 * System.out.println("Maxium price is " + max);
		 * 
		 */
		
		
		Thread.sleep(10000);
		driver.close();

	}

}
