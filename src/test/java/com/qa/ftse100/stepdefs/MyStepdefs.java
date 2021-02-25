package com.qa.ftse100.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

        webDriver = new ChromeDriver();
    }

    @Given("I am on the FTSE site")
    public void iAmOnTheFTSESite() {
        webDriver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        assertTrue(webDriver.getTitle().toLowerCase(Locale.ROOT).contains("ftse 100"));
    }

    @Given("I have navigated to the risers tab")
    public void iHaveNavigatedToTheRisersTab() throws InterruptedException {
        webElement = webDriver.findElement(By.cssSelector("#acceptCookie"));
        webElement.click();
        webElement = webDriver.findElement(By.cssSelector("li.one-line:nth-child(2) > a:nth-child(1)"));
        webElement.click();
        assertTrue(webDriver.getTitle().toLowerCase(Locale.ROOT).contains("risers"));
    }

    @Then("I can see the largest riser")
    public void iCanSeeTheLargestRiser() {
        webElement = webDriver.findElement(By.cssSelector(".stockTable > tbody:nth-child(2)"));
        List<WebElement> riserRows = webElement.findElements(new By.ByTagName("tr"));
        String topRiser = riserRows.get(0).findElement(new By.ByTagName("td")).getText();
        System.out.println("Top riser is " + topRiser);
        assertNotNull(topRiser);
    }

    @Given("I have navigated to the fallers tab")
    public void iHaveNavigatedToTheFallersTab() {
        webElement = webDriver.findElement(By.cssSelector("#acceptCookie"));
        webElement.click();
        webElement = webDriver.findElement(By.cssSelector("li.one-line:nth-child(3) > a:nth-child(1)"));
        webElement.click();
        assertTrue(webDriver.getTitle().toLowerCase(Locale.ROOT).contains("fallers"));
    }

    @Then("I can see the largest faller")
    public void iCanSeeTheLargestFaller() {
        webElement = webDriver.findElement(By.cssSelector(".stockTable > tbody:nth-child(2)"));
        List<WebElement> riserRows = webElement.findElements(new By.ByTagName("tr"));
        String topFaller = riserRows.get(0).findElement(new By.ByTagName("td")).getText();
        System.out.println("Top faller is " + topFaller);
        assertNotNull(topFaller);
    }

    @After
    public void teardown() {
        webDriver.close();
    }

}
