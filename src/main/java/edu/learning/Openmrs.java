package edu.learning;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Openmrs {
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

//Test1
	@Test(priority = 0)
	public void login() throws InterruptedException, IOException {
		test = extreports.createTest("CreateScenario");
		node = test.createNode("EndtoEndFlow");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		WebElement login = driver.findElementById("username");
		login.click();
		login.sendKeys("Admin" + Keys.ENTER);

		WebElement passw = driver.findElementById("password");
		passw.click();
		passw.sendKeys("Admin123");

		WebElement iw = driver.findElementByXPath("//li[text()=\"Isolation Ward\"]");
		Actions ac = new Actions(driver);
		ac.moveToElement(iw).click().build().perform();

		driver.findElementById("loginButton").click();

		Thread.sleep(1000);
		driver.findElementById(
				"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
				.click();

		driver.findElementByName("givenName").sendKeys("Danny");
		driver.findElementByName("middleName").sendKeys("J");
		driver.findElementByName("familyName").sendKeys("Kumar");
		driver.findElementByXPath("//icon[@class='fas fa-chevron-right']").click();

		WebElement gen = driver.findElementByXPath("//select[@name='gender']");

		Select sl = new Select(gen);
		sl.selectByValue("M");

		driver.findElementById("next-button").click();
		driver.findElementById("birthdateDay-field").sendKeys("10");
		WebElement mon = driver.findElementByXPath("//select[@id='birthdateMonth-field']");
		Select s2 = new Select(mon);
		s2.selectByValue("12");
		driver.findElementById("birthdateYear-field").sendKeys("2021");
		driver.findElementById("next-button").click();

		driver.findElementById("address1").sendKeys("lawspet");
		driver.findElementById("address2").sendKeys("lawspet2");
		driver.findElementById("cityVillage").sendKeys("Pondy");
		driver.findElementById("stateProvince").sendKeys("PY-8");
		driver.findElementById("country").sendKeys("IN");
		driver.findElementById("country").sendKeys("6052008");

		driver.findElementById("next-button").click();
		driver.findElementByName("phoneNumber").sendKeys("1234567891");
		driver.findElementById("next-button").click();

		WebElement rel = driver.findElementById("relationship_type");
		Select s3 = new Select(rel);
		s3.selectByValue("2a5f4ff4-a179-4b8a-aa4c-40f71956ebbc-B");

		driver.findElementById("next-button").click();

		driver.findElementByXPath("//input[@value='Confirm']").click();

		// Report/validation

		String name1 = "Danny";
		String idNameP = driver
				.findElementByXPath("//h1[contains(@class,'mt-0 mb-2 name')]//span[@class='PersonName-givenName']")
				.getText();
		System.out.println("Name is " + idNameP);

		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/Create.jpeg"));
		if (idNameP.equals(name1)) {
			node.log(Status.PASS, "Validate the patient details are Created successfully");
			node.addScreenCaptureFromPath(".././snapshot/Create.jpeg");

			
		} else {
			node.log(Status.FAIL, "Validate the patient details are not Created successfully");
			node.addScreenCaptureFromPath(".././snapshot/Create.jpeg");
		}

	}

	// TestCase 2
	@Test(priority = 1)

	public void test2() throws InterruptedException, IOException {

		test = extreports.createTest("UpdateScenario");
		node = test.createNode("EndtoEndFlow");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		WebElement login = driver.findElementById("username");
		login.click();
		login.sendKeys("Admin" + Keys.ENTER);

		WebElement passw = driver.findElementById("password");
		passw.click();
		passw.sendKeys("Admin123");

		WebElement iw = driver.findElementByXPath("//li[text()=\"Isolation Ward\"]");
		Actions ac = new Actions(driver);
		ac.moveToElement(iw).click().build().perform();

		driver.findElementById("loginButton").click();
		driver.findElementByXPath("//div[@id='apps']//i[contains(@class,'icon-search')]").click();
		driver.findElementById("patient-search").sendKeys("Danny J Kumar" + Keys.ENTER);
		Thread.sleep(1000);
		WebElement p1 = driver.findElementByXPath("//td[text()='Danny J Kumar']/..");
		ac.moveToElement(p1).click().build().perform();
		driver.findElementByXPath(
				"//ul[@class='float-left']//a[@id='application.registrationapp.summary.editPatientLink']").click();
		driver.findElementById("demographics-edit-link").click();
		driver.findElementById("next-button").click();
		driver.findElementById("next-button").click();
		driver.findElementById("birthdateDay-field").clear();
		driver.findElementById("birthdateDay-field").sendKeys("11");
		driver.findElementById("next-button").click();
		driver.findElementById("registration-submit").click();

		String name2 = "Danny";
		String idNameP2 = driver
				.findElementByXPath("//h1[contains(@class,'mt-0 mb-2 name')]//span[@class='PersonName-givenName']")
				.getText();
		System.out.println("Name is " + idNameP2);

		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/Create.jpeg"));
		if (idNameP2.equals(name2)) {
			node.log(Status.PASS, "Validate the patient details are Updated successfully");
			node.addScreenCaptureFromPath(".././snapshot/Update.jpeg");

		} else {
			node.log(Status.FAIL, "Validate the patient details are not Updated successfully");
			node.addScreenCaptureFromPath(".././snapshot/Update.jpeg");

		}
	}

	// TestCase3
	 @Test(priority = 2)

	public void test3() throws InterruptedException, IOException {

		test = extreports.createTest("DeleteScenario");
		node = test.createNode("EndtoEndFlow");

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		WebElement login = driver.findElementById("username");
		login.click();
		login.sendKeys("Admin" + Keys.ENTER);

		WebElement passw = driver.findElementById("password");
		passw.click();
		passw.sendKeys("Admin123");

		WebElement iw = driver.findElementByXPath("//li[text()=\"Isolation Ward\"]");
		Actions ac = new Actions(driver);
		ac.moveToElement(iw).click().build().perform();

		driver.findElementById("loginButton").click();

		driver.findElementByXPath("//div[@id='apps']//i[contains(@class,'icon-search')]").click();

		driver.findElementById("patient-search").sendKeys("Danny J Kumar" + Keys.ENTER);
		Thread.sleep(1000);

		driver.findElementByXPath("//tr[@class='odd']//td[text()='Danny J Kumar']").click();
		// Deleted
		driver.findElementByXPath("//li[contains(@class,'float-left')]/..//li[8]").click();
		WebElement res = driver.findElementById("delete-reason");
		ac.click().perform();
		res.sendKeys("Not needed");
		driver.findElementByXPath(
				"//div[contains(@class,'simplemodal-wrap')]//button[contains(@class,'confirm right')]").click();

		String name3 = "Danny";
		String idNameP3 = driver
				.findElementByXPath("//h1[contains(@class,'mt-0 mb-2 name')]//span[@class='PersonName-givenName']")
				.getText();
		System.out.println("Name is " + idNameP3);

		File source = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/Create.jpeg"));
		if (idNameP3.equals(name3)) {
			node.log(Status.PASS, "Validate the patient details are Deleted successfully");
			node.addScreenCaptureFromPath(".././snapshot/Deleted.jpeg");

		} else {
			node.log(Status.FAIL, "Validate the patient details are not Deleted successfully");
			node.addScreenCaptureFromPath(".././snapshot/Deleted.jpeg");

		}

		}


	@AfterClass
	public void closeReport() {
		extreports.flush();
	}

}
