package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			//format={"pretty","json:path/to/json_repot.json"},
			features = "C:\\Users\\hp\\eclipse-workspace\\AutomationProject\\Features\\login.feature",
			glue="stepDefinition",
			dryRun=false,
			monochrome=true
			//tags="@smoke,@regression"
			)
			

public class Runner extends AbstractTestNGCucumberTests{
	
}
