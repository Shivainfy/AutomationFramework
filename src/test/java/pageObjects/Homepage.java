package pageObjects;

import java.io.IOException;

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
	private WebElement plifkartLogo;

}
