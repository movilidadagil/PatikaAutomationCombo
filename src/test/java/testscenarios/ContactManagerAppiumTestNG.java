package testscenarios;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import mobile_pages.AddContactPage;
import mobile_pages.HomePage;
import utility.DeviceFarmUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ContactManagerAppiumTestNG {


	/*
	{
  "platformName": "Android",
  "appium:deviceName": "oreo",
  "appium:automationName": "UiAutomator2",
  "appium:udid": "emulator-5554",
  "appium:avd": "Pixel_4_XL_API_24",
  "appium:fastReset": true,
  "appium:newCommandTimeout": 5
}
	 */

	public static AppiumDriver<?> Driver;
	HomePage homePage;
	AddContactPage addContactPage;
	String oreo, kitkat;
	DesiredCapabilities capabilities;

	public ContactManagerAppiumTestNG(){
		oreo = DeviceFarm.ANDROID_OREO.path;
		kitkat = DeviceFarm.ANDROID_KITKAT.path;
	}

	@BeforeClass
	public void setup() throws MalformedURLException {

		capabilities = new DesiredCapabilities();
		capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
		capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
		Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
		homePage = new HomePage();
		addContactPage = new AddContactPage();
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName","Pixel_4_XL_API_24");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());

		//capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
		//capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
		//*/



	}

	@Test(priority = 0)
	public void openAddContactOnOreo() throws NullPointerException, InterruptedException {

		homePage.getAddContactBtn().click();
		Thread.sleep(4000);
	}


	//User checks title whether it is "Add Contact"
	@Test(priority = 1)
	public void checkAddContactTitle(){
		Assert.assertEquals(addContactPage.getTitle().getText(),"Add Contact");
	}

	/*@Test(enabled = true)
	public void openAddContactOnKitkat() throws MalformedURLException {
		capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.kitkat);
		capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
		Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
		homePage = new HomePage();
		homePage.getAddContactBtn().click();
	}*/

	@AfterClass
	public void waiter() throws InterruptedException {
		Thread.sleep(5000);
	}

}
