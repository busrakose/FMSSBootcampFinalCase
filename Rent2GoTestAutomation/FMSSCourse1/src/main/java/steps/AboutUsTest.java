package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AboutUsTest {

    String title ="FMSS Future Mobile";
    String message = "messgae";

    @Given("User lands on enterprise page with this {string} title and this {string}")
    public void userLandsOnEnterprisePageWithThisTitleAndThis(String title, String message) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://fmss.com.tr/tr");
        Assert.assertEquals(message, title,driver.getTitle());
          }
    @When("User reads text")
    public void userReadsText() {

    }

    @And("User verifies text as")
    public void userVerifiesTextAs() {
        System.out.println("user verifies text as metodundayım");
    }


    @Given("User lans on enterprise page")
    public void userLansOnEnterprisePage() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://fmss.com.tr/tr");
        Assert.assertEquals(message, title,driver.getTitle());
    }

    @When("User clicks mission under aboutUs")
    public void userClicksMissionUnderAboutUs() {

    }

    @Given("User clicks {string} page under {string}")
    public void userClicksPageUnder(String subPage, String page) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor scpt = (JavascriptExecutor)driver;
        Assert.assertEquals(page+" should be ",page,scpt.executeScript("document.getElementsByClassName('main')[1].textContent();"));
        scpt.executeScript("document.getElementsByClassName('main')[1].click();");
        Assert.assertEquals(subPage+ " should have "+subPage,driver.getTitle(),subPage);
        driver.quit();

    }
}
