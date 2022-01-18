package edu.learning;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandingExample {

	@Test
	public void windowsHandling() {

		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");

		String firstWinTitleName = driver.getTitle();
		System.out.println("Window Title :: " + firstWinTitleName);

		String header = driver.findElementByXPath("//h1[@class='inline']").getText();
		System.out.println(header);

		String firsWindowName = driver.getWindowHandle();
		System.out.println("first windowHandle ID :: " + firsWindowName);

		System.out.println("Parent window Title Name : " + driver.getTitle());

		Set<String> windowHandleIds = driver.getWindowHandles();

		for (String individualWinHandle : windowHandleIds) {
			System.out.println(individualWinHandle);
			driver.switchTo().window(individualWinHandle);
			String pageTitle = driver.getTitle();
			System.out.println("Window  pageTitle Title :: " + pageTitle);

			if (pageTitle.equalsIgnoreCase("SoprA")) {
				driver.findElementByXPath("//img[@alt='Sopra']/..").click();
				 }

		}

		System.out.println("Data to be Printed after clicking the button in new window2");

		Set<String> NewWindowHandleIds = driver.getWindowHandles();

		for (String newWindows : NewWindowHandleIds) {
			System.out.println(newWindows);
			driver.switchTo().window(newWindows);
			String pageNewTitle = driver.getTitle();
			System.out.println("Window pageNewTitle Title :: " + pageNewTitle);

			if (pageNewTitle.equalsIgnoreCase("SoprA")) {
				driver.findElementByXPath("//img[@alt='Sopra']/..").click();
				/*
				 * String header2 = driver.findElementById("jobs_search_305368").getText();
				 * System.out.println("header2");
				 */
				 
				 
				  List<WebElement> abc = driver.findElementsByTagName("a"); 
				  int count = abc.size(); 
				  System.out.println(count);
				  for (WebElement singleElement : abc) {
				  System.out.println(singleElement.getText()); }

			}
		}
		System.out.println("Data to be Printed after clicking the button in new window3");

		Set<String> NewWindowHandleIds1 = driver.getWindowHandles();

		for (String newWindows1 : NewWindowHandleIds1) {
			System.out.println(newWindows1);
			driver.switchTo().window(newWindows1);
			String pageNewTitle1 = driver.getTitle();
			System.out.println("Window pageNewTitle1  Title :: " + pageNewTitle1);

			if (pageNewTitle1.equalsIgnoreCase("Tech Mahindra")) {
				driver.findElementByXPath("//img[@alt='Tech Mahindra']/..").click();
				
				   }

			}
		System.out.println("Data to be Printed after clicking the button in new window 2");
		
		/*
		 * Set<String> NewWindowHandleIds2 = driver.getWindowHandles();
		 * 
		 * for (String newWindows2 : NewWindowHandleIds2) {
		 * System.out.println(newWindows2); driver.switchTo().window(newWindows2);
		 * String pageNewTitle2 = driver.getTitle();
		 * System.out.println("Window pageNewTitle2 Title :: " + pageNewTitle2);
		 * 
		 * if (pageNewTitle2.equalsIgnoreCase("Tech Mahindra")) {
		 * driver.findElementByXPath("//img[@alt='Tech Mahindra']/..").click(); }
		 * 
		 * }
		 */
		/*
		 * Set<String> NewWindowHandleIds2 = driver.getWindowHandles();
		 * 
		 * for (String newWindows2 : NewWindowHandleIds2) {
		 * System.out.println(newWindows2); driver.switchTo().window(newWindows2);
		 * String pageNewTitle2 = driver.getTitle();
		 * System.out.println("Window Title :: " + pageNewTitle2);
		 * 
		 * if (pageNewTitle2.equalsIgnoreCase("IQVIA")) {
		 * driver.findElementByXPath("//img[@alt='IQVIA']//..").click(); } }
		 */
	}
}
