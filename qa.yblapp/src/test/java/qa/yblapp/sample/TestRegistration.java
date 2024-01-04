package qa.yblapp.sample;

import java.net.MalformedURLException;

import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import qa.ybl.global.Global;
import qa.ybl.pages.RegistrationPage;
import qa.yblapp.base.Base;
import qa.yblapp.logging.Logging;

public class TestRegistration extends Base {
	public RegistrationPage reg;
	public Logging log;
	public AndroidDriver driver;
	public Global gl;
	protected String Filepath = prop.getProperty("datapath");
	protected String Sheetname = prop.getProperty("regSheetname");
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		//driver = Initialization();
		InitializationForRegisteration();
	}
	
	@DataProvider
	public Object[][] getDeviceData(){
		gl = new Global();
		log = new Logging();
		Object[][] data = gl.getDate(Filepath, Sheetname);
//		log.Loginfo("Data is: "+"\n"+Arrays.deepToString(data));
		return data;
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
	
	@Test(dataProvider="getDeviceData")
	public void registrationTest(String TSID,String Description,String TestFlag,String DeviceId,String UserId,
			String ExpectedResult, String Result) {
		String result=null;
		int rowNum = Integer.valueOf(TSID);
		log = new Logging();
		log.Loginfo("Testing the RegistartionPage is Started");
		try {
			reg = new RegistrationPage();
			result = reg.registration(TestFlag,DeviceId, UserId);
			String expected = "Device Registered";
			log.Loginfo("Result of the Registration"+"\n"+result);
			if(result.equals(expected)) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			log.Logerror("TestLaunch.registrationTest()"+"\n"+e);
		}
	}

}
