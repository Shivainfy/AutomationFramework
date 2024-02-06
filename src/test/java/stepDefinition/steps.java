package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import baseClass.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.Homepage;

public class steps extends base{
	
	public static Homepage lp;
	public steps() throws IOException {
		super();
	}
	
	@Given("user launch chromebrowser")
	public void user_launch_chromebrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		lp=new Homepage(driver);
	}

	@When("user opens url flipkart url")
	public void user_opens_url() {
		driver.get(prop.getProperty("url"));
//		driver.get("https://www.flipkart.com/");
//		base.BrowserInitialize();
		driver.manage().window().maximize();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
}
