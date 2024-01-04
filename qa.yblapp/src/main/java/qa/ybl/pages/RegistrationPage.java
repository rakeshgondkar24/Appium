package qa.ybl.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.yblapp.base.Base;
import qa.yblapp.logging.*;

public class RegistrationPage extends Base{
	/*
	This contains all the information like text fields, buttons which are available in
	registration page.
	*/
	public Logging log;
	public WebDriverWait wait;
	
//	protected By deviceId = By.id("com.atyati.ganaseva.mfi:id/et_Registration_DeviceID");
	
	protected  By userId = By.id("com.atyati.ganaseva.mfi:id/et_Registration_UserID");

	protected  By regbutton = By.id("com.atyati.ganaseva.mfi:id/bt_Registration_Submit");
	
	protected By Keyval = By.id("android:id/message");
	
	protected  By KeyGeneration = By.id("android:id/button1");
	
	protected  By DeviceRegistered = By.id("android:id/button1");
	
	protected  By Permission1 = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	
	protected  By Permission2 = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	
	protected  By Permission3 = By.id("com.android.permissioncontroller:id/permission_allow_button");
	
	@AndroidFindBy(id="com.atyati.ganaseva.mfi:id/et_Registration_DeviceID")
	private WebElement deviceID;
	/*key xpath=//android.widget.TextView[@resource-id='android:id/message']
	id= android:id/message
	*/
	
	/*Device Registered xpath=//android.widget.TextView[@resource-id='android:id/message']
	id= android:id/message
	*/
	
	/*Allow Ganaseva MFI to take picture {com.android.permissioncontroller:id/permission_message}
	 * xpath=//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']
	id= com.android.permissioncontroller:id/permission_allow_foreground_only_button
	*/
	
	/*Allow Ganaseva MFI to access this device location {com.android.permissioncontroller:id/permission_message}
	 * xpath= //android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']
	id= com.android.permissioncontroller:id/permission_allow_foreground_only_button
	*/
	
	/*Allow Ganaseva MFI to access photo,media and files {com.android.permissioncontroller:id/permission_message}
	 * xpath= //android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']
	id= com.android.permissioncontroller:id/permission_allow_button
	*/
	
	public RegistrationPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean deviceIDField() {
		log = new Logging();
		Boolean val = false;
		try {
			log.Loginfo("Getting the Device ID field status");
//			WebElement device = driver.findElement(deviceId);
//			val = device.isDisplayed();
			val = deviceID.isDisplayed();
			if(val) {
				val = deviceID.isEnabled();
			}else {
				val = false;
			}
		}catch(Exception e) {
			log.Logerror("RegistrationPage.deviceIDField()"+"\n"+e);
		}
		return val;
	}
	
	public boolean userIDField() {
		log = new Logging();
		Boolean val = false;
		try {
			log.Loginfo("Getting the User ID field status");
//			WebElement user = driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_Registration_UserID"));
			WebElement user = driver.findElement(userId);
			val = user.isDisplayed();
			if(val) {
				val = user.isEnabled();
			}else {
				val = false;
			}
		}catch(Exception e) {
			log.Logerror("RegistrationPage.userIDField()"+"\n"+e);
		}
		return val;
	}
	
	public boolean registerButton() {
		log = new Logging();
		Boolean val = false;
		try {
			log.Loginfo("Getting the Register Button status");
//			WebElement registerbutton = driver.findElement(By.id("com.atyati.ganaseva.mfi:id/bt_Registration_Submit"));
			WebElement register = driver.findElement(regbutton);
			val = register.isDisplayed();
			if(val) {
				val = register.isEnabled();
			}else {
				val = false;
			}
		}catch(Exception e) {
			log.Logerror("RegistrationPage.registerButton()"+"\n"+e);
		}
		return val;
	}
	
	public String registration(String TestFlag,String DeviceId,String UserId) {
		String Testflag = TestFlag.toLowerCase();
		String result = null;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		log = new Logging();
		log.Loginfo("DEEVICE ID is: "+DeviceId);
		log.Loginfo("USER ID is: "+UserId);
		log.Loginfo("registrationMethod is started");
		try {
			if (Testflag=="d") {
				try {
//					WebElement device = driver.findElement(deviceId);
					wait.until(ExpectedConditions.visibilityOf(deviceID));
					WebElement user = driver.findElement(userId);
					wait.until(ExpectedConditions.visibilityOf(user));
					WebElement reg = driver.findElement(regbutton);
					wait.until(ExpectedConditions.visibilityOf(reg));
					try {
						deviceID.sendKeys(DeviceId);
						user.sendKeys(UserId);
						reg.click();
						String key = "Your Key is";
						String res = "Device Registered";
						//WebElement key = driver.findElement(By.id(KeyGeneration));
						//				result = driver.findElement(By.id("android:id/message")).getText();
						//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(KeyGeneration)))).click();
						//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(DeviceRegistered)))).click();
						result = driver.findElement(Keyval).getText();
						if (result.contains(key)) {
							WebElement KeyGenOk = wait
									.until(ExpectedConditions.elementToBeClickable(driver.findElement(KeyGeneration)));
							KeyGenOk.click();
							WebElement Final = wait.until(ExpectedConditions.visibilityOfElementLocated(Keyval));
							result = Final.getText();
							if (result.contains(res)) {
								wait.until(
										ExpectedConditions.elementToBeClickable(driver.findElement(DeviceRegistered)))
										.click();
								wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Permission1)))
										.click();
								wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Permission2)))
										.click();
								wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Permission3)))
										.click();
							}
						}
					} catch (Exception e) {
						log.Logerror("RegistrationPage.registration().SendingValues" + "\n" + e);
					}
				} catch (Exception e) {
					log.Logerror("RegistrationPage.registration()" + "\n" + e);
				} 
			}else {
				result = "Test Skipped";
			}
		} catch (Exception e) {
			log.Logerror(""+"\n"+e);
		}
		return result;
	}
	
}
