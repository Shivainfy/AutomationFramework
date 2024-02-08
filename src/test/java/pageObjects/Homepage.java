package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.base;

public class Homepage extends base{
	public WebDriver driver;
	
	public Homepage(WebDriver driver) throws IOException{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Flipkart']")
	private WebElement flipkartLogo;
	
	@FindBy(xpath="//a[@class='_1ch8e_'][2]")
	private WebElement MobileSection;
	
	public void VerifyImage() {
		boolean logo=flipkartLogo.isDisplayed();
		System.out.println("is flipkart logo displayed?"+logo);
	}
	
	public void ClickOnMobile() {
		base.ClickElement(MobileSection);
	}
	
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	private WebElement DDValue;
	public void selectDD() {
		try{
			js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,800)", "");
			Dropdown(DDValue, prop.getProperty("mobilePrice"));
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("No Such price present in the dropdown");
		}
	}
	
	@FindBy(xpath="//input[@class='_34uFYj']")
	private WebElement Mbrands;
	@FindBy(xpath="//div[@class='_24_Dny'][1]")
	private WebElement AppleCheckbox;
	public void SelectMobileBrands() throws InterruptedException {
		Mbrands.sendKeys(prop.getProperty("mobileBrand"));
		Thread.sleep(2000);
		base.ClickElement(AppleCheckbox);
	}

	@FindBy(xpath="//div[text()='4★ & above']")
	private WebElement FourStar;
	public void FourStarRating() throws InterruptedException {
		Thread.sleep(3000);
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		base.ClickElement(FourStar);
		Thread.sleep(4000);
	}
	
	@FindBy(xpath="//div[text()='1GB and Below']")
	private WebElement OneGBandBelow;
	public void SelectGB() throws InterruptedException {
		Thread.sleep(2000);
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		base.ClickElement(OneGBandBelow);
		Thread.sleep(2000);
	}
	
//	@FindBy(xpath="//div[text()='Apple iPhone 6s (Space Grey, 32 GB)']")
//	private WebElement AppleIphone6s;
	@FindBy(xpath="//span[text()='Apple iPhone 6s (Space Grey, 32 GB)']")
	private WebElement VerifyApple;
	public void ClickOnApplePhone() throws InterruptedException {
//		base.ClickElement(AppleIphone6s);
		Thread.sleep(2000);
		SwitchWindow();
		Thread.sleep(2000);
		System.out.println(VerifyApple.getText());
		driver.switchTo().window(parentWindow);
	}
}
