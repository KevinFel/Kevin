package edu.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AtbeforeMethod {

	public RemoteWebDriver driver;

	@BeforeMethod
	public void launchur1() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");

	}
	@Test
	public void executeTestCase () {
		driver.findElementByClassName("login").click();
		String details = driver.findElementById("contact-link").getText();
		System.out.println(details);
		
	}
	@AfterMethod
	public void browerClosed () {
		driver.close();
		
	}
}


