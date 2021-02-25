package com.qa.shoppingsite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/shopping website",
        glue = "com.qa.shoppingsite.stepdefs")
public class ShoppingSiteTest {
}
