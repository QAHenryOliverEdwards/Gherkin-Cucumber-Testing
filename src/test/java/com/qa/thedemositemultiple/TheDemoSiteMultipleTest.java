package com.qa.thedemositemultiple;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/thedemositemultiple",
        glue = "com.qa.thedemositemultiple.stepdefs",
        plugin = {"pretty"})
public class TheDemoSiteMultipleTest {
}
