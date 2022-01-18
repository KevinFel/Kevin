package edu.learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoClass {
	
	public void demo1() {

		
WebDriverManager.chromedriver().setup();
RemoteWebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
List<WebElement> abc  = driver.findElementsByTagName("a");
int count = abc.size();
System.out.println(count);

for (WebElement singleElement : abc) {
System.out.println(singleElement.getText());
	}

	
	
}}
