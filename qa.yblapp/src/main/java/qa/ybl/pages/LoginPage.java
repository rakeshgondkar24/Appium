package qa.ybl.pages;

import qa.yblapp.base.Base;
import qa.yblapp.logging.Logging;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends Base{
	/*
	 *This class contains all the information of login page like text fields, buttons.
	 */

	/*Username
	 * id = com.atyati.ganaseva.mfi:id/et_Username
	 * xpath = //android.widget.EditText[@resource-id='com.atyati.ganaseva.mfi:id/et_Username']
	 */
	
	/*Passsword
	 * id = com.atyati.ganaseva.mfi:id/et_Password
	 * xpath = //android.widget.EditText[@resource-id='com.atyati.ganaseva.mfi:id/et_Password']
	 */
	
	/*Login button
	 * id = com.atyati.ganaseva.mfi:id/Btn_Login
	 * xpath = //android.widget.Button[@resource-id='com.atyati.ganaseva.mfi:id/Btn_Login']
	 */
	public Logging log;
	public WebDriverWait wait;
	protected By UsernameField = By.id("com.atyati.ganaseva.mfi:id/et_Username");
	protected By PasswordField = By.id("com.atyati.ganaseva.mfi:id/et_Password");
	protected By LoginButton = By.id("com.atyati.ganaseva.mfi:id/Btn_Login");
	
	public LoginPage() {
		super();
	}
	
	public boolean usernameField() {
		log = new Logging();
		Boolean res = false;
		try {
			WebElement Username = driver.findElement(UsernameField);
			res = Username.isDisplayed();
			if(res) {
				res = Username.isEnabled();
			}else {
				res = false;
			}
		}catch(Exception e) {
			log.Logerror("LoginPage.usernameField()"+"\n"+e);
		}
		return res;
	}
	
	public boolean passwordField() {
		Boolean res = false;
		log = new Logging();
		try {
			WebElement Password = driver.findElement(PasswordField);
			res = Password.isDisplayed();
			if(res) {
				res = Password.isEnabled();
			}else {
				res = false;
			}
		}catch(Exception e) {
			log.Logerror("LoginPage.passwordField()"+"\n"+e);
		}
		return res;
	}
	
	public boolean loginButton() {
		Boolean res = false;
		log = new Logging();
		try {
			WebElement Logginbutton = driver.findElement(LoginButton);
			res = Logginbutton.isDisplayed();
			if(res) {
				res = Logginbutton.isEnabled();
			}else {
				res = false;
			}
		}catch(Exception e) {
			log.Logerror("LoginPage.loginButton()"+"\n"+e);
		}
		return res;
	}
	
	public String Login(String Username, String Password) {
		String result = null;
		log = new Logging();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		LoginPage lp = new LoginPage();
		try {
			if(lp.usernameField()) {
				if(lp.passwordField()) {
					if(lp.loginButton()) {
						WebElement username = driver.findElement(UsernameField);
						WebElement password = driver.findElement(PasswordField);
						WebElement loginbutton = driver.findElement(LoginButton);
						username.sendKeys(Username);
						password.sendKeys(Password);
						loginbutton.click();
						//wait.until(Expectedconditions.)
						result = driver.getTitle();
					}else {
						result = "login button is not Enabled";
					}
				}else {
					result = "password field is not Enabled";
				}
			}else {
				result = "username field is not Enabled";
			}
		}catch(Exception e) {
			log.Logerror("LoginPage.Login()"+"\n"+e);
		}
		return result;
	}
}
