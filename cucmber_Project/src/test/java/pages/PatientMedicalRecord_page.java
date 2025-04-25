package pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import junit.framework.Assert;

public class PatientMedicalRecord_page {
	
	public static WebDriver driver;
	static WebElement currentvisitActionbox;
	static WebElement generalActionbox;
	//public static  WebElement currentvisitActionbox;
	//public static WebElement generalActionbox ;
	public static String currentActions = "Current Visit Actions";
	public static String generalActions = "General Actions";
	public static String Actionbox ;
	public static Alert al;
	public static String currentURL ="https://o2.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId=db83a056-e8d7-4971-aeca-047f763ca7b0";
	public static WebElement endvisit;
	public static WebElement startvisit;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
	public PatientMedicalRecord_page(WebDriver d) {
		driver = d;
	}

//	public static WebElement currentvisitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3[contains(text(),'Current Visit Actions')]"));
//	public static WebElement generalActionbox = driver.findElement(By.xpath("//div[@class='action-section']//ul/h3[contains(text(),'General Actions')]"));

	public void startAndendCurrentVisitActions() throws InterruptedException {
		System.out.println("============Verify Current Actions===============");
		WebElement visitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3"));
		 if(visitActionbox.getText().contains(currentActions)) {
			 System.out.println("Current Visit Option is available : " +visitActionbox.getText());
			 endvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'referenceapplication.realTime.endVisit')]"));
			 endvisit.click();
			 wait.until(ExpectedConditions.elementToBeClickable(endvisit));
			 System.out.println("End Visit is clicked");
			 cancelEndVisit();
			 confirmEndVisit(); 
		 }	
		 else {
			 System.out.println(visitActionbox.getText().contains(generalActions));
			 System.out.println("Genral Action Option is available : " +visitActionbox.getText());
			 startvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'org.openmrs.module.coreapps.createVisit')]"));
		     startvisit.click();
		     wait.until(ExpectedConditions.elementToBeClickable(startvisit));
			 System.out.println("Start Visit is clicked");
			 cancelStartVisit();
			 acceptStartVisit();
			 verifiesPatientisonVisitpage();
			 clicksOnVisitNote();
			 addPresumedorConfirmeddiagnosismessage();
			 clickSaveandNavigatePatientVisitPage();
			 System.out.println("Now Current Visit is available : " + visitActionbox.getText().contains(currentActions));
			 System.out.println("Current Visit Option is available : " +visitActionbox.getText());
			 endvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'referenceapplication.realTime.endVisit')]"));
			 endvisit.click();
			 wait.until(ExpectedConditions.elementToBeClickable(endvisit));
			 System.out.println("End Visit is clicked");
			 cancelEndVisit();
			 confirmEndVisit(); 
		 }
	}
	
	public void startVisitAndAddNotes() throws InterruptedException {
		System.out.println("============Verify General Actions===============");
		WebElement visitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3"));
		if(visitActionbox.getText().contains(generalActions)) {
		System.out.println(visitActionbox.getText().contains(generalActions));
		 System.out.println("Genral Action Option is available : " +visitActionbox.getText());
		 startvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'org.openmrs.module.coreapps.createVisit')]"));
	     startvisit.click();
	     wait.until(ExpectedConditions.elementToBeClickable(startvisit));
		 System.out.println("Start Visit is clicked");
		 cancelStartVisit();
		 acceptStartVisit();
		 verifiesPatientisonVisitpage();
		 clicksOnVisitNote();
		 addPresumedorConfirmeddiagnosismessage();
		 clickSaveandNavigatePatientVisitPage();
		}
		else {
			//WebElement visitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3"));
			 System.out.println("Current Visit Option is available : " +visitActionbox.getText());
			 endvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'referenceapplication.realTime.endVisit')]"));
			 endvisit.click();
			 wait.until(ExpectedConditions.elementToBeClickable(endvisit));
			 System.out.println("End Visit is clicked");
			 cancelEndVisit();
			 confirmEndVisit(); 
		}
	}

	public void cancelEndVisit() throws InterruptedException {
		System.out.println("========End Visit Cancel Confirmation===========");
		Thread.sleep(5000);
		//Current Visist Actions /End Visit:
		WebElement endvisitdialogueModal = driver.findElement(By.xpath("//div[@id='end-visit-dialog']//div[@class='dialog-content']"));
		String endDiaglogueboxText = endvisitdialogueModal.getText();
		WebElement endvisitModalText = driver.findElement(By.xpath("//div[@id='end-visit-dialog']//span"));
		String  endvisitModaltext = endvisitModalText.getText();
		WebElement endcancelbutton = driver.findElement(By.xpath("//div[@id='end-visit-dialog']//button[contains(text(),'No')]"));
		if(endvisitdialogueModal.isDisplayed()) {
			 Thread.sleep(2000);
			endcancelbutton.click();
			System.out.println("End Visit No/Cancel button is clicked" +endcancelbutton.getText());
//			 System.out.println(" Current Visit Actions is still displayed : "  +endcancelbutton.getText());
			 Thread.sleep(2000);
			 WebElement visitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3"));
			 System.out.println(" Current Visit Actions is still displayed : " +visitActionbox.getText().contains(currentActions));
			
		}
		else {
			System.out.println(" Current Visist cancel is failed");
		}
	}

	public void confirmEndVisit() throws InterruptedException {
		System.out.println("===========End Visit Accepted Confirmation==============");
		Thread.sleep(5000);
		 currentvisitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3[contains(text(),'Current Visit Actions')]"));
		 
		 Actionbox=  currentvisitActionbox.getText();
		 endvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'referenceapplication.realTime.endVisit')]"));	 
		 //End Visit 
		 WebElement endvisitdialogueModal = driver.findElement(By.xpath("//div[@id='end-visit-dialog']//div[@class='dialog-content']"));
			String endDiaglogueboxText = endvisitdialogueModal.getText();
			WebElement endvisitModalText = driver.findElement(By.xpath("//div[@id='end-visit-dialog']//span"));
			String  endvisitModaltext = endvisitModalText.getText();
			WebElement Yesbutton = driver.findElement(By.xpath("//div[@id='end-visit-dialog']//button[contains(text(),'Yes')]"));
			 currentvisitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3[contains(text(),'Current Visit Actions')]"));
				 if(currentvisitActionbox.isDisplayed()) { 
					 endvisit.click();
					 System.out.println("End Visit is clicked again to click the Yes button");
					 wait.until(ExpectedConditions.elementToBeClickable(endvisit));
					 if(endvisitdialogueModal.isDisplayed()){
						 Yesbutton.click();
						 System.out.println("End visit Yes/Confirm button is clicked : " +Yesbutton.getText());
						 Thread.sleep(2000);
						 generalActionbox = driver.findElement(By.xpath("//div[@class='action-section']//ul/h3[contains(text(),'General Actions')]"));
						 System.out.println("Is General Actions displayed now:"  +generalActionbox.isDisplayed());
					 }
					 
				 }
		 
	}
	
	public void cancelStartVisit() throws InterruptedException {
		System.out.println("========Start Visit Cancel Confirmation===========");
		//General Actions /Start Visit
		WebElement startvisitdialogueModal = driver.findElement(By.xpath("//div[@id='quick-visit-creation-dialog']//div[@class='dialog-content']"));
		String startvisitdialogueText = startvisitdialogueModal.getText();
		WebElement startvisitModalmessage = driver.findElement(By.xpath("//div[@id='quick-visit-creation-dialog']//div[@class='dialog-content']//p"));
		String startvisitModalText = startvisitModalmessage.getText();
		WebElement startcancelbutton = driver.findElement(By.xpath("//div[@id='quick-visit-creation-dialog']//div[@class='dialog-content']//button[contains(text(),'Cancel')]"));
		
	   if(startvisitdialogueModal.isDisplayed())
		{
			Thread.sleep(2000);
			startcancelbutton.click();
			System.out.println("Start visit No/Cancel button is clicked" +startcancelbutton.getText());
			Thread.sleep(2000);
			 WebElement visitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3"));
			 System.out.println("  General Actions is still displayed  : " +visitActionbox.getText().contains(generalActions));
		}  
		
	}
	
	public void acceptStartVisit() throws InterruptedException {
		System.out.println("===========Start Visit Accepted Confirmation==============");
		//Start Visit
		generalActionbox = driver.findElement(By.xpath("//div[@class='action-section']//ul/h3[contains(text(),'General Actions')]"));
		WebElement startvisitdialogueModal = driver.findElement(By.xpath("//div[@id='quick-visit-creation-dialog']//div[@class='dialog-content']"));
		String startvisitdialogueText = startvisitdialogueModal.getText();
		WebElement startvisitModalmessage = driver.findElement(By.xpath("//div[@id='quick-visit-creation-dialog']//div[@class='dialog-content']//p"));
		String startvisitModalText = startvisitModalmessage.getText();
		WebElement Confirmstartvisitlbutton = driver.findElement(By.xpath("//div[@id='quick-visit-creation-dialog']//div[@class='dialog-content']//button[contains(text(),'Confirm')]"));
		if( generalActionbox.isDisplayed()){
			 System.out.println("Genral Action Option is available : " + generalActionbox.getText());
			 startvisit = driver.findElement(By.xpath("//div[@class='action-section']//a[contains(@id,'org.openmrs.module.coreapps.createVisit')]"));
			startvisit.click();
			wait.until(ExpectedConditions.elementToBeClickable(startvisit));
			System.out.println("Start Visit is clicked");		
			
		//	if(startvisitdialogueModal.isDisplayed() && startvisitdialogueText.equals(startvisitModalText)) {
			if(startvisitdialogueModal.isDisplayed()) {
				Thread.sleep(2000);
				Confirmstartvisitlbutton.click();
				System.out.println("Start visit OK/Confirm button is clicked : " +Confirmstartvisitlbutton.getText());
				Thread.sleep(2000);
//				WebElement recentvisit = driver.findElement(By.xpath("//div[@class='info-header']//h3[contains(text(),'RECENT VISITS')]"));
//				WebElement recentvisitValue = driver.findElement(By.xpath("//div[@class='info-body']//ul//li/a"));
//				String recentvisitDate = recentvisitValue.getText();
//				String none ="None";
//				if(!recentvisitDate.equals(none)) {
//					System.out.println("User ended the visit" +recentvisitDate);
//					WebElement visitActionbox =  driver.findElement(By.xpath("//div[@class='action-section']//ul/h3"));
//					 System.out.println("  General Actions is still displayed  : " +visitActionbox.getText().contains(generalAction));
//					
//				}
//				else {
//					System.out.println("User ended the visit" +none);
//					Actionbox.equals(currentActions);
//				}
			}
	 }
	
	}
