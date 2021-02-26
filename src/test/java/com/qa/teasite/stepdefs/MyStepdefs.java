package com.qa.teasite.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {

    private static WebDriver webDriver;

    private static WebElement webElement;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        webDriver = new ChromeDriver();
    }

    @Given("the correct web address")
    public void theCorrectWebAddressBrowser() {
        webDriver.get("http://www.practiceselenium.com/welcome.html");
        assertEquals("Welcome", webDriver.getTitle());
    }

    @When("I navigate to the {string} page")
    public void iNavigateToTheMenuPage(String menu) {
        System.out.println(menu);
        webElement = webDriver.findElement(By.cssSelector(".wsb-navigation-rendered-top-level-menu > li:nth-child(3) > a:nth-child(1)"));
        webElement.click();
        assertEquals("Menu", webDriver.getTitle());
    }

    @Then("I can browse a list of the available products")
    public void iCanBrowseAListOfTheAvailableProducts() {
        webElement = webDriver.findElement(By.cssSelector(".wsb-canvas-page-container"));
        assertTrue(webElement.getText().contains("Green Tea"));
        assertTrue(webElement.getText().contains("Red Tea"));
        assertTrue(webElement.getText().contains("Oolong Tea"));
    }

    @Given("The correct web address")
    public void theCorrectWebAddressCheckout() {
        webDriver.get("http://www.practiceselenium.com/welcome.html");
        assertEquals("Welcome", webDriver.getTitle());    }

    @When("I click the checkout button")
    public void iClickTheCheckoutButton() {
        webElement = webDriver.findElement(By.cssSelector(".wsb-navigation-rendered-top-level-menu > li:nth-child(5) > a:nth-child(1)"));
        webElement.click();
    }

    @Then("I am taken to the checkout page")
    public void iAmTakenToTheCheckoutPage() {
        assertEquals("Check Out", webDriver.getTitle());
    }

    @After
    public void teardown() {
        webDriver.close();
    }
}
