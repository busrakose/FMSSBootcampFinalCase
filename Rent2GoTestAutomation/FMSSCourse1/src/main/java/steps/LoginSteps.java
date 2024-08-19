package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterUsername("invalid");
        loginPage.enterPassword("invalid");
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the Dashboard page")
    public void user_should_be_redirected_to_the_dashboard_page() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.quit();
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        boolean isErrorMessageDisplayed = driver.getPageSource().contains("Invalid credentials");
        assertTrue(isErrorMessageDisplayed);
        driver.quit();
    }
}
