package qa.yblapp.sample;

import java.net.MalformedURLException;

import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import qa.ybl.pages.RegistrationPage;
import qa.yblapp.base.Base;
import qa.yblapp.logging.Logging;

public class TestRegistration extends Base {
	public RegistrationPage reg;
	public Logging log;
	public AndroidDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		//driver = Initialization();
		Initialization();
	}
	
	@Test
	public void deviceIdField() {
		log = new Logging();
		reg = new RegistrationPage();
		boolean val = reg.deviceIDField();
		log.Loginfo("TestLaunch.deviceIdField result is: "+val);
		if(val) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void userIdField() {
		log = new Logging();
		reg = new RegistrationPage();
		boolean val = reg.userIDField();
		log.Loginfo("TestLaunch.userIdField result is: "+val);
		if(val) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void regButton() {
		log = new Logging();
		reg = new RegistrationPage();
		boolean val = reg.registerButton();
		log.Loginfo("TestLaunch.regButton result is: "+val);
		if(val) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void registrationTest() {
		String result=null;
		log = new Logging();
		log.Loginfo("Testing the RegistartionPage is Started");
		try {
			reg = new RegistrationPage();
			result = reg.registration("0750300635", "970");
			log.Loginfo("Result of the Registrta");
		}catch(Exception e) {
			log.Logerror("TestLaunch.registrationTest()"+"\n"+e);
		}
	}

}
