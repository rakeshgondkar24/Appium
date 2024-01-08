package qa.yblapp.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
//import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import qa.yblapp.logging.*;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Base {
	public static AndroidDriver driver;
	public Logging log;
	public static WebDriverWait wait;
	public static Properties prop;
	
	public Base() {
		log = new Logging();
		log.Loginfo("Getting into Base Constructor");
		try {
			log.Loginfo("Loading Property File");
			 prop = new Properties();
			String File = "E:\\Rakesh\\Automation\\New folder\\Automation\\YBL\\Practice\\20102\\qa.yblapp\\src\\main\\java\\qa\\yblapp\\config\\config.properties";
			FileInputStream file = new FileInputStream(File);
			try {
				prop.load(file);
				log.Loginfo("Loaded the Property File");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.Logerror("Base.Base().FileInputStream.prop.load(file)"+"\n"+e);
			}
		} catch (FileNotFoundException e) {
			log.Logerror("Base.Base().FileInputStream"+"\n"+e);
		}
	}

	
//	public static void waitForElement(AndroidDriver driver, WebElement element) {
//	    FluentWait<AndroidDriver> wait = new FluentWait(driver)
//	            .withTimeout(Duration.ofSeconds(30))
//	            .pollingEvery(Duration.ofMillis(500));
//	    wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
	
//	public AndroidDriver Initialization() throws MalformedURLException {
//		log = new Logging();
//		prop = new Properties();
//		String main = prop.getProperty("mainjs");
//		String ip = prop.getProperty("ip");
//		String url = prop.getProperty("url");
//		log.Loginfo("MAINJS path is: "+"\n"+main);
//		log.Loginfo("IP Address is: "+"\n"+ip);
//		log.Loginfo("url is: "+"\n"+url);
//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//  				.withAppiumJS(new File("C:\\\\Users\\\\rakesh.g\\\\AppData\\\\Roaming\\\\npm\\\\node_modules\\\\appium\\\\build\\\\lib\\\\main.js"))
//  				.withIPAddress("127.0.0.1")
//  				.usingPort(4732)
//  				.withTimeout(Duration.ofMillis(50000))
//  				.build();
//  		service.start();
//  		log.Loginfo("Services Started-----------");
//  		
//  		log.Loginfo("Getting into UiAutomator2Options");
//  		UiAutomator2Options options = new UiAutomator2Options();
//  		options.setDeviceName("samsung SM-T295");
//  		log.Loginfo("Getting DeviceName");
//  		options.setApp("E:\\Rakesh\\Automation\\New folder\\Automation\\YBL\\Practice\\apk\\yblmfi\\GanasevaMFI_YBL (2).apk");
//  		log.Loginfo("Seeting the App");
//  		//Android Driver
//  		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
//  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//  		try {
//  			driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//  		}catch(Exception e) {
//  			log.Logerror(""+e);
//  		}
//  		return driver;
//	}
	
	public void InitializationForRegisteration() throws MalformedURLException {
		log = new Logging();
		String main = prop.getProperty("mainjs");
		String ip = prop.getProperty("ip");
		String url = prop.getProperty("url");
		String App = prop.getProperty("app");
		String deviceName = prop.getProperty("devicename");
		log.Loginfo("<<<<<<<<<<------Execution Started------>>>>>>>>>>");
		log.Loginfo("MAINJS path is: "+"\n"+main);
		log.Loginfo("IP Address is: "+"\n"+ip);
		log.Loginfo("url is: "+"\n"+url);
		log.Loginfo("App path is: "+"\n"+App);
		log.Loginfo("Device name is: "+"\n"+deviceName);
		AppiumDriverLocalService service = new AppiumServiceBuilder()
  				.withAppiumJS(new File(main))
  				.withIPAddress(ip)
  				.usingPort(4732)
  				.withTimeout(Duration.ofMillis(50000))
  				.build();
  		service.start();
  		log.Loginfo("Services Started-----------");
  		
  		log.Loginfo("Getting into UiAutomator2Options");
  		UiAutomator2Options options = new UiAutomator2Options();
  		options.setDeviceName(deviceName);
  		log.Loginfo("Getting DeviceName");
  		options.setApp(App);
  		log.Loginfo("Seeting the App");
  		//Android Driver
  		driver = new AndroidDriver(new URL(url), options);
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
  		try {
  			driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  		}catch(Exception e) {
  			log.Logerror("Base.InitializationForRegisteration()"+e);
  		}
	}
	
	public void InitializationForLogin() throws MalformedURLException {
		log = new Logging();
		String main = prop.getProperty("mainjs");
		String ip = prop.getProperty("ip");
		String url = prop.getProperty("url");
		String App = prop.getProperty("app");
		String deviceName = prop.getProperty("devicename");
		log.Loginfo("<<<<<<<<<<------Execution Started------>>>>>>>>>>");
		log.Loginfo("MAINJS path is: "+"\n"+main);
		log.Loginfo("IP Address is: "+"\n"+ip);
		log.Loginfo("url is: "+"\n"+url);
		log.Loginfo("App path is: "+"\n"+App);
		log.Loginfo("Device name is: "+"\n"+deviceName);
		AppiumDriverLocalService service = new AppiumServiceBuilder()
  				.withAppiumJS(new File(main))
  				.withIPAddress(ip)
  				.usingPort(4732)
  				.withTimeout(Duration.ofMillis(50000))
  				.build();
  		service.start();
  		log.Loginfo("Services Started-----------");
  		
  		log.Loginfo("Getting into UiAutomator2Options");
  		UiAutomator2Options options = new UiAutomator2Options();
  		options.setDeviceName(deviceName);
  		options.setCapability("noReset", true);
  		log.Loginfo("Getting DeviceName");
  		options.setApp(App);
  		log.Loginfo("Seeting the App");
  		//Android Driver
  		driver = new AndroidDriver(new URL(url), options);
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//  		try {
//  			driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//  		}catch(Exception e) {
//  			log.Logerror("Base.InitializationForLogin()"+e);
//  		}
	}

}
