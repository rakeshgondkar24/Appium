package qa.ybl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import qa.yblapp.base.Base;

public class CbReportPage extends Base {
	
	@AndroidFindBy(id = "com.atyati.ganaseva.mfi:id/btn_proceed_to_dde")
	private WebElement proceedToHha;
	
	@AndroidFindBy(accessibility = "Household Assessement Form")
	private WebElement houseHoldAssessmentForm;
	
	@AndroidFindBy(accessibility = "Assessment Summary")
	private WebElement assessmentSummary;

	public CbReportPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
