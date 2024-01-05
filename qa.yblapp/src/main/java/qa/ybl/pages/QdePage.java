package qa.ybl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import qa.ybl.global.Global;
import qa.yblapp.base.Base;
import qa.yblapp.logging.Logging;

public class QdePage extends Base{
	public Logging log;
	public LoginPage login;
	public HomePage home;
	public Global gl;
	
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/rb_ekyc_input")
	private WebElement eKyc;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/rb_general_input")
	private WebElement nonEkyc;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_secondary_doc_id_cust")
	private WebElement voterId;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_re_secondary_doc_id_cust")
	private WebElement reEnterVoterId;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_DemandCollected")
	private WebElement demandCollected;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_firstname")
	private WebElement firstName;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_middlename")
	private WebElement middleName;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_lastname")
	private WebElement lastName;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_address")
	private WebElement address1;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_address2")
	private WebElement address2;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_state")
	private WebElement state;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_city")
	private WebElement city;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_village")
	private WebElement village;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_dob")
	private WebElement dateOfBirth;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/rb_qde_male")
	private WebElement male;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/rb_qde_female")
	private WebElement feMale;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/rb_qde_others")
	private WebElement others;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_martial_status")
	private WebElement maritalStatus;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_mobile_no")
	private WebElement mobileNo;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_secondary_mobile_number")
	private WebElement secondaryMobileNo;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_motherName")
	private WebElement motherName;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_fatherName")
	private WebElement fatherName;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_barcode_id")
	private WebElement bcNo;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_frequency")
	private WebElement frequency;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_qde_loan_amount")
	private WebElement appliedLoanAmount;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_loan_tenure")
	private WebElement loanTenure;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/et_no_of_installment")
	private WebElement noOfInstallment;
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/btn_check_eligibility")
	private WebElement submit;
	
	public QdePage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void getIntoQde(String Username,String Password) {
		log = new Logging();
		login = new LoginPage();
		home = new HomePage();
		try {
			login.Login(Username, Password);
			home.clickQuickDataEntry();
		}catch(Exception e) {
			log.Logerror("QdePage.getIntoQde()"+"\n"+e);
		}
	}
	
	private String Result(String Val) {
		String result = null;
		if(Val.equals(null)){
			result = "";
		}else {
			result = Val;
		}
		return result;
	}

	public void submitQDE(String KycType,String VoterID, String ReEnterVoterID,String DemandCollected) {
		log = new Logging();
		QdePage qd = new QdePage();
		gl = new Global();
//		MiddleName = qd.Result(MiddleName);
//		LastName = qd.Result(LastName);
//		Address2 = qd.Result(Address2);
//		SecondaryMobileNo = qd.Result(SecondaryMobileNo);
//		FatherName = qd.Result(FatherName);
//		BCNo = qd.Result(BCNo);
		KycType = KycType.toLowerCase();
		//DemandCollected = DemandCollected.toUpperCase();
		try {
			if(KycType.equals("ekyc")) {
				eKyc.click();
				log.Loginfo("ekyc is clicked");
			}else if(KycType.equals("nonekyc")) {
				nonEkyc.click();
				log.Loginfo("Nonekyc is clicked");
			}else {
				nonEkyc.click();
				log.Loginfo("Nonekyc is clicked as nothing is selected");
			}
			voterId.sendKeys(VoterID);
			reEnterVoterId.sendKeys(ReEnterVoterID);
			gl.SelectVal(driver, demandCollected, DemandCollected);
			
		}catch(Exception e) {
			log.Logerror("QdePage.submitQDE()"+"\n"+e);
		}
	}
	/*
	 * ,String FirstName,
			String MiddleName,String LastName,String Address1,String Address2,String State,String City,String PostalCode,
			String Village,String DateOfBirth,String Gender,String MaritalStatus,String MobileNo,String SecondaryMobileNo,
			String MotherName,String FatherName,String BCNo,String Frequency,String AppliedLoanAmount,String LoanTenure,String NoofInstallment
	 */
}