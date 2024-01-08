package qa.yblapp.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import qa.yblapp.base.*;
public class Logging extends Base{
	
	static org.apache.log4j.Logger log;
//	public static String name = prop.getProperty("testername");
	
	public Logging() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("E:\\Rakesh\\Automation\\New folder\\Automation\\YBL\\Practice\\20102\\qa.yblapp\\src\\log4j.properties"));
			PropertyConfigurator.configure(prop);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Loginfo(String info) {
		log = Logger.getLogger("Tester");
		log.debug(info);
	}
	
	public void Logerror(String error) {
		Logger log = Logger.getLogger("Tester");
		log.error(error);
	}
}
