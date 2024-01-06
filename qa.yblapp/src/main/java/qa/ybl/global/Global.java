package qa.ybl.global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import qa.yblapp.logging.Logging;

public class Global {
	public Logging log;
	public WebDriverWait wait;
	
	public Object[][] getDate(String filepath, String sheetname) {
		log = new Logging();
		Object[][] data=null;
		try {
			File file = new File(filepath);
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetname);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				int cellNum = sheet.getRow(0).getLastCellNum()-1;
				for(int j=0;j<cellNum;j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			wb.close();
			fs.close();
		} catch (Exception e) {
			log.Logerror("Global.getDate()"+"\n"+e);
		}
		return data;
	}

	/*
	 * This method takes the screenshot
	 * filepath: path the file where snapshot to be placed
	 * filename: name of the file which is assigned to screenshot 
	 */
	public void takeScreenShot(AndroidDriver driver,String filepath, String filename) {
		log = new Logging();
		try {
			String fileName = filepath+"\\"+"TS_"+filename+".png";
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(fileName),true);
		} catch (Exception e) {
			log.Logerror("Global.takeScreenShot()"+"\n"+e);
		}
	}
	
	/*
	 * This method selects the given value from the drop down menu
	 * 
	 */
	
	public void SelectVal(AndroidDriver driver,WebElement element,String Val) {
		log = new Logging();
		log.Loginfo("Getting into Select Class");
		log.Loginfo("Value is Select Class is:"+Val);
		wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			log.Loginfo("Clicked the Element");
			String val = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.atyati.ganaseva.mfi:id/customtextview' and @text='"+Val+"']")).getText();
			log.Loginfo("Value inside the Select method is: "+val);
//			Select sc = new Select(element);
//			log.Loginfo("Trying to select the drop down value");
//			String val = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.atyati.ganaseva.mfi:id/customtextview' and @text="+Val+"]")).getText();
//			log.Loginfo("Value inside the Select method is: "+val);
//			sc.selectByValue(val);
			log.Loginfo("Trying to select the drop down value");
			//driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.atyati.ganaseva.mfi:id/customtextview' and @text='"+Val+"']")).click();
			try {
				driver.findElement(AppiumBy.androidUIAutomator("new UIScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new Uiselector().textcontains("+Val+")).instance(0))")).click();
				log.Loginfo("Drop down value is selected");
			} catch (Exception e) {
				log.Logerror("Global.SelectVal().ScrollingAndSelectingTheValue:"+"\n"+e);
			}
		}catch(Exception e) {
			log.Logerror("Global.SelectVal():"+"\n"+e);
		}
	}
}
