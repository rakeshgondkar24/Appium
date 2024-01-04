package qa.yblapp.sample;

import java.net.MalformedURLException;

import org.testng.annotations.*;

import qa.ybl.pages.LoginPage;
import qa.yblapp.base.Base;
import qa.yblapp.logging.Logging;

public class TestLogin extends Base{
	
	public LoginPage login;
	public Logging log;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		InitializationForLogin();
	}
	
	@Test
	public void homePage() {
		String result;
		login = new LoginPage();
		result = login.Login("RakeshGondakar", "atyati@123");
	}
}
