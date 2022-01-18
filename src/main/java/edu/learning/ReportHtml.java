package edu.learning;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.internal.cache.DiskLruCache.Snapshot;

public class ReportHtml {

	ExtentReports extreports;
	ExtentSparkReporter sparkReporter;
	ExtentTest test;
	ExtentTest node;

	@BeforeClass
	public void generateReport() throws IOException {
		extreports = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("testResult/htmlreport.html");
		extreports.attachReporter(sparkReporter);
	}

	@Test
	public void framesElement() throws IOException {
		test = extreports.createTest("Framesreport");
		node = test.createNode("EndtoEndFlow");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/frames");
		
		driver.switchTo().frame("frame1");
		String value = driver.findElementById("sampleHeading").getText();

		System.out.println(value);

		driver.switchTo().defaultContent();
		String textValue = driver.findElementByXPath("//div[@id='framesWrapper']/div").getText();
		System.out.println(textValue);

		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/frames.jpeg"));

		if (textValue.contains("There are 2 Iframes in this page")) {
			node.log(Status.PASS, "Frames is working fine");
			node.addScreenCaptureFromPath(".././snapshot/frames.jpeg");

		} else {
			node.log(Status.FAIL, "Frames is not working fine");
			node.addScreenCaptureFromPath(".././snapshot/frames.jpeg");

		}
	}

	@Test
	public void searchBuses() throws InterruptedException, IOException {
		test = extreports.createTest("RedBus");
		node = test.createNode("EndtoEndFlow");
		

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");

		driver.findElementById("src").sendKeys("Koyambedu, Chennai");
		Thread.sleep(2000);
		driver.findElementById("src").sendKeys(Keys.TAB);

		driver.findElementById("dest").sendKeys("Mattuthavani, Madurai");
		Thread.sleep(2000);
		driver.findElementById("dest").sendKeys(Keys.TAB);

	
		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/redbus.jpeg"));
		node.log(Status.PASS, "RedBus executed successfully");
		node.addScreenCaptureFromPath(".././snapshot/redbus.jpeg");

	}

	@AfterClass
	public void closeReport() {
		extreports.flush();
	}

}

