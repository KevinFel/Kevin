package edu.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class WorkingOnElements {
@Test
	void workingElement() {
System.setProperty("webdriver.chrome.driver","G:\\Selenium\\Driver\\chromedriver_version_96\\chromedriver\\chromedriver.exe");
RemoteWebDriver driver =new ChromeDriver();
driver.get("http://automationpractice.com/index.php");
driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
driver.manage().window().maximize();
//Clicking the button
driver.findElementByClassName("login").click();
String details = driver.findElementById("contact-link").getText();
System.out.println(details);
	
//Entering data in Edit box
		driver.findElementById("email_create").sendKeys("oceanacademy123450@gemail.com");
		
		driver.findElementById("SubmitCreate").click();
		
		driver.findElementById("authentication").click();
		driver.findElementById("customer_firstname").sendKeys("Kevin");
		driver.findElementById("customer_lastname").sendKeys("Felix");
		driver.findElementById("passwd").sendKeys("Felix@159");
		
		driver.findElementById("uniform-newsletter").click();
		driver.findElementById("optin").click();
		
		driver.findElementById("company").sendKeys("CTS");

		driver.findElementById("address1").sendKeys("Lawspet");
		driver.findElementById("address2").sendKeys("Pondicherry");
		driver.findElementById("city").sendKeys("Puducherry");
		driver.findElementById("submitAccount").click();
		

		//Selecting a value from a dropdown field.
		WebElement days = driver.findElementById("days");
		Select dateObj = new Select(days);
		dateObj.selectByValue("25");
		
		WebElement months = driver.findElementById("months");
		Select monthsObj = new Select(months);
		monthsObj.selectByValue("5");
		
		
	
		WebElement years = driver.findElementById("years");
		Select yearsObj = new Select(years);
		yearsObj.selectByValue("1985");
	
		
		driver.findElementById("postcode").sendKeys("Puducherry");

		WebElement country = driver.findElementById("id_country");
		Select countryObj = new Select(country);
		countryObj.selectByValue("21");
		

}

}

