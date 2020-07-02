/**
 * 
 */
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import gherkin.lexer.Fi;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.testng.internal.TestResult;

public class Hook {

	private static WebDriver driver;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date dateTime = new Date();

	@Before("@web")
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Before("@Android")
	public void setUpAppium() throws MalformedURLException
	{
		System.out.println("Start testing");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "INE LX2");
		caps.setCapability("appPackage", "com.glowie.staging");
		caps.setCapability("appActivity","com.glowie.app.ui.feature.splashscreen.view.SplashScreenActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Before("@iOS")
//	public void setUpAppiumiOS() throws MalformedURLException
//	{
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "INE LX2");
//		caps.setCapability("appPackage", "com.glowie.staging");
//		caps.setCapability("appActivity","com.glowie.app.ui.feature.splashscreen.view.SplashScreenActivity");
//		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}

//	@Before
//	public void beforeMethod(){
//		System.out.println("loginTest before Method");
//		((CanRecordScreen) driver).startRecordingScreen();
//	}
//
//	@After
//	public void afterMethod(ITestResult result) {
//		System.out.println("supor after method");
//		String media = ((CanRecordScreen) driver).stopRecordingScreen();
//
//		Map <String,String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
//
//		String dir = "Video" +File.separator + dateTime + File.separator + result.getTestClass().getRealClass().getSimpleName();
//		File videoDir = new File(dir);
//		if(!videoDir.exists()){
//			videoDir.mkdirs();
//		}
//		try {
//			FileOutputStream stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
//			stream.write(Base64.decodeBase64(media));
//		} catch (FileNotFoundException e){
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@After
	public void tearDown()
	{
		System.out.println("End test...");
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
