package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class registrationSteps {

    WebDriver driver;

    @When("^I click on register button$")
    public void iClickOnRegisterButton() {

        System.setProperty("webdriver.gecko.driver", "C:\\BlueskycitadelP\\Firefox1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://propertyrete.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='black bw0 f6-ns f7 fw3 bg-white-90 br1 pv2-5-ns pv2-5 ph3 ttu tracked outline-0 bw0 link']")).click();
    }

    @And("^I enter first name \"([^\"]*)\"$")
    public void iEnterFirstName(String arg0) throws Throwable {
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Anne");
    }
    @And("^I enter last name \"([^\"]*)\"$")
    public void iEnterLastName(String arg0) throws Throwable {
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Mensi");
    }

    @And("^I enter email address \"([^\"]*)\"$")
    public void iEnterEmailAddress(String arg0) throws Throwable {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("blessings4u10@gmail.com");
    }

    @And("^I enter valid Mobile number \"([^\"]*)\"$")
    public void iEnterValidMobileNumber(String arg0) throws Throwable {
        driver.findElement(By.xpath("//div[@class='iti-arrow']")).click();
        driver.findElement(By.xpath("//section[contains(@class,'nav-header-sec w-100 flex flex-column')]//section[contains(@class,'')]//li[2]//span[1]")).click();
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("07575555555");
    }

    @And("^I enter Password \"([^\"]*)\"$")
    public void iEnterPassword(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("#password")).sendKeys("12345hs");
    }

    @And("^I enter confirm Password \"([^\"]*)\"$")
    public void iEnterConfirmPassword(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("#confirm_password")).sendKeys("12345hs");
    }

    @And("^I check the checkbox$")
    public void iCheckTheCheckbox() {
      WebElement captcha = driver.findElement(By.xpath("//label[contains(text(),'Captcha')]"));
        Assert.assertTrue(captcha.isDisplayed());
        Assert.assertTrue(captcha.getText().contains("Captcha"));

    }

    @And("^I click on create account$")
    public void iClickOnCreateAccount() {
        driver.findElement(By.xpath("//input[@id='btn_register']")).click();
    }

    @And("^I paste the activation code received$")
    public void iPasteTheActivationCodeReceived() {
    }

    @And("^I click on active account$")
    public void iClickOnActiveAccount() {
        driver.findElement(By.xpath("//input[@id='btn_activate_code']")).click();
    }

    @Then("^I am registered$")
    public void iAmRegistered() {
        Assert.assertEquals(driver.findElement(By.id("dng_id")).getText(),"The email address is already used, please login instead or click this link to reset your password: Forget Password");
    }

}
