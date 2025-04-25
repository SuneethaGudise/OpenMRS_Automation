package openMRS_StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindpatientRecord_page;
import pages.LoginOpenMrspage;
import pages.PatientMedicalRecord_page;

public class StepDefinitions {
	static WebDriver driver;
	
static LoginOpenMrspage loginPage;
static FindpatientRecord_page findPatientPage;
static PatientMedicalRecord_page patientMedicalRecordPage;
	
	public StepDefinitions() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		loginPage = new LoginOpenMrspage(driver);
		findPatientPage = new FindpatientRecord_page(driver);
		patientMedicalRecordPage = new PatientMedicalRecord_page(driver);
	}
	
//	@Given("Log on to OpenMRS {string} and {string} and {string}")
//	public void Logon(String uname, String pwd, String location) {
//		openLoginPage();
//		doLogon(uname, pwd, location);
//		clickLoginButton();
//	}
//	
//    @When("Select Patient Record option {string}")
//    public void SelectPatient(String name) {
//    	
//    }
//    
//    @And("Select End Visit Action")
//    public void SelectEndVisit(String name) {
//    	
//    }
//    When click on No stays on same page
//    When click on Yes stays on same page
    
	
	@Given("User is on OpenMRS login page")
	public void openLoginPage() {
		loginPage.openLoginPage();
	}
	
	//@Then("User enter {string} and {string} and {string} and successfully login into app page")
	@When("User enters logon details {string} and {string} and {string}")
	public void doLogon(String uname, String pwd,String session) throws InterruptedException {
		loginPage.enterLoginCredentials(uname,pwd,session);
//		loginPage.clickloginButton();
	}
	@And ("User clicks on login button")
	public void clickLoginButton() throws InterruptedException {
		loginPage.clickloginButton();
	}
	
	@Then("User should be redirected to the OpenMRS home page with {string} and {string} in headers")
	public void verifyHeaderinfo(String username, String location) {
		loginPage.logonHeaderVerification(username, location);
	}
	
	@Then("User verify invalid login error text")
	public void loginFaliedText() {
		loginPage.invalidloginErrorText();
	}
	
	@When("User clicks on Find Patient Record option")
	public void clicksFindPatientRecordoption() {
		findPatientPage.clicksFindPatientRecordoption();
	}
	
	@Then("User is directed to Find Patient record page")
	public void findPatientRecordpage() {
		findPatientPage.findPatientRecordpageTitleValidation();
	}
	
	@And("User verifies the icon text and header text macthes with selected option")
	public void iconHeaderText() {
		findPatientPage.iconHeaderTextValidation();
	}
	
	@And("User veriifes search box dispalyed under the header")
	public void searchboxVerification() {
		findPatientPage.searchboxVerification();
	}
	
	@Then("User verifies the patient record table is displayed.")
	public void ispatientTableDispalyed() {
		findPatientPage.ispatientTableDispalyed();
	   
	}

	@And("User veriifes all the column values are clickable")
	public void columnvaluesIsclickable() {
		findPatientPage.columnvaluesIsclickable();
	}

	@When("User clicks on any of the column value.")
	public void clickColumnValues() throws InterruptedException {
		findPatientPage.clickColumnValues();
	}

	@Then("User lands on Patient record page")
	public void patientRecordpage() {
		findPatientPage.patientRecordpage();
	}

	
//	@Then("User Starts Vist and Add note If General Action option is present")
//	public void GeneralActions() throws InterruptedException {
//		patientMedicalRecordPage.startVisitAndAddNotes();
//	}
	
	@And("User Starts and End Vist Action")
	public void currentVisitActions() throws InterruptedException {
		patientMedicalRecordPage.startAndendCurrentVisitActions();
	}
	
//	@And("User switch to End Visit Modal and clicks Cancel and stays on same page.")
//	public void cancelEndvisit() throws InterruptedException {
//		patientMedicalRecordPage.cancelEndVisit();;
//	}
//
//	@Then("User again clicks on end visit and clicks confirm and check Recent Visit value.")
//	public void confirmEndVisit() throws InterruptedException {
//		patientMedicalRecordPage.confirmEndVisit();
//	}
//
//	@And("User switch to Start visit Modal and clicks Cancel and stays on same page..")
//	public void startVisitGeneralAction() throws InterruptedException {
//		patientMedicalRecordPage.cancelStartVisit();
//	}
//
//	@Then("User again clicks on Start visit and clicks confirm and check Recent Visit value. .")
//	public void confirmsStartVisit() throws InterruptedException {
//		patientMedicalRecordPage.acceptStartVisit();
//	}

//	@And("User validates the patient visit page bread crumb links has Visit")
//	public void verifiesPatientisonVisitpage() {
//		patientMedicalRecordPage.verifiesPatientisonVisitpage();
//	}
//
//	@Then("User clicks on visit note and user is directed to Patient Visit note page.")
//	public void clicksOnVisitNote() {
//		patientMedicalRecordPage.clicksOnVisitNote();
//	}
//
//	@Then("User Add presumed or confirmed diagnosis message and verifies diagnosis section")
//	public void addPresumedorConfirmeddiagnosismessage() throws InterruptedException {
//		patientMedicalRecordPage.addPresumedorConfirmeddiagnosismessage();
//	}
//
//	@Then("User clicks on Save button is directed back to patient visit page")
//	public void clickSaveandNavigatePatientVisitPage() {
//		patientMedicalRecordPage.clickSaveandNavigatePatientVisitPage();
//	}

	@After
	public void cleanup() {
		driver.close();
		driver.quit();
	}

}
