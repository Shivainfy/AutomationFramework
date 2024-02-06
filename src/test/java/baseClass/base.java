package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;

public class base {
	public static WebDriver driver=null;
	public static Properties prop;
	public FileInputStream fl;
	
	
	//@Before
	public static void BrowserInitialize() {
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
	}
	
	public base() throws IOException {
		prop = new Properties();
		fl = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\config.properties");
		prop.load(fl);
	}

}
