package appiumtests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
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

		Thread.sleep(3000);
		
		
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
	
	public static void addNewAssessor(String assessorName, String genderType) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction abc = new TouchAction(driver);
		abc.tap(PointOption.point(342,1940)).perform();
		Thread.sleep(3000);
		
		WebElement addNewAssessor = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Add New Assessor")));
		addNewAssessor.click();
		
		//Geo location selection
		
		//Governorate select
		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("(//android.widget.Button[@content-desc=\"Select an Item\"])[1]")));
		el1.click();
		WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("المنيا")));
		el2.click();
		
		//District select
		WebElement el3 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("(//android.widget.Button[@content-desc=\"Select an Item\"])[1]")));
		el3.click();
		WebElement el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("العدوه")));
		el4.click();
		
		//School select
		WebElement el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Select an Item")));
		el5.click();
		WebElement el6 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("فايز ميكائيل فصل واحد")));
		el6.click();
		
		//Submit
		WebElement el7 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Submit")));
		el7.click();

		
		//Assessor information
		
		WebElement assessor= wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")));
		assessor.click();
		Thread.sleep(2000);
		assessor.sendKeys(assessorName);
		Thread.sleep(2000);
		WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Gender")));
		gender.click();
		WebElement genderMale = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(genderType)));
		genderMale.click();
		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Submit")));
		submit.click();

		Assert.assertTrue(true);
		
		Thread.sleep(3000);
	}

}
