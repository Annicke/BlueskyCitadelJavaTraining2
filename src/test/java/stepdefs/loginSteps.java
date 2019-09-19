package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class loginSteps {

    WebDriver driver;

    @Given("^I navigate to the site \"([^\"]*)\"$")
    public void i_navigate_to_the_site(String arg1) throws Throwable {
        System.setProperty("webdriver.gecko.driver", "C:\\BlueskycitadelP\\Firefox1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://propertyrete.com");
        driver.manage().window().maximize();
    }

    @When("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
        driver.findElement(By.xpath("//a[@class=\"white ml2 bw0 f6-ns f7 fw3 bg-sec br1 pv2-5-ns pv2-5 ph3 ttu tracked outline-0 bw0 link\"]")).click();
    }

    @And("^I enter my email address \"([^\"]*)\"$")
    public void iEnterMyEmailAddress(String arg0) throws Throwable {
        driver.findElement(By.id("user_email")).sendKeys("blessings4u10@gmail.com");
    }

    @And("^I enter my Password \"([^\"]*)\"$")
    public void iEnterMyPassword(String arg0) throws Throwable {
        driver.findElement(By.id("user_password")).sendKeys("12345hs");
    }

    @And("^I click on Sign In$")
    public void iClickOnSignIn() {
        driver.findElement(By.id("btn_signin")).click();
    }

     @Then("^I am signed In$")
     public void i_am_signed_In() throws Throwable {
         Assert.assertEquals(driver.findElement(By.xpath("//a[@class='black bw0 f6-ns f7 fw3 bg-white-90 br1 pv2-5-ns pv2-5 ph3 ttu tracked outline-0 bw0 link'] ")).getText(),"WELCOME: MENSI ANNE");
    }

}


