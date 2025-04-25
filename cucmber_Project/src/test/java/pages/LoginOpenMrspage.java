package pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginOpenMrspage {
	static WebDriver driver;
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
	public LoginOpenMrspage(WebDriver d) {
		driver = d;
	}
	
	public void openLoginPage() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.get("https://o2.openmrs.org/openmrs/login.htm");
		
	   
	}

	public void enterLoginCredentials(String uname, String pwd,String session) throws InterruptedException {
		System.out.println("================OpenMRS Login Page===================");
		System.out.println("username = " +uname);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(uname);
		System.out.println("Username is enetered");
		System.out.println("password = " +pwd);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pwd);
		System.out.println("Password is enetered");
		System.out.println(session);
		
		WebElement sessionlocation = driver.findElement(By.xpath("//form//fieldset//ul//li[text()='" +session+ "']"));
//		//sessionlocation.click();
		//wait.until(ExpectedConditions.elementToBeSelected(sessionlocation));
		sessionlocation.click();
		System.out.println("Session location is selected");
	}

	public void clickloginButton() throws InterruptedException {
		WebElement loginbutton = driver.findElement(By.xpath("//input[@id='loginButton']"));
		loginbutton.click();
		//Thread.sleep(2000);
	    System.out.println("Login button is clicked");
	}
	
	public void logonHeaderVerification(String username, String location) {
		System.out.println("Login is success");

		WebElement adminname = driver.findElement(By.xpath("//div[@id='content']//div//h4[contains(text(),'"+username+"')]"));
		WebElement session = driver.findElement(By.xpath("//div[@id='content']//div//h4[contains(text(),'"+location+"')]"));
		System.out.println(adminname.isDisplayed());
		System.out.println(session.isDisplayed());
	}
	//For invalid credentials verify error text
	public void invalidloginErrorText() {
	   WebElement errortext = driver.findElement(By.xpath("//div[@id='error-message'][contains(text(),'Invalid username/password. Please try again.')]"));
	   System.out.println("Invalid logon");
	   System.out.println(errortext.getText());
	   System.out.println(errortext.isDisplayed());
	}

}
