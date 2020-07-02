package stepdefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utility.Hook;

public class LoginStepDef {
    private WebDriver driver;

    public LoginStepDef() {
        this.driver = Hook.getDriver();
    }


    @AndroidFindBy(accessibility = "com.glowie.staging:id/txtHaveAnAccount")
    private MobileElement BtnExistingAccount;

    @When("^I click I have an account already$")
    public void iClickTxtHaveAnAccount() {
            BtnExistingAccount.click();
    }

    @When("^I click login with different account$")
    public void iClickLoginWithDifferentAccount() {
        driver.findElement(By.id("com.glowie.staging:id/btnSignUpFaceBook")).click();
    }
    @When("^I click to the avatar$")
    public void iClickToTheAvatar() {
        driver.findElement(By.id("com.glowie.staging:id/ivAvatar")).click();
    }

    @AndroidFindBy (accessibility = "com.glowie.staging:id/btnLoginOther")
    private MobileElement btnLoginOther;

    @When("^I click login with other account$")
    public void iClickLoginWithOtherAccount() {
        driver.findElement(By.id("com.glowie.staging:id/btnLoginOther")).click();
    }

    @And("^I select a Facebook Account$")
    public void iSelectAFacebookAccount() {
        driver.findElement(By.id("com.facebook.katana:id/(name removed)")).click();
    }

    @And("^Saved account seletion$")
    public void savedAccountSeletion() {
        driver.findElement(By.id("com.glowie.staging:id/btnSave")).click();
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

    @And("^Unsaved account seletion$")
    public void handleSaveAccount() throws InterruptedException {
        driver.findElement(By.id("com.glowie.staging:id/btnNotSave")).click();
        Thread.sleep(5000);
    }

    @And("^I click login via Facebook account$")
    public void iClickLoginViaFacebookAccount() {
        driver.findElement(By.id("com.glowie.staging:id/loginWithFacebookTextView")).click();
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
