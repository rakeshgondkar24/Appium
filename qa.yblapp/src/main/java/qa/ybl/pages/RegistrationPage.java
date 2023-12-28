package qa.ybl.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	protected String deviceId = "com.atyati.ganaseva.mfi:id/et_Registration_DeviceID";
	
	protected  String userId = "com.atyati.ganaseva.mfi:id/et_Registration_UserID";

	protected  String regbutton = "com.atyati.ganaseva.mfi:id/bt_Registration_Submit";
	
	protected  String KeyGeneration = "android:id/button1";
	
	protected  String DeviceRegistered = "android:id/button1";
	
	protected  String Permission1 = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	
	protected  String Permission2 = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	
	protected  String Permission3 = "com.android.permissioncontroller:id/permission_allow_button";
	
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
//		PageFactory.initElements(driver, this);
	}
	
	public boolean deviceIDField() {
		log = new Logging();
		Boolean val = false;
		try {
			log.Loginfo("Getting the Device ID field status");
			WebElement device = driver.findElement(By.id(deviceId));
			val = device.isDisplayed();
			if(val) {
				val = device.isEnabled();
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
			WebElement user = driver.findElement(By.id(userId));
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
			WebElement register = driver.findElement(By.id(regbutton));
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
	
	public String registration(String DeviceId,String UserId) {
		String result = null;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		log = new Logging();
		log.Loginfo("registrationMethod is started");
		try {
			WebElement device = driver.findElement(By.id(deviceId));
			WebElement user = driver.findElement(By.id(userId));
			WebElement reg = driver.findElement(By.id(regbutton));
			try {
				device.sendKeys(DeviceId);
				user.sendKeys(UserId);
				reg.click();
				//WebElement key = driver.findElement(By.id(KeyGeneration));
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(KeyGeneration)))).click();
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(DeviceRegistered)))).click();
				result = driver.findElement(By.id("android:id/message")).getText();
			}catch(Exception e) {
				log.Logerror("RegistrationPage.registration().SendingValues"+"\n"+e);
			}
		}catch(Exception e) {
			log.Logerror("RegistrationPage.registration()"+"\n"+e);
		}
		return result;
	}
	
}
