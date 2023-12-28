package qa.ybl.global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.appium.java_client.android.AndroidDriver;
import qa.yblapp.logging.Logging;

public class Global {
	public Logging log;
	
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

	public void takeScreenShot(AndroidDriver driver,String filepath, String filename) {
		log = new Logging();
		try {
			String snap = filepath+"\\"+"TS_"+filename+".png";
			TakesScreenshot sc = (TakesScreenshot) driver;
			File file = sc.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(snap));
		} catch (Exception e) {
			log.Logerror("Global.takeScreenShot()"+"\n"+e);
		}
	}
}
