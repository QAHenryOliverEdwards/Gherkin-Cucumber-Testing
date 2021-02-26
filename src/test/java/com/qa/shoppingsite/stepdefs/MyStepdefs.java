package com.qa.shoppingsite.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {

    private static WebDriver webDriver;

    private static WebElement webElement;

    private static String email;

    private static String password;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chrome/chromedriver.exe");

        webDriver = new ChromeDriver();
    }

    @Given("I navigate to the sign-up page")
    public void iNavigateToTheSignUpPage() throws InterruptedException {
        // Generating random emails
        String emailPrefix = RandomString.make();
        email = emailPrefix + "@random.com";

        webDriver.get("http://automationpractice.com/index.php");
        webDriver.findElement(By.cssSelector(".login")).click();
        webElement = webDriver.findElement(By.cssSelector("#email_create"));

        webElement.sendKeys(emailPrefix + "@random.com");
        webElement.submit();
    }

    @When("I enter my user credentials")
    public void iEnterMyUserCredentials() throws InterruptedException {

        this.waitUntilLoaded(webDriver);
        Thread.sleep(5000);

        webElement = webDriver.findElement(By.id("id_gender1"));
        webElement.click();

        webElement = webDriver.findElement(By.id("customer_firstname"));
        webElement.sendKeys("QA");

        webElement = webDriver.findElement(By.id("customer_lastname"));
        webElement.sendKeys("Employee");

        // random password
        String randPass = RandomString.make();
        password = randPass;
        webElement = webDriver.findElement(By.id("passwd"));
        webElement.sendKeys(randPass);

        Select select  = new Select(webDriver.findElement(By.id("days")));
        select.selectByValue("1");

        select = new Select(webDriver.findElement(By.id("months")));
        select.selectByValue("1");

        select = new Select(webDriver.findElement(By.id("years")));
        select.selectByValue("2021");

        webElement = webDriver.findElement(By.id("firstname"));
        webElement.sendKeys("QA");

        webElement = webDriver.findElement(By.id("lastname"));
        webElement.sendKeys("Employee");

        webElement = webDriver.findElement(By.id("company"));
        webElement.sendKeys("QA");

        webElement = webDriver.findElement(By.id("address1"));
        webElement.sendKeys("3rd Floor, International House");

        webElement = webDriver.findElement(By.id("address2"));
        webElement.sendKeys("1 St Katharine's Way");

        webElement = webDriver.findElement(By.id("city"));
        webElement.sendKeys("London");

        webElement = webDriver.findElement(By.id("id_state"));
        webElement.sendKeys("c");

        webElement = webDriver.findElement(By.id("postcode"));
        webElement.sendKeys("12345");

        webElement = webDriver.findElement(By.id("other"));
        webElement.sendKeys("A.Robot");

        webElement = webDriver.findElement(By.id("phone"));
        webElement.sendKeys("3489572983");

        webElement = webDriver.findElement(By.id("phone_mobile"));
        webElement.sendKeys("3498573879");

        webElement = webDriver.findElement(By.id("alias"));
        webElement.click();
        webElement.sendKeys("London Lad");
    }

    @And("Hit the submit button")
    public void hitTheSubmitButton() {
        webElement = webDriver.findElement(By.id("submitAccount"));
        webElement.click();
    }

    @Then("I successfully login")
    public void iSuccessfullyLogin() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(email);
        System.out.println(password);
        assertEquals("http://automationpractice.com/index.php?controller=my-account", webDriver.getCurrentUrl());

    }

    @Given("I have searched for an item")
    public void iHaveSearchedForAnItem() throws InterruptedException {
        webDriver.get("http://automationpractice.com/index.php");
        webElement  = webDriver.findElement(By.id("search_query_top"));
        webElement.sendKeys("dress");
        webElement = webDriver.findElement(By.cssSelector("button.btn:nth-child(5)"));
        webElement.click();
        Thread.sleep(1000);
    }

    @When("I add that item to my basket")
    public void iAddThatItemToMyBasket() throws InterruptedException {
        webElement = webDriver.findElement(By.cssSelector("li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
        webElement.click();
        Thread.sleep(3000);

        webElement = webDriver.findElement(By.cssSelector("button.exclusive"));
        webElement.click();
        Thread.sleep(3000);

        webElement = webDriver.findElement(By.cssSelector("a.button-medium"));
        webElement.click();
        Thread.sleep(3000);
    }

    @Then("The item has been successfully added to my basket")
    public void theItemHasBeenSuccessfullyAddedToMyBasket() throws InterruptedException {
        webElement = webDriver.findElement(By.cssSelector(".standard-checkout"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.id("email"));
        webElement.sendKeys(email);

        webElement = webDriver.findElement(By.id("passwd"));
        webElement.sendKeys(password);

        webElement = webDriver.findElement(By.name("SubmitLogin"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.name("processAddress"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.cssSelector("#cgv"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.name("processCarrier"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.className("cheque"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.cssSelector("button.button-medium"));
        webElement.click();
        Thread.sleep(1000);

        webElement = webDriver.findElement(By.cssSelector(".alert"));
        assertEquals("Your order on My Store is complete.", webElement.getText());
    }

    @After
    public void teardown() {
        webDriver.close();
    }

    // Thanks Cameron :)) (https://github.com/CGuthrieQA/fashion-site-selenium-working)
    public void waitUntilLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2L);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }
}
