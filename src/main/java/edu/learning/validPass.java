package edu.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class validPass {

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
		driver.findElementById("email").sendKeys("oceanacademy12345@gemail.com");
		driver.findElementById("passwd").sendKeys("Pass@159");
		driver.findElementById("SubmitLogin").click();
	}}
