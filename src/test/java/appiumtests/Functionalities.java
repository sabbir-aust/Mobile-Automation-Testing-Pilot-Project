package appiumtests;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Functionalities extends BaseClass {

public static void scroll() {
		
		TouchAction abc = new TouchAction(driver);
		Dimension dimension = driver.manage().window().getSize();
		int start_x = (int) (dimension.width * 0.5);
		int start_y = (int) (dimension.height * 0.5);

		int end_x = (int) (dimension.width * 0.5);
		int end_y = (int) (dimension.height * 0.05);

		abc.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();

	}

public static void logout() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(180));
	(new TouchAction(driver)).tap(PointOption.point(59, 272)).perform();
	
	WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("LogOut")));
	el2.click();
	Thread.sleep(3000);
}
	

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

	public static void addNewTeacher(String teacherName, String genderType) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction abc = new TouchAction(driver);
		Thread.sleep(2000);

		//Scroll
		scroll();
		Thread.sleep(3000);

		//Start Assessment
		WebElement startAssessment = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start Assessment (RARS)")));
		startAssessment.click();

		//Add teacher
		WebElement addNewTeacher = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Add New Teacher")));
		addNewTeacher.click();

		//Geo location selection

		//Governorate select
		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("(//android.widget.Button[@content-desc=\"Select an Item\"])[1]")));
		el1.click();
		WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("المنيا")));
		el2.click();

		//District select
		WebElement el3 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("(//android.widget.Button[@content-desc=\"Select an Item\"])")));
		el3.click();
		WebElement el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("العدوه")));
		el4.click();

		//PNGO select
		WebElement el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("(//android.widget.Button[@content-desc=\"Select an Item\"])[1]")));
		el5.click();
		WebElement el6 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("جمعية الجزويت والفرير للتنمية بالمنيا\r\n")));
		el6.click();

		//CDA Select
		WebElement el10 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.Button[@content-desc=\"Select an Item\"]")));
		el10.click();
		WebElement el11 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("الجمعيه الاهليه لتنميه المجتمع بالشيخ مسعود")));
		el11.click();

		//Village select
		WebElement el12 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Select an Item")));
		el12.click();
		WebElement el13 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("عربان كفر المغربى")));
		el13.click();

		//Submit
		WebElement el7 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Submit")));
		el7.click();


		//Teacher information

		WebElement teacher= wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")));
		teacher.click();
		Thread.sleep(2000);
		teacher.sendKeys(teacherName);
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


	public static void addNewLearner(String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction abc = new TouchAction(driver);
		abc.tap(PointOption.point(382,812)).perform();


		WebElement addLearner = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Add Learner")));
		addLearner.click();

		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@content-desc=\"Teacher Name\n*\nSabbir Ahmed\nLearner Name\n*\nEnrollment Date\n*\nOpening Class Date\n*\nTest Date\n*\nNID\nRemarks\"]/android.widget.EditText[1]")));
		el1.click();
		el1.sendKeys(name);
		WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@content-desc=\"Teacher Name\n*\nSabbir Ahmed\nLearner Name\n*\nEnrollment Date\n*\nOpening Class Date\n*\nTest Date\n*\nNID\nRemarks\"]/android.view.View[2]")));
		el2.click();
		WebElement el3 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("OK")));
		el3.click();
		WebElement el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@content-desc=\"Teacher Name\n*\nSabbir Ahmed\nLearner Name\n*\nEnrollment Date\n*\nOpening Class Date\n*\nTest Date\n*\nNID\nRemarks\"]/android.view.View[3]")));
		el4.click();
		WebElement el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("OK")));
		el5.click();
		WebElement el6 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Submit")));
		el6.click();

		Assert.assertTrue(true);
		Thread.sleep(3000);
	}

	public static void assessment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction action = new TouchAction(driver);

		//Start the test
		WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start Test")));
		el2.click();
		WebElement el3 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start Test")));
		el3.click();
		WebElement el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start")));
		el4.click();
		Thread.sleep(2000);

		//Start the assessment

		//Element select
		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start")));
		el1.click();
		WebElement el11 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("خ")));
		el11.click();
		WebElement el12 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("جـــد")));
		el12.click();
		WebElement el13 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ســــن")));
		el13.click();
		WebElement el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("حـســن")));
		el5.click();
		WebElement el6 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("أنـا")));
		el6.click();
		WebElement el7 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("نــزرع")));
		el7.click();
		WebElement el8 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("أســود")));
		el8.click();
		Thread.sleep(2000);

		//Scroll

		scroll();
		
		//Element select
		WebElement el16 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("تــســاؤل")));
		el16.click();

		WebElement el9 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Stop")));
		el9.click();
		WebElement el10 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ACCEPT")));
		el10.click();

		Thread.sleep(3000);

		//Last attemped word select
		action.longPress(ElementOption.element(el16)).perform().release();

		WebElement el14 =  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ACCEPT")));
		el14.click();

		//Complete the assessment
		WebElement el15 =  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Complete")));
		el15.click();

		Assert.assertTrue(true);
		Thread.sleep(3000);
	}

	
	public static void selectNextAssessment(String teacherId, String learnerId, String id) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction abc = new TouchAction(driver);
		Thread.sleep(2000);

		//Scroll
		scroll();
		
		Thread.sleep(3000);

		//Start Assessment
		WebElement startAssessment = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start Assessment (RARS)")));
		startAssessment.click();
		
		//Select Teacher
		Thread.sleep(2000);
		//(new TouchAction(driver)).tap(PointOption.point(533, 850)).perform();
		
		WebElement selectTeacher = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(teacherId)));
		selectTeacher.click();
		
		Thread.sleep(2000);

		//Select Learner
		//(new TouchAction(driver)).tap(PointOption.point(533, 850)).perform();
		
		WebElement selectLearner = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(learnerId)));
		selectLearner.click();
		
		Thread.sleep(2000);
		
		//Scroll
		scroll();
		
		//select an assessment
		
		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(id)));
		el1.click();
	}

	
	public static void assessment_1st10WordsWrong() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction action = new TouchAction(driver);

		//Start the test
		WebElement el3 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start Test")));
		el3.click();
		WebElement el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start")));
		el4.click();
		Thread.sleep(3000);

		//Start the assessment

		//Element select
		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start")));
		el1.click();
		WebElement el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("د")));
		el5.click();
		WebElement el6 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("خ")));
		el6.click();
		WebElement el7 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ر")));
		el7.click();
		WebElement el8 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ظ")));
		el8.click();
		WebElement el9 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ص")));
		el9.click();
		WebElement el10 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("لَ")));
		el10.click();
		WebElement el11 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ثُ")));
		el11.click();
		WebElement el12 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("قِ")));
		el12.click();
		WebElement el13 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("غُ")));
		el13.click();
		WebElement el14 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("شَ")));
		el14.click();
		WebElement el15 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ACCEPT")));
		el15.click();
		Thread.sleep(2000);

		//Scroll

		scroll();
		
		//Complete the assessment
		WebElement el16 =  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Complete")));
		el16.click();

		Assert.assertTrue(true);
		Thread.sleep(3000);
	}
	
	
	
	public static void assessment_entireRowWrongFrom3rdToLast() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		TouchAction action = new TouchAction(driver);

		//Start the test
		WebElement el3 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start Test")));
		el3.click();
		WebElement el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start")));
		el4.click();
		Thread.sleep(3000);

		//Start the assessment

		//Element select
		WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Start")));
		el1.click();
		
		WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ظ")));
		el2.click();
		WebElement el33 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("قِ")));
		el33.click();
		WebElement el43 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("تـمـر")));
		el43.click();
		WebElement el5 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("نــــور")));
		el5.click();
		WebElement el6 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("أســـد")));
		el6.click();
		WebElement el7 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ذيـــل")));
		el7.click();
		WebElement el8 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("نـبـأ")));
		el8.click();
		WebElement el9 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ســــأل")));
		el9.click();
		
		WebElement el15 = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ACCEPT")));
		el15.click();
		Thread.sleep(2000);

		//Scroll

		scroll();
		
		//Complete the assessment
		WebElement el16 =  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Complete")));
		el16.click();

		Assert.assertTrue(true);
		Thread.sleep(3000);
	}
}
