package com.qa.mercurytours.stepdefs;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {

    private static WebDriver webDriver;

    private static WebElement webElement;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        webDriver = new ChromeDriver();
    }

    @Given("I am on the mercury tours website")
    public void iAmOnTheMercuryToursWebsite() {
        webDriver.get("http://demo.guru99.com/test/newtours/");
        assertEquals("Welcome: Mercury Tours", webDriver.getTitle());
    }

    @Given("I navigate to the registration page")
    public void iNavigateToTheRegistrationPage() {
        webElement = webDriver.findElement(By.cssSelector("td.mouseOut:nth-child(2) > a:nth-child(1)"));
        webElement.click();
        assertEquals("Register: Mercury Tours", webDriver.getTitle());
    }

    @When("I enter my details")
    public void iEnterMyDetails() {
        webElement = webDriver.findElement(By.id("email"));
        webElement.sendKeys("Cucumber");
        webElement = webDriver.findElement(By.name("password"));
        webElement.sendKeys("cucumber");
        webElement = webDriver.findElement(By.name("confirmPassword"));
        webElement.sendKeys("cucumber");
    }

    @And("I hit the submit query button")
    public void iHitTheSubmitQueryButton() {
        webElement = webDriver.findElement(By.name("submit"));
        webElement.click();
    }

    @Then("I have successfully registered")
    public void iHaveSuccessfullyRegistered() {
        assertEquals("http://demo.guru99.com/test/newtours/register_sucess.php", webDriver.getCurrentUrl());
    }

    @Given("I navigate to the sign-on page")
    public void iNavigateToTheSignOnPage() {
        webElement = webDriver.findElement(By.cssSelector("td.mouseOut:nth-child(1) > a:nth-child(1)"));
        webElement.click();
        webElement = webDriver.findElement(By.cssSelector("td.mouseOut:nth-child(1) > a:nth-child(1)"));
        webElement.click();
    }

    @When("I enter my user details")
    public void iEnterMyUserDetails() {
        webElement = webDriver.findElement(By.name("userName"));
        webElement.sendKeys("cucumber");
        webElement = webDriver.findElement(By.name("password"));
        webElement.sendKeys("cucumber");
    }

    @And("I hit the submit button")
    public void iHitTheSubmitButton() {
        webElement = webDriver.findElement(By.name("submit"));
        webElement.click();
    }

    @Then("I have successfully signed in")
    public void iHaveSuccessfullySignedIn() {
        assertEquals("http://demo.guru99.com/test/newtours/login_sucess.php", webDriver.getCurrentUrl());
    }

    @After
    public void teardown() {
        webDriver.close();
    }
}
