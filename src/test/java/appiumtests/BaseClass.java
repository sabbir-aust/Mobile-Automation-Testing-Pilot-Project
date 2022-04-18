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
	protected static AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		driver = start();
	}
	
	@Test
	public void validLogin() throws InterruptedException {
		
		Functionalities.login();
		
	}
	
	@Test
	public void invalidLoginAttempt() throws InterruptedException {
		
		Functionalities.invalidLogin();
	}
	
	@Test
	public void loginWithEmptyField() throws InterruptedException {
		
		Functionalities.emptyLoginFields();
	}

	@Test
	public void addNewAssessors() throws InterruptedException {
		
		Functionalities.login();
		Functionalities.addNewAssessor("Sabbir Ahmed", "Male");
	}
	
	@AfterTest
	public void afterTest() {
		if(driver != null) {
			driver.quit();
		}
	}
}
