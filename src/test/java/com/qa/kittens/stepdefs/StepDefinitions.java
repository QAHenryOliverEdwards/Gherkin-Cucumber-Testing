package com.qa.kittens.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private static WebDriver webDriver;

    private static WebElement webElement;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        webDriver = new ChromeDriver(chromeCfg());
    }

    @Given("I navigate to google")
    public void iNavigateToGoogle() {
        webDriver.get("https://www.google.com/");
        assertEquals("Google", webDriver.getTitle());
    }

    @When("I search for kittens")
    public void iSearchForKittens() {
        webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("kittens");
        webElement = webDriver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)"));
        webElement.click();
        assertEquals("kittens - Google Search", webDriver.getTitle());
    }

    @And("I click the images tab")
    public void iClickTheImagesTab() {
        webElement = webDriver.findElement(By.cssSelector("#hdtb-msb > div:nth-child(1) > div > div:nth-child(2) > a"));
        webElement.click();
    }

    @Then("I can see images of kittens")
    public void iCanSeeImagesOfKittens() {
        webElement = webDriver.findElement(By.cssSelector("#islmp > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));
        assertTrue(webElement.getText().toLowerCase(Locale.ROOT).contains("cat"));
    }

    @After
    public void teardown() {
        webDriver.close();
    }

    // Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
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