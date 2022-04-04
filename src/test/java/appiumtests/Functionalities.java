package appiumtests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Functionalities extends BaseClass {


	public static void login() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(180));

		WebElement skip = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Skip")));
		skip.click();

		WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Done")));
		done.click();

		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View//android.view.View//android.view.View/android.view.View//android.widget.EditText[1]")));
		user.click();
		Thread.sleep(2000);
		user.sendKeys("123456789");

		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View//android.view.View//android.view.View/android.view.View//android.widget.EditText[2]")));
		pass.click();
		Thread.sleep(2000);
		pass.sendKeys("54321");
		driver.navigate().back();
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Sign In")));
		login.click();
	
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Dashboard")));
		dashboard.isDisplayed();

		
	}
	
	
	public static void invalidLogin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement skip = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Skip")));
		skip.click();

		WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Done")));
		done.click();

		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View//android.view.View//android.view.View/android.view.View//android.widget.EditText[1]")));
		user.click();
		Thread.sleep(2000);
		user.sendKeys("123456789");

		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View//android.view.View//android.view.View/android.view.View//android.widget.EditText[2]")));
		pass.click();
		Thread.sleep(2000);
		pass.sendKeys("12345");
		driver.navigate().back();
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Sign In")));
		login.click();
		
		
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("User Name or Password not valid"))).isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			System.out.println("No Element Found !");
		}
		
		
	}
	
	
	public static void emptyLoginFields() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement skip = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Skip")));
		skip.click();

		WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Done")));
		done.click();

		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View//android.view.View//android.view.View/android.view.View//android.widget.EditText[1]")));
		user.click();
		Thread.sleep(2000);
		user.sendKeys("");

		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View//android.view.View//android.view.View/android.view.View//android.widget.EditText[2]")));
		pass.click();
		Thread.sleep(2000);
		pass.sendKeys("");
		driver.navigate().back();
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Sign In")));
		login.click();
		
		
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("User Name or Password field can't be empty"))).isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			System.out.println("No Element Found !");
		}
		
		
	}

}
