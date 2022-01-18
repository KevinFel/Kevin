package edu.learning;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllReportScreenShot{
	
	@Test 
	public void getEnrolcount() throws InterruptedException, IOException {
		ExtentReports extreports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("demoTestResult/demohtmlreport.html");
		extreports.attachReporter(sparkReporter);
		ExtentTest test = extreports.createTest("Button check");
		ExtentTest node = test.createNode("EndtoEndFlow");
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://oceanacademy.in/");
		
		driver.findElementByXPath("(//a[@id='ab'])[1]/i").click();
		List<WebElement> buttonElement = driver.findElementsById("d");		
		int count = buttonElement.size();
		System.out.println("Total enrol button count ::"+ count);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/buttonCheck.jpeg"));
		
		if(count==4) {
			node.log(Status.PASS, "Button count is correct");	
			node.addScreenCaptureFromPath(".././snapshot/buttonCheck.jpeg");

		}else {
			node.log(Status.FAIL, "Button count is not correct");
			node.addScreenCaptureFromPath(".././snapshot/buttonCheck.jpeg");

		}
		
		extreports.flush();
	}

}


