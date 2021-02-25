package com.qa.thedemositemultiple.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionstheDemoSiteMultiple {

    private static WebDriver webDriver;

    private static WebElement webElement;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        webDriver = new ChromeDriver(chromeCfg());
    }

    @Given("I'm on thedemosite")
    public void i_m_on_thedemosite() {
        webDriver.get("http://thedemosite.co.uk/login.php");
    }

    @When("I navigate to the add a user page")
    public void i_navigate_to_the_add_a_user_page() {
        webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
    }

    @And("I enter a {string} and a {string}")
    public void i_enter_a_username_and_a_password(String username, String password) {
        webElement = webDriver.findElement(By.cssSelector(".auto-style1 > form:nth-child(6) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
        webElement.sendKeys(username);
        webElement = webDriver.findElement(By.cssSelector(".auto-style1 > form:nth-child(6) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
        webElement.sendKeys(password);
    }

    @Then("I have created a user")
    public void i_have_created_a_user() {
        webElement = webDriver.findElement(By.name("FormsButton2"));
        webElement.click();
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        webDriver.get("http://thedemosite.co.uk/login.php");
    }

    @And("I enter my {string} and {string}")
    public void i_enter_my_username_and_password(String username, String password) {
        webElement = webDriver.findElement(By.cssSelector(".auto-style1 > form:nth-child(8) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
        webElement.sendKeys(username);
        webElement = webDriver.findElement(By.cssSelector(".auto-style1 > form:nth-child(8) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
        webElement.sendKeys(password);

    }

    @Then("I have successfully logged in")
    public void i_have_successfully_logged_in() {
        webElement = webDriver.findElement(By.name("FormsButton2"));
        webElement.click();
        webElement = webDriver.findElement(By.cssSelector(".auto-style1 > big:nth-child(6) > blockquote:nth-child(1) > blockquote:nth-child(1) > font:nth-child(1) > center:nth-child(1) > b:nth-child(1)"));
        assertEquals( "**Successful Login**", webElement.getText());
    }

    @After
    public void teardown() {
        webDriver.close();
    }

    public static ChromeOptions chromeCfg() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        ChromeOptions cOptions = new ChromeOptions();

        // Settings
        prefs.put("profile.default_content_setting_values.cookies", 2);
        prefs.put("network.cookie.cookieBehavior", 2);
        prefs.put("profile.block_third_party_cookies", true);
        // cOptions.setHeadless(true);

        // Create ChromeOptions to disable Cookies pop-up
        cOptions.setExperimentalOption("prefs", prefs);

        return cOptions;
    }
}