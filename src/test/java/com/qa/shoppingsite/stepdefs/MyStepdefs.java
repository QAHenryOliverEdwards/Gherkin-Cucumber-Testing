package com.qa.shoppingsite.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MyStepdefs {

    private static WebDriver webDriver;

    private static WebElement webElement;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        webDriver = new ChromeDriver(chromeCfg());
    }

    @Given("I'm on the home page")
    public void iMOnTheHomePage() {
        webDriver.get("http://automationpractice.com/index.php");
        assertEquals("My Store", webDriver.getTitle());
    }

    @When("I search for a dress")
    public void iSearchForADress() {
        webElement = webDriver.findElement(By.id("search_query_top"));
        webElement.sendKeys("dress");
        webElement = webDriver.findElement(By.name("submit_search"));
        webElement.click();
        webElement = webDriver.findElement(By.cssSelector(".page-heading"));
        assertTrue(webElement.getText().toLowerCase(Locale.ROOT).contains("dress"));
    }

    @Then("Dresses show up in the results")
    public void dressesShowUpInTheResults() {
        List<WebElement> allResults = webDriver.findElements(By.className("ajax_block_product"));
        for (WebElement webElement : allResults) {
            String productName = webElement.findElement(By.className("product-name")).getText();
            if (!productName.contains("dress")) {
                System.out.println(productName);
                fail();
            }
        }
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
