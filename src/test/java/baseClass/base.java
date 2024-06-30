package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
public class base {
	public static WebDriver driver=null;
	public static Properties prop;
	public static FileInputStream fl;
	public JavascriptExecutor js;
	public String parentWindow;
	public String Child;
	public static String ProjectPath = System.getProperty("user.dir");
	
	
	@FindBy(xpath="//div[text()='Apple iPhone 6s (Space Grey, 32 GB)']")
	public WebElement AppleIphone6s;
	@FindBy(xpath="//a[@class='_1ch8e_'][2]")
	public WebElement MobileSection;
	
	public base() throws IOException {
		prop = new Properties();
		fl = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\config.properties");
		prop.load(fl);
	}
	
//	public static void configMethod() throws IOException {
//	
//		try {
//			prop = new Properties();
//			fl = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\config.properties");
//			prop.load(fl);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void ClickElement(WebElement element) throws InterruptedException {
		element.click();
		Thread.sleep(5000);
		driver.switchTo().newWindow(null);
	}
	
	public static void Dropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public void SwitchWindow() throws InterruptedException {
		parentWindow=driver.getWindowHandle();
		System.out.println("Parent windowID: "+parentWindow);
		base.ClickElement(AppleIphone6s);
		Thread.sleep(6000);
		Set<String> Windows=driver.getWindowHandles();
		for(String Child:Windows) {
			System.out.println(Child);
			if(!Child.equals(parentWindow)) {
				driver.switchTo().window(Child);
			}
		}
	}
	public static ExtentTest test;
	public static String reportFilePath;
	public static ExtentReports reports;
	public static ExtentTest ReportFile(String testCaseName) {
		reportFilePath=ProjectPath+"/TestReport/AutomationReport.html";
		reports = new ExtentReports(reportFilePath,true);
		test=reports.startTest(testCaseName);
		return test;
	}
	public static void EndReport() {
		reports.endTest(test);
		reports.flush();
	}
}
