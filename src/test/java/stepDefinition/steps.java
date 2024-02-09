package stepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
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
	
	public static Homepage homepage;
	public steps() throws IOException {
		super();//checking
	}
	String value=null;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	@After
	public void tearDown() {
		EndReport();
	}
	
	@Given("user launch chrome browser")
	public void user_launch_chromebrowser() throws IOException {
		homepage = new Homepage(driver);
	}

	@When("user opens url flipkart url")
	public void user_opens_url() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Then("Verify flipkart logo")
	public void verify_flipkart_logo() throws InterruptedException {
		test=ReportFile("Flipkart Homepage");
//		String value=null;
		Thread.sleep(2000);
		value=homepage.VerifyImage();
		
	}

	@And("Click on mobile menu section")
	public void click_on_mobile_menuSection() throws InterruptedException {
//		base.ClickElement(MobileSection);
		Thread.sleep(2000);
		value=homepage.ClickOnMobile();
	}
	
	@Then("Scroll down to price bar and select the price")
	public void scroll_down_to_price_bar() {
		value=homepage.selectDD();
	}

	
	@And("Search mobile brands")
	public void MobileBrands() throws InterruptedException {
		value=homepage.SelectMobileBrands();
	}
	
	@And("Choose customer rating four")
	public void SelectRating() throws InterruptedException {
		value=homepage.FourStarRating();
	}
	
	@And("Select RAM size min 1GB")
	public void SelectRAM() throws InterruptedException {
		value=homepage.SelectGB();
	}
	
	@And("click on Apple mobile for booking")
	public void AppleMobile() throws InterruptedException {
		value=homepage.ClickOnApplePhone();
		
	}
}
