package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends Capabilities{

	//static AppiumDriver<MobileElement> driver;
	public static AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		driver = start();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		Functionalities.login();
		Thread.sleep(3000);
		Functionalities.logout();
//		Functionalities.invalidLogin();
//		Functionalities.emptyLoginFields();
	}
	
	
	@Test
	public void newTeacher() throws InterruptedException {
		
		Functionalities.login();
		Functionalities.addNewTeacher("Sabbir Ahmed", "Male");
	}
	
	@Test
	public void newStudent() throws InterruptedException {
		
		Functionalities.login();
		Functionalities.addNewTeacher("Sabbir Ahmed", "Male");
		Functionalities.addNewLearner("Sabbir");
	}
	
	@Test
	public void assessments() throws InterruptedException {
		Functionalities.login();
		Functionalities.addNewTeacher("Sabbir Ahmed", "Male");
		Functionalities.addNewLearner("Sabbir");
		Functionalities.assessment();
		Functionalities.selectNextAssessment("Sabbir Ahmed\nGender : Male\n2022-05-12","Sabbir\nID:\nEntry Date : 2022-05-12\n2022-05-12","Start 2nd Assessment");
		Functionalities.assessment_1st10WordsWrong();
		Functionalities.selectNextAssessment("Sabbir Ahmed\nGender : Male\n2022-05-12","Sabbir\nID:\nEntry Date : 2022-05-12\n2022-05-12","Start 3rd Assessment");
		Functionalities.assessment_entireRowWrongFrom3rdToLast();
		Functionalities.logout();
	}
	
	@AfterTest
	public void afterTest() {
		if(driver != null) {
			driver.quit();
		}
	}
}
