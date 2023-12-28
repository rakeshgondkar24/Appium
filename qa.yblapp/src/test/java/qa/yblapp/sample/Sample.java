package qa.yblapp.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Sample {
  @Test
  	public void Ganaseva() throws MalformedURLException
  	{
	  System.out.println("Getting into AppriumDriverLocalService");
  		AppiumDriverLocalService service = new AppiumServiceBuilder()
  				.withAppiumJS(new File("C:\\Users\\rakesh.g\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
  				.withIPAddress("127.0.0.1")
  				.usingPort(4732)
  				.withTimeout(Duration.ofMillis(50000))
  				.build();
  		service.start();
  		System.out.println("Services Started-----------");
  		
  		System.out.println("Getting into UiAutomator2Options");
  		UiAutomator2Options options = new UiAutomator2Options();
  		options.setDeviceName("samsung SM-T295");
  		System.out.println("Getting DeviceName");
  		options.setApp("E:\\Rakesh\\Automation\\New folder\\Automation\\YBL\\Practice\\apk\\yblmfi\\GanasevaMFI_YBL (2).apk");
  		System.out.println("Seeting the App");
  		//Android Driver
  		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
  		
  		//Allow Pop up message
  		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
  		
  		//Register credentials
  		driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_Registration_DeviceID")).sendKeys("0560300630");
  		driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_Registration_UserID")).sendKeys("970");
  		driver.findElement(By.id("com.atyati.ganaseva.mfi:id/bt_Registration_Submit")).click();
  		driver.findElement(By.id("android:id/button1")).click();
  		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement nextElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        nextElement.click();
  		
  		//Device registered msg
  		//Picture
  		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
  		//Location
  		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
  		//Media files
  		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
  		
  		
  		// Entering credentials
  		driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_Username")).sendKeys("Mehul");
  		driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_Password")).sendKeys("Mehul@1234");
  		driver.findElement(By.id("com.atyati.ganaseva.mfi:id/Btn_Login")).click();
  		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement nextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.atyati.ganaseva.mfi:id/android_custom_gridview_layout\"])[1]")));
        nextElement1.click();
        
        //selecting non 2-kyc
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/rb_general_input")).click();
        
        //Voter-ID credentials
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_secondary_doc_id_cust")).sendKeys("ABC00100110");
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_re_secondary_doc_id_cust")).sendKeys("ABC00100110");
        
        //Demand collected
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_DemandCollected")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"YES\"]")).click();
        
        //Name fields
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_firstname")).sendKeys("Rohan");
        driver.navigate().back();
        
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_middlename")).sendKeys("Kumar");
        
        
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_lastname")).sendKeys("Sharma");
        
        
        //Address fields
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_address")).sendKeys("1234, ABC Street");
        driver.navigate().back();
        
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_address2")).sendKeys("XYZ Layout");
        driver.navigate().back();
        
        
        //State
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_state")).click();    
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"KARNATAKA\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"KARNATAKA\"]")).click();  
        
        driver.navigate().back();
        
        //City
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_city")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"BENGALURU\"]")).click();
        driver.navigate().back();
        
        //Postal code
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_postal")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"560001\"]")).click();
        driver.navigate().back();
        
        //Village
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_village")).sendKeys("ABCD");
        driver.navigate().back();
        
        //Date of birth
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_dob")).sendKeys("04/03/2000");
        
        
        //Gender
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/rb_qde_male")).click();
      
        //Martial Status
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_martial_status")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"UNMARRIED\"]")).click();
        
        //scrolling
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SUBMIT\"))"));
        
        //Mobile number
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_mobile_no")).sendKeys("9934567890");
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_secondary_mobile_number")).sendKeys("9987654321");
        
        //Parents name
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_motherName")).sendKeys("Madhu Sharma");
        driver.navigate().back();
        
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_fatherName")).sendKeys("Nitesh Sharma");
        
        //BC number
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_barcode_id")).sendKeys("123456789000");
        driver.navigate().back();
        
        //Frequency
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_frequency")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"MONTHLY\"]")).click();
        
        //Loan Amount
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_qde_loan_amount")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"32000\"]")).click();
        
        //Loan Tenure
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/et_loan_tenure")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.atyati.ganaseva.mfi:id/customtextview\" and @text=\"30\"]")).click();
        
        //Submit Button
        driver.findElement(By.id("com.atyati.ganaseva.mfi:id/btn_check_eligibility")).click();
        
        //Submit message
        String txt = driver.findElement(By.id("android:id/message")).getText();
        System.out.println(txt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Clicking ok button
        driver.findElement(By.id("android:id/button1")).click();
  		
        
      
        driver.quit();
  		service.stop();
 
 
 
  }
}
