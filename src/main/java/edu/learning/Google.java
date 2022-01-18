package edu.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Google {
	@Test
	void workingElement() {
		System.setProperty("webdriver.chrome.driver","G:\\Selenium\\Driver\\chromedriver_version_96\\chromedriver\\chromedriver.exe");
		RemoteWebDriver driver =new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElementById("src").sendKeys("Bengaluru"+Keys.ENTER);
		
		driver.findElementById("dest").sendKeys("Chennai"+Keys.ENTER);
		driver.findElementByXPath("//td[@class='wd day'])[2]//.").click();	
		driver.findElementById("search_btn").click();
		
		
	
		
	
}
	
}
