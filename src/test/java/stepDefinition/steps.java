package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import baseClass.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Homepage;

public class steps extends base{
//	public static WebDriver driver=null;
//	public static Properties prop;
//	public FileInputStream fl;
	
	public static Homepage homepage;

	public steps() throws IOException {
		super();//checking
	}
	
	@Before
	public void BrowserInitialize() {
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	
	@Given("user launch chrome browser")
	public void user_launch_chromebrowser() throws IOException {
//		base.BrowserInitialize();
//		homepage=new Homepage(driver);
		System.out.println("test");
	}

	@When("user opens url flipkart url")
	public void user_opens_url() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		System.out.println("flipkart url opened");
	}
	
	@Then("Verify flipkart logo")
	public void verify_flipkart_logo() {
	
	}

	@And("Click on login menu")
	public void click_on_login_menu() {

	}
}
