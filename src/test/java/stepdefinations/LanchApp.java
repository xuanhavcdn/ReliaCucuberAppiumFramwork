package stepdefinations;

import cucumber.api.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Hook;

public class LanchApp {

private WebDriver driver;
	
	public LanchApp() {
		this.driver = Hook.getDriver();
	}
	
	@Given("^I open the application$")
	public void i_open_the_application() throws Throwable {
	    Assert.assertTrue(driver.findElement(By.id("com.glowie.staging:id/txtHaveAnAccount")).isDisplayed());
	}
}
