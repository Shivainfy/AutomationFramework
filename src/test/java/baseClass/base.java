package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
public class base {
	public static WebDriver driver=null;
	public static Properties prop;
	public FileInputStream fl;
	
	//@Before
//	public void BrowserInitialize() {
//		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
//			driver = new FirefoxDriver();
//		}
//		driver.get(prop.getProperty("url"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//	}
	
	//@After
//	public void tearDown() {
//		driver.close();
//	}
	public base() throws IOException {
		prop = new Properties();
		fl = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\config.properties");
		prop.load(fl);
	}

}
