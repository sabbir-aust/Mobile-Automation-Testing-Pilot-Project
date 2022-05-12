package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Capabilities {
	
	public static AndroidDriver<MobileElement> driver = null;
	
	public static AndroidDriver start() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("deviceName", "Sabbir");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("app", "C:\\Users\\sabinul.sabbir\\eclipse-workspace\\appiumtests\\apk\\RARS_V1.0.0.apk");


		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		return driver = new AndroidDriver(url,caps);	
	}
}
