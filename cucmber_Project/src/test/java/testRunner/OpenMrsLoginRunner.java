package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="//Users//suneethagudise//Desktop//Selenium_Tutorial//cucmber_Project//Features//OpenMRSTestScenarios/PatientMedicalRecord.feature" , 
				glue ="openMRS_StepDefinition" , dryRun =false)
public class OpenMrsLoginRunner {

}