//	@Then("User validates the patient visit page bread crumb links has Visit")
	public void verifiesPatientisonVisitpage() {
		//*[@id="breadcrumbs"]/li[3]/text()
		System.out.println("============Verified Visits text in Dashboard ===========");
	//	WebElement breadcrumbVisit = driver.findElement(By.xpath("//ul[@id='breadcrumbs']/li[3]/text()"));
		WebElement VisitsinDashboard = driver.findElement(By.xpath("//div[@class='dashboard-container']//ul//a[contains(text(),'Visits')]"));
		String  visits = VisitsinDashboard.getText();
		String  visitstext = "Visits";
		if(visits.equals(visitstext)) {
			System.out.println("User landed on the Patient Visits page" +visits);
		}
		else {
			System.out.println("User is not on patient visits page");
		}
	}

//	@Then("User clicks on visit note and user is directed to Patient Visit note page.")
	public void clicksOnVisitNote() {
		System.out.println("============Verify VisistNote breadcrumb============");
		WebElement visitnote = driver.findElement(By.id("referenceapplication.realTime.simpleVisitNote"));
		visitnote.click();
		//verify Visitnote page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	//	WebElement VisitNotebreadcrumb = driver.findElement(By.xpath("//ul[@id='breadcrumbs']//li[3]/text()"));
		WebElement VisitNoteheader = driver.findElement(By.xpath("//form[@id='htmlform']//htmlform//h2[contains(text(),'Visit Note')]"));
		//form[@id='htmlform']//htmlform//h2[contains(text(),'Visit Note')]
		String visitNoteText = VisitNoteheader.getText();
		String VisitNoteheaderText = "Visit Note";
		if(visitNoteText.equals(VisitNoteheaderText)) {
			System.out.println("User is on Patient Visit note page : " +visitNoteText);
		}
		else {
			System.out.println("User is not on patient Visit note page");
		}
		
	}

