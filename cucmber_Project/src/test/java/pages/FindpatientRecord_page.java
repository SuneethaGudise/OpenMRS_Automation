package pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
//import org.testng.Assert;
import static org.junit.Assert.assertEquals;

public class FindpatientRecord_page {
	
	WebDriver driver;
	static String patientName;
	
	public FindpatientRecord_page(WebDriver d) {
		driver = d;
	}
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		
	
	
	public void clicksFindPatientRecordoption() {
		System.out.println("==============SessionLocation Page / InPatient WardPage ===================");
		System.out.println("User is ready to select the Options");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension
		WebElement findpatientrecord = driver.findElement(By.xpath("//div//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
		String optiontext = findpatientrecord.getText();
		findpatientrecord.click();	
		System.out.println("Find Patient Record option is clicked" +optiontext);
	}

	public void findPatientRecordpageTitleValidation() {
		System.out.println("=============Find Patient Record page===================================");
		System.out.println("User is directed to FindPatient Page and now Validates Current URL and title : ");
	    String currentURL = driver.getCurrentUrl();
	    System.out.println("Find Patient Record page URL is : " +currentURL);
	    String expectedURL ="https://o2.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient";
	    System.out.println("Verified URLs");
	    assertEquals(expectedURL,currentURL);
	    String actualTitle = driver.getTitle();
	    System.out.println("Find Patient Record page title is :" +actualTitle);
	    String expectedTitle = "OpenMRS Electronic Medical Record";
	    System.out.println("Verified Titles");
	    assertEquals(expectedTitle,actualTitle);
	}

	public void iconHeaderTextValidation() {
	   System.out.println("Verifying the header icon and text on Find Patient Record page : ");
	   //ul[@id='breadcrumbs']//li[contains(text(),'Find Patient Record')]
		 //*[@id="breadcrumbs"]/li[2]/text()
	
//	   WebElement icon = driver.findElement(By.xpath("//*[@id='breadcrumbs']/li[2]/text()"));
//	   String actualicontext = icon.getText();
//	   String expectediconText = "Find Patient Record";
//	   System.out.println("Icon is displayed : " +icon.isDisplayed());
//	   assertEquals(expectediconText, actualicontext);
	   //Verifying header text
	   WebElement header = driver.findElement(By.xpath("//div[@id='content']//h2"));
	   String actualheadertext = header.getText();
	   String expectedHeadertext = "Find Patient Record";
	   System.out.println("Header Text is displayed : " +header.isDisplayed());
	   assertEquals(expectedHeadertext,actualheadertext);
	}

	public void searchboxVerification() {
	   System.out.println("=====PatientRecord/ SearchBox=======");
	   WebElement searchbox = driver.findElement(By.id("patient-search"));
	   boolean searchboxstatus = searchbox.isEnabled();
	   System.out.println("Search box is : " +searchboxstatus);
	}

	public void ispatientTableDispalyed() {
	   System.out.println("======PatientRecord/ table=========");
	   WebElement tablestatus = driver.findElement(By.cssSelector("table[aria-describedby='patient-search-results-table_info']"));
	   System.out.println("Table inforamtion is displayed : " +tablestatus.isDisplayed());
	   int tablerows = driver.findElements(By.xpath("//div//table//tr")).size();
	   System.out.println("Number of rows in table" + ":" +tablerows);
	   int tablecols = driver.findElements(By.xpath("//div//table//th")).size();
	   System.out.println("Number of columns in table" + ":" +tablecols);
//	   for(int rows=1; rows<tablerows; rows++) {
//		   for(int cols = 1; cols< tablecols;cols++) {
//			   
//		   }
//	   }
	}

	public void columnvaluesIsclickable() {
		System.out.println("=========Table values are Clickable/notClickable==========");
//		WebElement table = driver.findElement(By.cssSelector("table")); // finding the table
//		List<WebElement> tablecelldata = table.findElements(By.xpath("//div//table//tr")); //table cell data
//		// putting all the row data into the 
//		for(WebElement rows : tablecelldata) {
//			List<WebElement> cells = rows.findElements(By.xpath("//div//table//th")); // getting the data from each cell of each row
//			for(WebElement cell : cells) {
//				List<WebElement> cellLinks = cell.findElements(By.xpath("//div//table//td"));
////				System.out.println("cell size is : " +cellLinks.size());
//	//			List<WebElement> clickableLinks = new ArrayList<>(); //converting list to Arraylist
//			//	for(WebElement links : cellLinks) {
//				
//					System.out.println("Links are displyaed" + cellLinks.isDisplayed());
//					wait.until(ExpectedConditions.visibilityOf(cellLinks));
//					System.out.println("Links are Enabled" + links.isEnabled());
//					wait.until(ExpectedConditions.elementToBeClickable(links));
////					if(links.isDisplayed() && links.isEnabled()) {
////						//System.out.println("Cell links are enabled and clickable");
////					//	System.out.println("The Link text is clickable : " +links.getText());
////						//clickableLinks.add(links);	
////					}
////					else {
////						System.out.println("Cell links are Disabled and not clickable");
////					//	System.out.println("Links are disabled : " +links.getText());
////					
////					}
//				//}
//			//	System.out.println("cell size is : " +cellLinks.size());
//			}
			
	//	}
	//	System.out.println("Valid code to verify the links enable");
		
//		WebElement table = driver.findElement(By.cssSelector("table")); // finding the table
//		//Find all the links in the table
//		List<WebElement> allLinks = table.findElements(By.xpath("//div//table//td"));
//		//Filter only Clickable links
//	//	List<WebElement> clickableLinks = new ArrayList<>();
//		for(WebElement links : allLinks) {
//			//String text = links.getText();
//			if(links.isDisplayed() && links.isEnabled()) {
////			clickableLinks.add(links);
//			System.out.println("Links are clickable : " +links.isDisplayed());
//			System.out.println("Links are enabled : " +links.isEnabled());
//			}
//			else {
//				System.out.println("Links are disabled : " +links.getText());
//			}
//		}
//		System.out.println("Table values are verified");
	}

//	public void clickColumnValues() {
//		WebElement table = driver.findElement(By.cssSelector("table")); // finding the table
//		//Find all the links in the table
//		List<WebElement> allLinks = table.findElements(By.xpath("//div//table//td"));
//		//Filter only Clickable links
//		List<WebElement> clickableLinks = new ArrayList<>();
//		for(WebElement links : allLinks) {
//			//String text = links.getText();
//			if(links.isDisplayed() && links.isEnabled()) {
////			clickableLinks.add(links);
//			System.out.println("Links are clickable : " +clickableLinks.toString());
//			}
//			else {
//				System.out.println("Links are disabled : " +clickableLinks.toString());
//			}
//		}
//		
//		Random random = new Random();
//		WebElement randomlink = clickableLinks.get(random.nextInt(clickableLinks.size()));
//		wait.until(ExpectedConditions.elementToBeClickable(randomlink));
//		System.out.println("Random link clicked is : " +randomlink.getText());   
//	}
	public void clickColumnValues() throws InterruptedException {
		//table/tbody//tr[1]
		
				WebElement  firstrow = driver.findElement(By.xpath("//table/tbody//tr[1]"));
				//table/tbody//td[2]
				WebElement celldata = firstrow.findElement(By.xpath("//table/tbody//td[2]"));
				patientName = celldata.getText();
				System.out.println("Clicked cell text is : " +patientName);
				celldata.click();
				System.out.println("Patient name is clicked");
				Thread.sleep(2000);
				//wait.until(ExpectedConditions.elementToBeClickable(celldata));
				
	}

	public void patientRecordpage() {
		//table/tbody//tr[1]
//		WebElement  firstrow = driver.findElement(By.xpath("//table/tbody//tr[1]"));
//		//table/tbody//td[2]
//		WebElement celldata = firstrow.findElement(By.xpath("//table/tbody//td[2]"));
//		celldata.click();
//		String celltext = celldata.getText();
		//*[@id="content"]/div[6]/div[1]/div/div[1]/h1/span[1]/span
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement givenName = driver.findElement(By.xpath("//div//h1//span[@class='PersonName-givenName']"));
		String givennameText = givenName.getText();
		System.out.println("Given Name is: " +givennameText);
		//*[@id="content"]/div[6]/div[1]/div/div[1]/h1/span[2]/span
		WebElement familyName = driver.findElement(By.xpath("//div//h1//span[@class='PersonName-familyName']"));
		String familynameText = familyName.getText();
		System.out.println("Family name is : " +familynameText);
		String fullname = givennameText + " " +familynameText ;
		System.out.println("Full name is : " +fullname);
		assertEquals(patientName,fullname);
		System.out.println("Patient name is validated");
	}

}
