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
public class base {
	public static WebDriver driver=null;
	public static Properties prop;
	public FileInputStream fl;
	public JavascriptExecutor js;
	public String parentWindow;
	public String Window;
	
	@FindBy(xpath="//div[text()='Apple iPhone 6s (Space Grey, 32 GB)']")
	private WebElement AppleIphone6s;
	
	public base() throws IOException {
		prop = new Properties();
		fl = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\config.properties");
		prop.load(fl);
	}
	
	public static void ClickElement(WebElement element) {
		element.click();
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
		for(String Window:Windows) {
			System.out.println(Window);
			if(!Window.equals(parentWindow)) {
				driver.switchTo().window(Window);
			}
		}
	}

}
