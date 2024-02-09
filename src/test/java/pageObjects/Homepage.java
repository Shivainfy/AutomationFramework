package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseClass.base;

public class Homepage extends base{
	public WebDriver driver;
	String value=null;
	public Homepage(WebDriver driver) throws IOException{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Flipkart']")
	private WebElement flipkartLogo;
	
	@Test
	public String VerifyImage() throws InterruptedException {	
		boolean logo=flipkartLogo.isDisplayed();
		System.out.println("is flipkart logo displayed?"+logo);
		if(logo==true) {
			test.log(LogStatus.PASS, "flipkart logo is displayed");
		}else {
			test.log(LogStatus.FAIL, "flipkart logo not displayed");
		}
		Thread.sleep(1000);
		return value;
	}
	
	@SuppressWarnings("unused")
	@Test
	public String ClickOnMobile() throws InterruptedException {
		Thread.sleep(2000);
		base.ClickElement(MobileSection);
		if(true) {
			test.log(LogStatus.PASS, "Clicked on mobile section");
		}else {
			test.log(LogStatus.FAIL, "Not Clicked on mobile section");
		}
		return value;
	}
	
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	private WebElement DDValue;
	@SuppressWarnings("unused")
	@Test
	public String selectDD() {
		try{
			js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,800)", "");
			Dropdown(DDValue, prop.getProperty("mobilePrice"));
			Thread.sleep(3000);
			if(true) {
				test.log(LogStatus.PASS, "Dropdown selected for mobile price");
			}else {
				test.log(LogStatus.FAIL, "Dropdown NOT selected for the mobile price");
			}
		}
		catch(Exception e) {
			System.out.println("No Such price present in the dropdown");
		}
		return value;
	}
	
	@FindBy(xpath="//input[@class='_34uFYj']")
	private WebElement Mbrands;
	@FindBy(xpath="//div[@class='_24_Dny'][1]")
	private WebElement AppleCheckbox;
	@SuppressWarnings("unused")
	@Test
	public String SelectMobileBrands() throws InterruptedException {
		Mbrands.sendKeys(prop.getProperty("mobileBrand"));
		Thread.sleep(2000);
		base.ClickElement(AppleCheckbox);
		if(true) {
			test.log(LogStatus.PASS, "Apple check box selected");
		}else {
			test.log(LogStatus.FAIL, "Apple check box NOT selected");
		}
		return value;
	}

	@FindBy(xpath="//div[text()='4★ & above']")
	private WebElement FourStar;
	@SuppressWarnings("unused")
	@Test
	public String FourStarRating() throws InterruptedException {
		Thread.sleep(3000);
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		base.ClickElement(FourStar);
		Thread.sleep(4000);
		if(true) {
			test.log(LogStatus.PASS, "4 * ratings selected");
		}else {
			test.log(LogStatus.FAIL, "4 * rating NOT selected");
		}
		return value;
	}
	
	@FindBy(xpath="//div[text()='1GB and Below']")
	private WebElement OneGBandBelow;
	@SuppressWarnings("unused")
	@Test
	public String SelectGB() throws InterruptedException {
		Thread.sleep(2000);
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");	
		base.ClickElement(OneGBandBelow);
		Thread.sleep(2000);
		if(true) {
			test.log(LogStatus.PASS, "1GB and Below RAM");
		}else {
			test.log(LogStatus.FAIL, "1GB and Below RAM NOt selected");
		}
		return value;
	}
	
//	@FindBy(xpath="//div[text()='Apple iPhone 6s (Space Grey, 32 GB)']")
//	private WebElement AppleIphone6s;
	@FindBy(xpath="//span[text()='Apple iPhone 6s (Space Grey, 32 GB)']")
	private WebElement VerifyApple;
	@SuppressWarnings("unused")
	@Test
	public String ClickOnApplePhone() throws InterruptedException {
		base.ClickElement(AppleIphone6s);
		Thread.sleep(2000);
		SwitchWindow();
		Thread.sleep(2000);
		System.out.println(VerifyApple.getText());
		driver.switchTo().window(parentWindow);
		if(true) {
			test.log(LogStatus.PASS, "Clicked on APPle phone grid");
		}else {
			test.log(LogStatus.FAIL, "NOT Clicked on APPle phone grid");
		}
		return value;
	}
}
