package com.qa.shoppingsite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/shopping website",
        glue = "com.qa.shoppingsite.stepdefs",
        plugin = {"pretty", "html:target/cucumber/reports/clothes-shop.html"})
public class ShoppingSiteTest {
}