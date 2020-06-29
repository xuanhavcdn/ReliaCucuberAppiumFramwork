package stepdefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Hook;

public class LoginStepDef {
    private WebDriver driver;

    public LoginStepDef() {
        this.driver = Hook.getDriver();
    }

    @When("^I click txtHaveAnAccount$")
    public void iClickTxtHaveAnAccount() {
            driver.findElement(By.id("com.glowie.staging:id/txtHaveAnAccount")).click();
    }

    @And("^I input username as \"([^\"]*)\"$")
    public void iInputUsernameAs(String username) throws Throwable {
        driver.findElement(By.id("com.glowie.staging:id/edPhoneNumber")).clear();
        driver.findElement(By.id("com.glowie.staging:id/edPhoneNumber")).sendKeys(username);

    }

    @And("^I input password as \"([^\"]*)\"$")
    public void iInputPasswordAs(String password) throws Throwable {
        driver.findElement(By.id("com.glowie.staging:id/edPassword")).clear();
        driver.findElement(By.id("com.glowie.staging:id/edPassword")).sendKeys(password);

    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        driver.findElement(By.id("com.glowie.staging:id/btnLogin")).click();
    }

    @And("^Handle save account$")
    public void handleSaveAccount() throws InterruptedException {
        driver.findElement(By.id("com.glowie.staging:id/btnNotSave")).click();
        Thread.sleep(5000);
    }

    @Then("^The home page is open$")
    public void theHomePageIsOpen() {
        Assert.assertTrue(driver.findElement(By.id("com.glowie.staging:id/tvTabContest")).isDisplayed());
    }


    @Then("^The error message \"([^\"]*)\" is displayed$")
    public void theErrorMessageIsDisplayed(String error) throws Throwable {
        driver.findElement(By.id("com.glowie.staging:id/tvDes")).isDisplayed();
        driver.findElement(By.id("com.glowie.staging:id/btnConfirm")).click();
    }
}