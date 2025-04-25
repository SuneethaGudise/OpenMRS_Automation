package orangeHRM_stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;
	
		
		@Given("User is on login page")
		public void user_is_on_login_page() throws InterruptedException {
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  Thread.sleep(2000);
		}

		@When("User enters valid username and password")
		public void user_enters_valid_username_and_password() {
		    driver.findElement(By.name("username")).sendKeys("Admin");
		    driver.findElement(By.name("password")).sendKeys("admin123");
		}

		@When("Click on login button")
		public void click_on_login_button() {
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		}

		@Then("User is navigated to the home page")
		public void user_is_navigated_to_the_home_page() {
		   System.out.println("User is on home page");
		}


	

}
