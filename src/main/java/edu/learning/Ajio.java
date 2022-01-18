package edu.learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	WebDriver driver;

	@Test
	public void method() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ajio.com/shop/sale");

		WebElement searchAj = driver.findElementByXPath("//input[contains(@placeholder,'Search AJIO')]/..");

		Actions acMouse = new Actions(driver);
		acMouse.moveToElement(searchAj).click().build().perform();

		WebElement shoes = driver.findElementByXPath("//span[text()='shoes']/..");
		acMouse.moveToElement(shoes).click().build().perform();

		WebElement women = driver.findElementById("Women");
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", women);

		Thread.sleep(3000);

		WebElement grid = driver.findElementByXPath("//div[contains(@class,'five-grid-container ')]/../div[2]");
		acMouse.moveToElement(grid).click().build().perform();

		WebElement sort = driver.findElementByClassName("ic-Chevron-down");
		acMouse.moveToElement(sort).click().build().perform();

		WebElement whatNew = driver.findElementByXPath("//option[@value='newn']/..");
		Select dateObj = new Select(whatNew);
		dateObj.selectByValue("newn");

		WebElement price = driver.findElementByXPath("//span[text()='price']/..");
		js2.executeScript("arguments[0].click();", price);

		WebElement minP = driver.findElementById("minPrice");
		acMouse.moveToElement(minP).click().perform();
		minP.sendKeys("2000");

		WebElement maxP = driver.findElementById("maxPrice");
		acMouse.moveToElement(maxP).click().perform();
		maxP.sendKeys("2501");

		WebElement sumbit2 = driver.findElementByXPath("//input[@id='maxPrice']/..//button");
		js2.executeScript("arguments[0].click();", sumbit2);

		WebElement clickImage = driver
				.findElementByXPath("//img[contains(@class,'rilrtl-lazy-img  rilrtl-lazy-img-loaded')]");
		js2.executeScript("arguments[0].click();", clickImage);

		String firstWinTitleName = driver.getTitle();
		System.out.println("Window Title :: " + firstWinTitleName);

		String firsWindowName = driver.getWindowHandle();
		System.out.println("first windowHandle ID :: " + firsWindowName);

		Set<String> windowHandleIds = driver.getWindowHandles();

		for (String individualWinHandle : windowHandleIds) {
			System.out.println(individualWinHandle);
			if (!individualWinHandle.equals(firsWindowName)) {
				driver.switchTo().window(individualWinHandle);
			}
		}

		String priceB = driver.findElementByXPath("//div[contains(@class,'prod-gst')]/..//span[2]").getText();
		System.out.println("Discount " + priceB);

		String amount = driver.findElementByXPath("//div[contains(@class,'prod-price-section')]//div[@class='prod-sp']")
				.getText();
		System.out.println("Amount of the product is " + amount);

		String actAmount = driver.findElementByXPath("//div[contains(@class,'promo-discounted-price')]").getText();
		System.out.println("Discount of 50% " + actAmount);

		driver.findElementByXPath(
				"(//div[contains(@class,'size-variant-block')]//div[contains(@class,'circle size-variant-item size-instock ')])[1]")
				.click();

		driver.findElementByXPath("//span[contains(@class,'ic-address edd-pincode-msg-address-icon')]/..").click();
		WebElement pincode = driver.findElementByClassName("edd-pincode-modal-text");
		acMouse.moveToElement(pincode).click().sendKeys("605008");
		WebElement sumb = driver.findElementByXPath("(//button[@type='submit'])[2]");
		acMouse.moveToElement(sumb).click().build().perform();

		Thread.sleep(2000);
		String cod = driver.findElementByXPath("//ul[@class='edd-message-success-details']").getText();
		System.out.println(cod);
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		String customerDet = driver.findElementByXPath("(//div[@class='mandatory-list'])[6]").getText();
		System.out.println(customerDet);
		WebElement cart = driver.findElementByXPath("//div[@class='btn-gold']//span[@class='ic-pdp-add-cart']");
		acMouse.moveToElement(cart).click().build().perform();

		Thread.sleep(3000);
		WebElement bag = driver
				.findElementByXPath("//div[contains(@class,'btn-cart ')]//span[@class='ic-pdp-add-cart']");
		acMouse.moveToElement(bag).click().build().perform();
		
		WebElement coupons = driver.findElementByXPath("(//div[@class='voucher-list-item']//span[contains(@class,'ic-Radio-Buton-Of default-radio-button ')])[1]");
		acMouse.moveToElement(coupons).click().build().perform();
		
		WebElement apply = driver.findElementByXPath("//div[@class='input-box-div']//button[contains(@class,'rilrtl-button button apply-button ')]");
		acMouse.moveToElement(apply).click().build().perform();
		
		String discountPri = driver.findElementByXPath("//div[contains(@class,'product-card navigation-product-card apply-coupon applied-product-card')]").getText();
System.out.println(discountPri);
		
	}
}
