package edu.learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHanding {

@Test
public void windowsHandling() {
	

WebDriverManager.chromedriver().setup();
RemoteWebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.get("https://indiarailinfo.com/");

String localValue = driver.findElementByClassName("pinkColor").getText();
System.out.println(localValue);

String firstWinTitleName = driver.getTitle();
System.out.println("Window Title :: "+ firstWinTitleName);

String firsWindowName = driver.getWindowHandle();
System.out.println("first windowHandle ID :: "+firsWindowName);

driver.findElementByLinkText("FmT LIVE").click();
Set<String> windowHandleIds = driver.getWindowHandles();

for (String individualWinHandle : windowHandleIds) {
System.out.println(individualWinHandle);
if(!individualWinHandle.equals(firsWindowName)) {
driver.switchTo().window(individualWinHandle);
}
}

String valueNewWindow = driver.findElementByXPath("//h1[@itemprop='name']/span").getText();
System.out.println("value from new window:: "+valueNewWindow);


	}
}
