package qa.yblapp.sample;

import java.net.MalformedURLException;

import org.testng.annotations.*;

import qa.ybl.global.Global;
import qa.ybl.pages.LoginPage;
import qa.ybl.pages.QdePage;
import qa.yblapp.base.Base;
import qa.yblapp.logging.Logging;

public class TestLogin extends Base{
	
	public LoginPage login;
	public Logging log;
	public QdePage qde;
	public Global gl;
	private String DataFilePath = prop.getProperty("datapath");
	private String Sheetname = prop.getProperty("QdeSheetname");
	
	@DataProvider
	public Object[][] getQdeData(){
		gl = new Global();
		Object[][] data = null;
		data = gl.getDate(DataFilePath, Sheetname);
		
		return data;
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		InitializationForLogin();
	}
	
	@Test
	public void homePage() {
		String result;
		login = new LoginPage();
		result = login.Login("RakeshGondakar", "Atyati@123");
	}
	
	@Test(dataProvider = "getQdeData")
	public void QDE(String TSID,String Description,String TestFlag,String Username,String Password,String Ekyc,String VoterID,
			String ReEnterVoterID,String DemandCollected,String FirstName,
			String MiddleName,String LastName,String Address1,String Address2,String State,String City,String PostalCode,
			String Village,String DateOfBirth,String Gender,String MaritalStatus,String MobileNo,String SecondaryMobileNo,
			String MotherName,String FatherName,String BCNo,String Frequency,String AppliedLoanAmount,String LoanTenure,
			String ExpectedResult,String ActualResult) {
		String Actual = null;
		qde = new QdePage();
		qde.getIntoQde(Username, Password);
		Actual = qde.submitQDE(Ekyc, VoterID, ReEnterVoterID, DemandCollected,FirstName,MiddleName,LastName,Address1,Address2,
				State,City,PostalCode,Village,DateOfBirth,Gender,MaritalStatus,MobileNo,SecondaryMobileNo,MotherName,FatherName,BCNo,
				Frequency,AppliedLoanAmount,LoanTenure);
		log.Loginfo("Expected Result is: "+ExpectedResult);
		log.Loginfo("Actual Result is: "+ActualResult);
	}
}
