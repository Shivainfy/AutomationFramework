package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.loginPage;

public class steps {
	public WebDriver drive;
	
	//loginPage login = new loginPage();
	
	
	@Given("user launch chromebrowser")
	public void user_launch_chromebrowser() {

	}

	@When("user opens url {string}")
	public void user_opens_url(String string) {

	}
	
}