//	@Then("User Add presumed or confirmed diagnosis message and verifies diagnosis section")
	public void addPresumedorConfirmeddiagnosismessage() throws InterruptedException {
		System.out.println("=========Enters Primary and Secondary Diagnosis message==========");
	 WebElement diagnosisSearch = driver.findElement(By.id("diagnosis-search"));
	 String primary = "General";
	 String secondary = "Cough";
	 diagnosisSearch.sendKeys(primary);
	 System.out.println("Primary diagnosis message is entered");
//	 Select diagnosis = new Select(diagnosisSearch);
//	 diagnosis.selectByVisibleText("Non-Coded general");
	 WebElement displayeditems = driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]"));
	 System.out.println("dropdown is displayed");
	//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]
	 //Mouse hover
	 Actions act = new Actions(driver);
	 wait.until(ExpectedConditions.visibilityOf(displayeditems));
	 act.moveToElement(displayeditems).click().build().perform();
	 System.out.println("First option from the dropdown is selected for Primary");
	//*[@id="display-encounter-diagnoses-container"]/div[1]
	Thread.sleep(2000);
	 System.out.println("Verifying the primary diagnosis section : ");
	 WebElement primaryDiagnosis = driver.findElement(By.xpath("//div[@id='display-encounter-diagnoses-container']/div[1]"));
	 System.out.println(primaryDiagnosis.isDisplayed());
	 String primaryDiagnosistext = primaryDiagnosis.getText();
	 System.out.println(primaryDiagnosistext);
	 //Not chosen
	//*[@id="display-encounter-diagnoses-container"]/ul[1]/li/span/div/strong
	 WebElement primarydiagnosisoption = driver.findElement(By.xpath("//div[@id='display-encounter-diagnoses-container']/ul[1]/li/span/div/strong"));
	// wait.until(ExpectedConditions.visibilityOf(primarydiagnosisoption));
	 String primarydiagnosisoptionText = primarydiagnosisoption.getText();
	 if(primarydiagnosisoptionText.contains(primary)) {
		 System.out.println("Primary Diagnosis is added under the Primary Diagnosis section");
	 }
	 else {
		 System.out.println("Still not chosen or empty is displayed");
	 }
	 Thread.sleep(2000);
	 //For Secondary diagnosis
	 System.out.println("Secondary diagnosis message: ");
	
	 diagnosisSearch.sendKeys(secondary);
	 System.out.println("Secondary diagnosis message is entered");
	 Thread.sleep(2000);
	 WebElement secondarydiagnosis = driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']//li[1]//a//strong"));
	// wait.until(ExpectedConditions.visibilityOf(displayeditems));
	 act.moveToElement(secondarydiagnosis).click().build().perform();
	 System.out.println("First option from the dropdown is selected for Secondary");
	 Thread.sleep(2000);
	 WebElement secondaryDiagnosis = driver.findElement(By.xpath("//div[@id='display-encounter-diagnoses-container']/div[2]"));
	 String secondaryDiagnosistext = secondaryDiagnosis.getText();
	 System.out.println(secondaryDiagnosistext);
	//*[@id="display-encounter-diagnoses-container"]/ul[2]/li/span/div/strong
	 WebElement secondarydiagnosisoption = driver.findElement(By.xpath("//div[@id='display-encounter-diagnoses-container']/ul[2]/li/span/div/strong"));
	 wait.until(ExpectedConditions.visibilityOf(secondarydiagnosisoption));
	 String secondarydiagnosisoptionText = secondarydiagnosisoption.getText();
	 if(secondarydiagnosisoptionText.contains(secondaryDiagnosistext)) {
		 System.out.println("Secondary Diagnosis is added under the Secondary Diagnosis section");	
	 }
	 else {
		 System.out.println("Still None or empty is displayed");
	 }
	}


//	@And("User clicks on Save button is directed back to patient visit page")
	public void clickSaveandNavigatePatientVisitPage() {
		System.out.println("============Click on Save=======");
	  WebElement save = driver.findElement(By.xpath("//input[@value='Save']"));
	  save.click();
	  System.out.println("Save button is clicked");
	  String VisitpageURL ="https://o2.openmrs.org/openmrs/coreapps/patientdashboard/patientDashboard.page?encounterId=5664&patientId=561&&visitId=2415";
	  String actualvisitURL = driver.getCurrentUrl();
	//  assertEquals(VisitpageURL, actualvisitURL);
	  System.out.println("Successfully saved patient visit note and completed");
	}


}
